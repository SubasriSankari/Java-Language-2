import java.util.*;

class PropertiesObj{
	public static void main(String[] args){
		Properties prop = System.getProperties();
		printProperties(prop);

	}
	public static void printProperties(Properties prop){
		for(Object key: prop.keySet()){
			System.out.println(key + ":" + prop.getProperty(key.toString()));
		}
	}
}  