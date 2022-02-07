import java.io.*;
import java.util.*;
import java.text.*;


public class JavaApplication{
	
	static boolean status;	
	static boolean checkIsThisDateOrNot;

	public native void basedonDate(String Date,boolean status);
	public native void basedonUser(String User,boolean status);

	static{
		System.loadLibrary("native-lib");
	}
		
	public static String options(){
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("\nChoose your choice:\n");
		System.out.println("1.To View By Date");
		System.out.println("2.To View User");
		System.out.print("3.Exit\n\n -->");
		choice = sc.nextInt();
		
		switch(choice){
			case 1:
				System.out.println("Please enter Date in this format \"yyyy-mm-dd\"\n");
				String date = sc.next();
				checkIsThisDateOrNot = true;
				return date;
				
			case 2:
				System.out.println("Please enter the username to search:");
				String name = sc.next();
				checkIsThisDateOrNot = false;
				return name;
			case 3:
				System.out.println("\nThank You:)");
				System.exit(0);
			default:
				System.out.println("\nError You entered wrong key:(\n Try again... Bye\n\n");
				System.exit(1);
			
		}
		return null;
	}

	public static void main(String[] args){

		JavaApplication obj = new JavaApplication();
	
		System.out.println("\n\n\t....  Hello ....");
		Scanner sc = new Scanner(System.in);
		int choice;
		String str;
		do{
			System.out.println("\nChoose your choice:\n");
			System.out.println("1.To View Login Events");
			System.out.println("2.To View Logout Events");
			System.out.print("3.Exit\n\n -->");
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					status = true;
					str = options();
					if(checkIsThisDateOrNot)	
						obj.basedonDate(str,status);
					else
						obj.basedonUser(str,status);
					break;
				case 2:
					status = false;
					str = options();
					if(checkIsThisDateOrNot)	
						obj.basedonDate(str,status);
					else
						obj.basedonUser(str,status);
					break;
				case 3:
					System.out.println("\nThank You:)");
					System.exit(0);
				default:
					System.out.println("\nError You entered wrong key:(\n Try again... Bye\n\n");
					System.exit(1);
				
			}
 
		}while(choice!=0);
				
	}
}