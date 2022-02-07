import java.util.*;

class HashTable{
	public static void main(String[] args){
		Hashtable<Integer,String> map = new Hashtable<Integer,String>();
		map.put( 100, "Su");
		map.put( 200, "Ub");
		map.put( 300, "Ba");
		map.put( 400, "As");
		System.out.println("Initial Map " + map);
		map.putIfAbsent( 500, "Sri");
		System.out.println("Updated Map " + map);
	}
}
		