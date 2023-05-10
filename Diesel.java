
public class Diesel {

	private String origin;
	private double pricePerLiter;
	private double totalLiters;
	
	public Diesel(String origin, double pricePerLiter, double totalLiters) {
		this.origin=origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	
	public String toString() {
		return "\nDiesel...\n"+"The origin is: "+ origin +"\nPrice per liter is: "+ pricePerLiter +"\nTotal liters of this diesel is: "+ totalLiters + "\n";
	}
}