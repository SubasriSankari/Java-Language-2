import java.util.*;
import java.io.*;

public class PropertyFile{
	public static void main(String[] args)throws Exception{
		
		FileReader reader = new FileReader("data.properties");
		Properties p = new Properties();
		p.load(reader);
		
		System.out.println(p.getProperty("user"));
		System.out.println(p.getProperty("password"));
	}
}

/*import java.util.*;  
import java.io.*;  
public class PropertyFile {  
	public static void main(String[] args)throws Exception{  
  
		Properties p=new Properties();  
		p.setProperty("name","Sonoo Jaiswal");  
		p.setProperty("email","sonoojaiswal@javatpoint.com");  
  
		p.store(new FileWriter("info.properties"),"Javatpoint Properties Example");  
  
	}  
}*/