import java.util.*;
import java.io.*;

public class PropertyFileRemoveElem{
	public static void main(String[] args)throws Exception{
		
		FileReader reader = new FileReader("RemoveElement.properties");
		Properties p = new Properties();
		p.load(reader);
		
		System.out.println(p.getProperty("1"));
		System.out.println(p.getProperty("2"));
		p.remove("2");
		System.out.println(p.getProperty("2"));
	}
}