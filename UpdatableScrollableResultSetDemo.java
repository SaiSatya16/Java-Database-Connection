import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdatableScrollableResultSetDemo {

    public static void main(String[] args) {
        try {
            // Connect to your SQLite database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sample2.db");

            // Fetch the data into a list
            List<String> dataList = fetchData(connection);

            // Display initial records
            System.out.println("Initial records:");
            displayData(dataList);

            // Modify data in memory (for example, update a record)
            // Modify the dataList as needed...

            // Update the database based on the changes in memory
            updateDatabase(connection, dataList);

            // Display updated records
            System.out.println("\nRecords after updating:");
            displayData(dataList);

            // Close connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<String> fetchData(Connection connection) throws SQLException {
        List<String> dataList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Satya;");

        while (resultSet.next()) {
            String data = resultSet.getString("name");
            // Add fetched data to the list
            dataList.add(data);
        }

        resultSet.close();
        statement.close();

        return dataList;
    }

    private static void updateDatabase(Connection connection, List<String> dataList) throws SQLException {
        // Perform database update based on changes in dataList
        // For example, update the database with dataList modifications
        // You would typically use prepared statements for updates or inserts.
        // Iterate through dataList and update the database accordingly.
    }

    private static void displayData(List<String> dataList) {
        for (String data : dataList) {
            System.out.println(data);
            // Display other columns or data as needed
        }
    }
}
