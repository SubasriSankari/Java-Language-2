import java.util.*;

public class ReverseString{
	public static void main(String[] args){

		StringBuffer str = new StringBuffer();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string: ");
		str.append(input.nextLine());
		System.out.println("String before reverse -> "+str);
		System.out.println("String after reverse -> "+str.reverse());
	}
}
