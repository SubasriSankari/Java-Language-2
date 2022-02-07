class PassByValue{
	int val = 50;
	void change(int val){
		val += 100;
	}
	public static void main(String[] args){
		PassByValue obj = new PassByValue();
		System.out.println("Before Call "+ obj.val);
		obj.change(20);
		System.out.println("After Call "+ obj.val);
	}
}
