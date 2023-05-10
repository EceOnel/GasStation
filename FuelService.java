
abstract class FuelService extends Service{
//since we do not create a FuelService object with new command I made it abstract as well.
	protected double litersBought;
	
	public FuelService(String carPlate,double litersBought) {
		super(carPlate);
		this.litersBought = litersBought;
	}
	
	void displayServiceInfo() {
		System.out.print("Bought "+ litersBought + " liters"+".");
		super.displayServiceInfo();
	}
	@Override
	double makeTransaction(double price){
		price=super.makeTransaction(price);
		return price;
	}
	

}
