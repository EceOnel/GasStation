
public class CarWash extends Service {
	
	private final static double basePrice = 10.0;
	
	public CarWash(String CarPlate){
		super(CarPlate);
	}
	
	@Override
	void displayServiceInfo() {
		System.out.print("\nCar Wash Service...\nCar Plate is "+ super.getCarPlate());
		System.out.print(".\nThe revenue from this service is "+ basePrice + ".\n");
	}
	
	@Override
	public double calculate() {
		System.out.print("CarWash: " + basePrice + "\n");
		return basePrice;
	}

}
