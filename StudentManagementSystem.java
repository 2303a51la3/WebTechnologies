import java.sql.*;

public class StudentManagementSystem {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentDB"; // Corrected URL
        String user = "root";         
        String password = "Sathvika@02"; 
        String query = "SELECT * FROM Students"; 

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database successfully!\n");

            // Select the database (if not included in URL)
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("USE studentDB"); // Ensures the correct database is selected

            // Execute Query
            ResultSet rs = stmt.executeQuery(query);

            // Print Student Records
            System.out.println("Student Records:");
            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String major = rs.getString("Major");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Major: " + major);
            }

            // Print Table Metadata
            System.out.println("\nTable Metadata:");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + metaData.getColumnName(i) + " (" + metaData.getColumnTypeName(i) + ")");
            }            

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }
}
