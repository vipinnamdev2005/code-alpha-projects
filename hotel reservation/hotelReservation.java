import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    int id;
    int price;
    String roomType;
    String status;

    Hotel(int roomId, int price, String roomType, String status) {
        this.id = roomId;
        this.price = price;
        this.roomType = roomType;
        this.status = status;
    }
}

class Reserve {
    String name;
    int mobile;
    int id;

    Reserve(String name, int mobile, int id) {
        this.name = name;
        this.mobile = mobile;
        this.id = id;
    }
}

public class hotelReservation {
    static ArrayList<Hotel> list = new ArrayList<>();
    static ArrayList<Reserve> user = new ArrayList<>();

    public static void main(String[] args) {
        // Rooms are added only once
        list.add(new Hotel(101, 1200, "lower", "Available"));
        list.add(new Hotel(102, 1200, "lower", "Available"));
        list.add(new Hotel(103, 1200, "lower", "Available"));
        list.add(new Hotel(201, 2000, "medium", "Available"));
        list.add(new Hotel(202, 2000, "medium", "Available"));
        list.add(new Hotel(203, 2000, "medium", "Available"));
        list.add(new Hotel(301, 3000, "standard", "Available"));
        list.add(new Hotel(302, 3000, "standard", "Available"));
        list.add(new Hotel(303, 3000, "standard", "Available"));

        select();
    }

    static void select() {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.println("\n1. Show Room Type");
            System.out.println("2. View Available Room");
            System.out.println("3. Book Room");
            System.out.println("4. View Booking Details");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");
            num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    showRoom();
                    break;
                case 2:
                    Available();
                    break;
                case 3:
                    reservation();
                    break;
                case 4:
                    bookingDetails();
                    break;
                case 5:
                    cancle();
                    break;
                case 6:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Enter correct number");
            }
        } while (num != 6);
    }

    static void cancle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Room Number: ");
        int id = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < user.size(); i++) {
            Reserve r = user.get(i);

            if (r.id == id) {
                for (Hotel h : list) {
                    if (h.id == id) {
                        h.status = "Available";
                        break;
                    }
                }

                user.remove(i);
                found = true;
                saveData();
                System.out.println("Your booking is cancelled");
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found");
        }
    }

    static void bookingDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Mobile Number: ");
        int mobile = sc.nextInt();
        boolean found = false;

        for (Reserve r : user) {
            if (r.mobile == mobile) {
                System.out.println("Name: " + r.name);
                System.out.println("Mobile: " + r.mobile);
                System.out.println("Room Number: " + r.id);

                for (Hotel h : list) {
                    if (h.id == r.id) {
                        System.out.println("Room Type: " + h.roomType);
                        System.out.println("Rent: " + h.price);
                        break;
                    }
                }
                found = true;
            }
        }

        if (!found) {
            System.out.println("No booking found");
        }
    }

    static void Available() {
        for (Hotel h : list) {
            if (h.status.equals("Available")) {
                System.out.println(
                    "Room: " + h.id + " | Type: " + h.roomType +
                    " | Rent: " + h.price
                );
                
            }
        }
    }

    static void reservation() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Your name: ");
        String name = sc.nextLine();

        System.out.print("Your mobile number: ");
        int mobile = sc.nextInt();

        Available();
        System.out.print("Enter Room Number: ");
        int roomNumber = sc.nextInt();

        for (Hotel h : list) {
            if (h.id == roomNumber) {
                if (h.status.equals("Available")) {
                    h.status = "Booked";
                    user.add(new Reserve(name, mobile, h.id));
                    saveData();

                    System.out.println("Your Room is Booked");
                    System.out.println("Your ID: " + h.id);
                    System.out.println("Rent: " + h.price);
                    return;
                } else {
                    System.out.println("Room is already booked");
                    return;
                }
            }
        }

        System.out.println("Room number not found");
    }

    static void saveData() {
        try {
            FileWriter writer = new FileWriter("data.txt");

            for (Reserve r : user) {
                writer.write(r.name + "|" + r.mobile + "|" + r.id + "\n");
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    static void showRoom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Lower");
        System.out.println("2. Medium");
        System.out.println("3. Standard");
        System.out.print("Select Room Type: ");
        int num = sc.nextInt();
        System.out.println();

        switch (num) {
            case 1:
                System.out.println("Rent: 1200");
                System.out.println("Rooms: 101-103");
                System.out.println("Single Bed, Single AC");
                break;
            case 2:
                System.out.println("Rent: 2000");
                System.out.println("Rooms: 201-203");
                System.out.println("Double Bed, Single AC");
                break;
            case 3:
                System.out.println("Rent: 3000");
                System.out.println("Rooms: 301-303");
                System.out.println("Double Bed, Single AC, TV");
                break;
            default:
                System.out.println("Enter correct number");
        }
    }
}