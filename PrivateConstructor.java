class NewPrivate{
	private PrintName(){
		return "Suba";
	}
}

public class PrivateConstructor{
	public static void main(String[] args){
		NewPrivate name = NewPrivate();
		System.out.println("Name is "+name.PrintName());
	}
}