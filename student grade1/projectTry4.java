import java.util.ArrayList;
import java.util.Scanner;

public class projectTry4 {
    public static void main(String[] args) {
        student();
    }

    static void student() {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Float> marks = new ArrayList<>();

        String choice = "";

        System.out.println("agar student enter nahi karna to exit type kare");

        while (true) {

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Student Marks: ");
            float mark = sc.nextFloat();

            names.add(name);
            marks.add(mark);

            sc.nextLine();

            System.out.println("Agar entry band karni hai to no likhe, warna Enter dabaye");
            choice = sc.nextLine();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        if (marks.isEmpty()) {
            System.out.println("No student data available.");
            sc.close();
            return;
        }

        System.out.println("\n----------- HIGHEST STUDENTS -----------");

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) > 75) {
                System.out.println("Student Name: " + names.get(i));
                System.out.println("Marks: " + marks.get(i));
                System.out.println("Grade: A");
                System.out.println("---------------------------------------");
            }
        }

        System.out.println("\n----------- AVERAGE STUDENTS -----------");

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) > 50 && marks.get(i) < 75) {
                System.out.println("Student Name: " + names.get(i));
                System.out.println("Marks: " + marks.get(i));
                System.out.println("Grade: B");
                System.out.println("---------------------------------------");
            }
        }

        System.out.println("\n----------- LOWEST STUDENTS -----------");

        for (int i = 0; i < marks.size(); i++) {
            if (marks.get(i) >= 33 && marks.get(i) <= 50) {
                System.out.println("Student Name: " + names.get(i));
                System.out.println("Marks: " + marks.get(i));
                System.out.println("Grade: C");
                System.out.println("---------------------------------------");
            }
        }

        System.out.println("\n----------- SUMMARY OF ALL STUDENTS -----------");

        for (int i = 0; i < marks.size(); i++) {

            System.out.println("Student Name: " + names.get(i));
            System.out.println("Marks: " + marks.get(i));

            if (marks.get(i) > 75) {
                System.out.println("Grade: A");
            } else if (marks.get(i) > 50 && marks.get(i) < 75) {
                System.out.println("Grade: B");
            } else if (marks.get(i) >= 33 && marks.get(i) <= 50) {
                System.out.println("Grade: C");
            } else {
                System.out.println("Grade: Fail");
            }

            System.out.println("-----------------------------------------------");
        }

        sc.close();
    }
}