import java.sql.*;
import java.util.Scanner;

public class Customer {

    public static void addCustomer() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Customer ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Customer Name: ");
            String name = sc.nextLine();

            System.out.print("Address: ");
            String address = sc.nextLine();

            String query =
                    "insert into customer values(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, address);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Customer Added Successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewCustomers() {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("select * from customer");

            System.out.println("\nCustomer Details");

            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + "  "
                                + rs.getString(2) + "  "
                                + rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}