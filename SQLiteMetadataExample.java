import java.sql.*;

public class SQLiteMetadataExample {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample2.db"; // Replace with your SQLite database file path

        try (Connection connection = DriverManager.getConnection(url)) {
            DatabaseMetaData metaData = connection.getMetaData();

            // Get database information
            System.out.println("Database Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

            // Get tables information
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("Tables:");
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println(tableName);
            }

            // Get columns information for a specific table
            String tableName = "your_table_name";
            ResultSet columns = metaData.getColumns(null, null, tableName, "%");
            System.out.println("Columns for " + tableName + ":");
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                String columnType = columns.getString("TYPE_NAME");
                int columnSize = columns.getInt("COLUMN_SIZE");
                System.out.println(columnName + " - Type: " + columnType + ", Size: " + columnSize);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
