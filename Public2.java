package pub2;
import pub1.*;

class Public2{
	public static void main(String[] args){
		Public1 obj = new Public1();
		System.out.println(obj.addition(10,20));
	}
}