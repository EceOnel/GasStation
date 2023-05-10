import java.util.Comparator;

public class Service implements Profitable, Comparable<Service>{
	private String carPlate;
	private double revenue;
	
	public Service(String carPlate) {
		this.carPlate = carPlate;
	} 
	
	void displayServiceInfo() {
		System.out.print("\nCar Plate is " + carPlate + "."+"\nThe revenue from this service is " + revenue+".\n");
	}
		
	double makeTransaction(double price){
		this.revenue = price;
		return revenue;
	}


	@Override
	public double calculate() {
		if(revenue >= 0) {
			return revenue;
		}
		else {
			return -revenue; 
		}	
	}
	
	public String getCarPlate() {
		return carPlate;
	}

	@Override
	public int compareTo(Service s) {
		return (int) (this.revenue - s.revenue);
	}

}

class CarPlateComparator implements Comparator<Service>{
	
	@Override
	public int compare(Service s1, Service s2) {
		return s1.getCarPlate().compareTo(s2.getCarPlate());
	}
	
	
}