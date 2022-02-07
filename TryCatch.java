import java.io.*;

class TryCatch{
	public static void main(String[] args){
		String str = "Suba";
		try{
			System.out.println(getLength(str));
		}
		catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException caught");
		}

		str = " ";
		try{
			System.out.println(getLength(str));
		}
		catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException caught");
		}

		str = null;
		try{
			System.out.println(getLength(str));
		}
		catch(IllegalArgumentException e){
			System.out.println("IllegalArgumentException caught");
		} 
	}
	public static int getLength(String str){
		if(str == null)
			throw new IllegalArgumentException("The Argument cannot be null");
		return str.length();
	}
}