import java.sql.*;

public class CRUD_Example{

    static Connection con = null;
	static PreparedStatement ps = null;

    static void makeConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customertable","root","Suba@2000");
            System.out.println("Connected Successfully!!");
        }catch(Exception e){
            System.out.print(e);
        }
    }

    static void select(){
        try{
            
			ps = con.prepareStatement("select * from userreg");   
			ResultSet rs = ps.executeQuery();  
			while(rs.next()){
				System.out.println("UserName " + rs.getString(1) + " Password " + rs.getString(2));
			}	
        }catch(Exception e){
            System.out.print(e);
        }
    }

    static void insert(String name, String pass){
        try{
            
			ps = con.prepareStatement("insert into userreg values(?,?)");   
			ps.setString(1,name);  
      		ps.setString(2,pass);
			ps.execute();  
				
        }catch(Exception e){
            System.out.print(e);
        }
    }

    static void delete(String name){
        try{
            
			ps = con.prepareStatement("delete from userreg where name = ?");   
			ps.setString(1,name);  
			ps.execute();  
				
        }catch(Exception e){
            System.out.print(e);
        }
    }

    static void update(String name, String pass){
        try{
            
			ps = con.prepareStatement("update userreg set pass = ? where name = ?");   
			ps.setString(1,pass);  
      		ps.setString(2,name);
			ps.execute();  
				
        }catch(Exception e){
            System.out.print(e);
        }
    }

    public static void main(String[] args)
    {
        makeConnection();
        System.out.println("\n~~~~~ Select from table: ~~~~~ ");
        select(); 
        insert("keerthi", "keer@123");
        insert("prathi","prathi@123");
        System.out.println("\n~~~~~ After insertion of the table is: ~~~~~");
        select();
        update("Subasri", "7810045325");
        System.out.println("\n~~~~~ After updation of the table is: ~~~~~ ");
        select();
        delete("tom");
        System.out.println("\n~~~~~ After deletion of the table is: ~~~~~ ");
        select();

    }
}