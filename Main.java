import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Electricity Billing System =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Generate Bill");
            System.out.println("3. View Customers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Customer.addCustomer();
                    break;

                case 2:
                    BillingService.generateBill();
                    break;

                case 3:
                    Customer.viewCustomers();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}