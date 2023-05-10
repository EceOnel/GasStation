
public class DieselService extends FuelService{
	
	private boolean discountedAntiFreeze;
	private int discountedAntiFreezeCount;
	private double discountedAntiFreezePrice;
	
	public DieselService(String carPlate,double litersBought,boolean discountedAntiFreeze,int discountedAntiFreezeCount){
		super(carPlate,litersBought);
		this.discountedAntiFreeze = discountedAntiFreeze;
		this.discountedAntiFreezeCount = discountedAntiFreezeCount;
	}
	
	void displayServiceInfo() {
		System.out.println("\nDiesel Service...");
		super.displayServiceInfo();
		if (discountedAntiFreeze == true) {
			System.out.println("\nBought " + discountedAntiFreezeCount + " discounted anti-freezer");
		}
		else {
			//System.out.println("\nBought 0 discounted anti-freezer");
			//I added this to give information but since the output does not contain this info I took it to command line
		} 
		 
	} 
	@Override
	double makeTransaction(double price){
		discountedAntiFreezePrice = 25;
		if (discountedAntiFreeze == true) {
		price = price* litersBought + discountedAntiFreezePrice * discountedAntiFreezeCount;
		}
		else{
		price = price*litersBought;
		}
		super.makeTransaction(price);
		return price;
	}
	
	@Override
	public double calculate() {
		System.out.print("DieselService: " + super.calculate() + "\n");
		return  super.calculate();
	}
}