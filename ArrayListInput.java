import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListInput{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String j;
		for(int i = 0 ; i < 6 ; i++ ){
			//j = sc.nextLine();
			list.add(sc.nextLine());
		}
		System.out.println(list);
	}
}
		