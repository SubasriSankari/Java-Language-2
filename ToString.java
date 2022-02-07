class Employee{
	int idNum;
	String name;
	String workingAt;
	
	Employee(int idNum, String name, String workingAt){
		this.idNum = idNum;
		this.name = name;
		this.workingAt = workingAt;
	}
	public String toString(){
		return idNum + " " + name + " " + workingAt;
	}
}

public class ToString{
	public static void main(String[] args){
		Employee emp1 = new Employee(100, "Kumar", "Work From Home");
		Employee emp2 = new Employee(101, "Vijay", "In Office");
		Employee emp3 = new Employee(102, "Nathan", "Work From Home");
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
	}
}
