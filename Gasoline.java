
public class Gasoline {

	private String origin;
	private double pricePerLiter;
	private double totalLiters;
	
	public Gasoline(String origin, double pricePerLiter, double totalLiters) {
		this.origin=origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	
	public String toString() {
		return "\nGasoline...\n"+"The origin is: "+ origin +"\nPrice per liter is: "+ pricePerLiter +"\nTotal liters of this gasoline is: "+ totalLiters + "\n";
	}
	
}
