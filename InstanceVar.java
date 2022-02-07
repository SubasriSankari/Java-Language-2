class InstVar
{
	int x = 10;           // Instance Var
	String str = "Suba";
}

public class InstanceVar{
	public static void main(String[] args){
		InstVar obj = new InstVar();  
		System.out.println(obj.x);
		System.out.println(obj.str);
		obj.x = 15;
		obj.str = "Subasri";
		System.out.println(obj.x);
		System.out.println(obj.str);
	}
}