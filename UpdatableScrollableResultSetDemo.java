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
            Connection connection = DriverManager.getConnection("jdbc:sqlite:sample3.db");
           

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
        String name1 = dataList.get(0);
        String name2 = dataList.get(1);
    
        // Fetch rows for IDs 1 and 2
        // Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

        // ResultSet resultSet = statement.executeQuery("SELECT * FROM Satya WHERE id IN (1, 2)");
    
        // // Update the names after moving to the respective rows
        // while (resultSet.next()) {
        //     int id = resultSet.getInt("id");
        //     if (id == 1) {
        //         resultSet.updateString("name", name2);
        //         resultSet.updateRow();
        //     } else if (id == 2) {
        //         resultSet.updateString("name", name1);
        //         resultSet.updateRow();
        //     }
        // }
    
        // resultSet.close();
        // statement.close();

        Statement statement = connection.createStatement();
        String updateQuery = "UPDATE Satya SET name = '" + name2 + "' WHERE id = 1; " +
                            "UPDATE Satya SET name = '" + name1 + "' WHERE id = 2;";
        statement.executeUpdate(updateQuery);

    
        System.out.println("Database updated successfully!");
    }
    

    private static void displayData(List<String> dataList) {
        for (String data : dataList) {
            System.out.println(data);
            // Display other columns or data as needed
        }
    }
}
