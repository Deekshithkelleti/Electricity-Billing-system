import java.sql.*;
import java.util.Scanner;

public class BillingService {

    public static void generateBill() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Customer ID: ");
            int id = sc.nextInt();

            System.out.print("Units Consumed: ");
            int units = sc.nextInt();

            double amount;

            if (units <= 100) {
                amount = units * 2.0;
            }
            else if (units <= 300) {
                amount = units * 3.5;
            }
            else {
                amount = units * 5.0;
            }

            String query =
                    "insert into bill(customer_id,units,amount) values(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setInt(2, units);
            ps.setDouble(3, amount);

            ps.executeUpdate();

            System.out.println("\nBill Generated Successfully!");
            System.out.println("Total Amount = ₹" + amount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}