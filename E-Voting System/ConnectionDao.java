import java.sql.*;
import java.util.*;
import java.text.*;

public class ConnectionDao {
	
	static Connection con = null;
	static PreparedStatement ps = null;

	public static void makeConnection(){
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_voting_system","root","Suba@2000");
		}catch(Exception e){
			System.out.print(e);
		}
 	} 
	
	public static boolean addVoteNow(int aadhar, String party){
		boolean status = false;
		try{
			ps = con.prepareStatement("insert into to_vote values(?,?)");
			ps.setInt(1,aadhar);  
      		ps.setString(2,party);
			ps.execute(); 

			ps = con.prepareStatement("update parties_list set count = (select count(*) from to_vote where parties_list.party_name = to_vote.party_name) order by count DESC");
			ps.execute();

			status = true;

		}catch(Exception e)
		{
			System.out.println("\nSorry You voted already..\n");
		}
		return status;
	}

	public static HashMap<String, Integer> findWinner(){
		HashMap<String, Integer> winner = new HashMap<>();
		try{
			ps = con.prepareStatement("select party_name, max(count) from parties_list");   
			ResultSet rs = ps.executeQuery();  
			while(rs.next()){
				winner.put(rs.getString("party_name"), rs.getInt(2));
			}	
		}catch(Exception e){
			System.out.println(e);			
		}
		return winner;
	}

	public static HashMap<String, Integer> findLooser(){
		HashMap<String, Integer> looser = new HashMap<>();
		try{
			ps = con.prepareStatement("select party_name, count from parties_list where count < (select max(count) from parties_list) order by count DESC LIMIT 1");   
			ResultSet rs = ps.executeQuery();  
			while(rs.next()){
				looser.put(rs.getString("party_name"), rs.getInt(2));
			}	
		}catch(Exception e){
			System.out.println(e);			
		}
		return looser;
	}

}
