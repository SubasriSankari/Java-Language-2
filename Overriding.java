class OverridingChild{
	public void printing(){
		System.out.println("This is Child Class");
	}
}


class Overriding extends OverridingChild{
	public void printing(){
		System.out.println("This is Parent Class");
	}
	
	public static void main(String[] args){
		Overriding obj = new Overriding();
		obj.printing();
	}
}