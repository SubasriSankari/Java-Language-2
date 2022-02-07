import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class VectorObjectInput{
    public static void main(String[] args) {
        int size;
        Vector<String> strVec = new Vector<>();
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter the size of list: ");
        size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter a string value for position " + (i + 1) + " : ");
            strVec.add(sc.next());
        }
        System.out.println("You have entered: ");
        Enumeration<String> enumeration = strVec.elements();
        while(enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}