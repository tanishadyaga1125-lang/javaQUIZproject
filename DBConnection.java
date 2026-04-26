import java.sql.*;

 class DBConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/online_quiz",
                "root",
                "112508" 
            );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}