
public class Personnel extends Person{

	private int jobCount;

	public Personnel(String name, String surname) {
		super(name,surname);
	}

	public void incJobCount() {
		jobCount++;
	}
	
	public double calculate() {
		System.out.print("Personnel: "+-(super.calculate()+(double)jobCount*(1.5))+"\n");
		return -(super.calculate()+jobCount*(1.5));
	}
	
}
