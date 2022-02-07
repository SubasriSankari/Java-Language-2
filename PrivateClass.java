class Private{
	private int val = 10;
}

public class PrivateClass{
	public static void main(String[] args){
		Private obj = new Private();
		System.out.println(obj.val);
	}
}