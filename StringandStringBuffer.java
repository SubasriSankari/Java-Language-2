public class StringandStringBuffer{
	public static void main(String[] args){
		String str1 = "String";
		System.out.println(str1.hashCode());
		str1 = str1 + "newString";
		System.out.println(str1.hashCode());
		
		StringBuffer str2 = new StringBuffer("StringBuffer");
		System.out.println(str2.hashCode());
		str2.append("newString");
		System.out.println(str2.hashCode());
		
	}
}