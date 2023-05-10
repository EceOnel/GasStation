
abstract class Person implements Profitable {
	
	private String name;
	private String surname;
	private double salary = 100.0;
	
	public Person(String name, String surname) {
		this.name = name;
		this.surname =surname;
	}
	
	public void displayInformation() { 
		System.out.print("Name: "+ name + "\n");
		System.out.print("Surname: "+ surname + "\n");	
		}
	
	@Override
	public double calculate() {
		return salary;
	}
}
 