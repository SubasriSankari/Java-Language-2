class Multiply{
	static int mul(int a, int b){
		return a*b;
	}
	static double mul(double a, double b){
		return a*b;
	}
}

class OverLoading{
	public static void main(String[] args){
		System.out.println( Multiply.mul( 2 , 3 ));
		System.out.println( Multiply.mul(4.5 , 6.9));
	}
}