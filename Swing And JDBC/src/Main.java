import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM customers")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String lastName = resultSet.getString("customer_last_name");
                String firstName = resultSet.getString("customer_first_name");
                String phone = resultSet.getString("customer_phone");
                customers.add(new Customer(id, lastName, firstName, phone));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        new CustomerViewer(customers);
    }
}