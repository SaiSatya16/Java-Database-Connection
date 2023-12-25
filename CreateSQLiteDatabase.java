    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.Statement;

public class CreateSQLiteDatabase {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // SQLite database file path
            String url = "jdbc:sqlite:sample3.db"; // Replace with your desired database file path

            // Establish connection
            connection = DriverManager.getConnection(url);
            System.out.println("SQLite database connected successfully!");

            // Create a statement
            statement = connection.createStatement();

            // SQL command to create a new table
            String createTableQuery = "CREATE TABLE IF NOT EXISTS Satya ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "name TEXT NOT NULL,"
                    + "age INTEGER"
                    + ");";

            // Execute the SQL command to create a table
            statement.execute(createTableQuery);
            System.out.println("Table created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
