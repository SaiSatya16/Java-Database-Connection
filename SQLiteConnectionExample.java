import java.sql.*;

public class SQLiteConnectionExample {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // SQLite connection string
            String url = "jdbc:sqlite:sample3.db"; // Replace with your SQLite database file path
            
            // Establish connection
            connection = DriverManager.getConnection(url);

            // Execute a query
            statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM Satya;";
            resultSet = statement.executeQuery(sqlQuery);

            // Process the result set
            while (resultSet.next()) {
                // Example: Print data from columns
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");  
                // Process retrieved data
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
