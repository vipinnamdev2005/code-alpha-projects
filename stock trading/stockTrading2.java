import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    String comName;
    int price;

    Stock(String comName, int price) {
        this.comName = comName;
        this.price = price;
    }
}

class User {
    int balance;

    User(int balance) {
        this.balance = balance;
    }
}

public class stockTrading2 {

    static ArrayList<Stock> company = new ArrayList<>();
    static ArrayList<User> price = new ArrayList<>();

    static String com;
    static int quan;

    public static void main(String[] args) {
        obj();
        buyStock();
        balance();
    }

    static void balance() {
        System.out.println(com + " Quantity: " + quan);
    }

    static void buyStock() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your Balance");
        int bal = sc.nextInt();

        for (Stock s : company) {
            System.out.println(s.comName);
            System.out.println(s.price);
            System.out.println();
        }

        System.out.println("Enter Company Name: ");
        String name = sc.next();

        System.out.println("Enter Quantity: ");
        quan = sc.nextInt();

        for (Stock s : company) {
            if (s.comName.equalsIgnoreCase(name)) {
                System.out.println(s.comName);

                int pri = s.price * quan;
                System.out.println(pri);

                bal = bal - pri;
                com = s.comName;

                System.out.println("booked");
                System.out.println("Remaining Balance: " + bal);
                break;
            }
        }
    }

    static void obj() {
        Stock s1 = new Stock("TATA", 1500);
        Stock s2 = new Stock("Wipro", 2500);
        Stock s3 = new Stock("Deloit", 3000);

        company.add(s1);
        company.add(s2);
        company.add(s3);
    }
}