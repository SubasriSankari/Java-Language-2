import java.sql.*;

public class CreateDatabase{
    static final String URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASSWORD = "Suba@2000";

    public static void main(String[] args) {

        try(
            Connection connection = DriverManager.getConnection( URL , USER , PASSWORD );
            Statement statement = connection.createStatement();)
        {		      
            String sql = "CREATE DATABASE sample_create1";
            statement.executeUpdate(sql);
            System.out.println("Database created successfully..."); 

        }catch(SQLException e) {
            e.printStackTrace();
        } 
    }
}