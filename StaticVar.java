class ClassStaticVar
{
	static int x = 10;           // Static Var
	static String str = "Suba";
}

public class StaticVar{
	public static void main(String[] args){
		ClassStaticVar obj = new ClassStaticVar();  //Class var
		System.out.println(obj.x);
		System.out.println(obj.str);
		obj.x = 15;
		obj.str = "Subasri";
		System.out.println(obj.x);
		System.out.println(obj.str);
	}
}