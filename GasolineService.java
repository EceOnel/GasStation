
public class GasolineService extends FuelService {
	
	private boolean hasCoupon;
	
	public GasolineService(String carPlate,double litersBought,boolean hasCoupon){
		super(carPlate,litersBought);
		this.hasCoupon = hasCoupon;
	}

	void displayServiceInfo() {
		System.out.println("\nGasoline Service...");
		super.displayServiceInfo();
		if (hasCoupon == true) {
			System.out.println("\nHas 10% discount coupon");
		}	 
	}
	
	@Override
	double makeTransaction(double price){
		double discountratio = 90.0/100.0; 
		if (hasCoupon == true) {
			price = price * litersBought * discountratio;
		}
		else {
			price *= litersBought;
		}
		price = super.makeTransaction(price);
		return price;
	}
	
	@Override
	public double calculate() {
		System.out.print("GasolineService: " + super.calculate()+"\n");
		return  super.calculate();
	}
	
	
}
