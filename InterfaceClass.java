public class InterfaceClass{
	public static void main(String[] args){
		Multiply3 mul3 = new Multiply3();
		Multiply4 mul4 = new Multiply4();
		for(int i = 1 ; i < 6 ; i++ )
			System.out.println(mul3.getMul());
		for(int i = 1 ; i < 6 ; i++ )
			System.out.println(mul4.getMul());
	}	
}

interface series{	//Interface
	int getMul();       //Method
}	

class Multiply3 implements series{
	int val = 0;
	public int getMul(){
		val += 3;
		return val;
	}
}

class Multiply4 implements series{
	int val = 0;
	public int getMul(){
		val += 4;
		return val;
	}
}