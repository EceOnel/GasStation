
public class Manager extends Person{
	
	public int jobYear;

	
	public Manager(String name, String surname, int jobYear) {
		super(name,surname);
		this.jobYear = jobYear;
	}
	
	public double calculate() {
		System.out.print("Manager: "+ -(super.calculate()+jobYear*(50)+200) + "\n");
		return 0-(super.calculate()+jobYear*(50)+200);
	}

}
