import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

enum MenuItem{
	First("1. Create a new station"),
	Second("2. Add gasoline to a station inventory"),
	Third("3. Add diesel to a station inventory"),
	Fourth("4. Display a station inventory"),
	Fifth("5. Sell gasoline to customer"),
	Sixth("6. Sell diesel to customer"),
	Seventh("7. Sell car wash"),
	Eight("8. Display sold services so far"),
	Ninth("9. Add personnel/manager to a station"),
	Tenth("10. Calculate net profit of a station"),
	Eleventh("11. Display sold services (sorted by plate)"),
	Tweleth("0. Exit");
	
	private final String Choice;
	
	MenuItem(String Menu_number){
		Choice = Menu_number;
	}
	
	String getChoice() {
		return Choice;
	}	
	public static void printMenu() {
		for (MenuItem a : MenuItem.values())
			System.out.println(a.getChoice());
	}
	
}

public class Station {

    private double averageGasolinePrice;
    private double totalGasolineInStation;
    private double averageDieselPrice;
    private double totalDieselInStation;
    private String stationName;
	private int ID;
	private Diesel[] dieselArray = new Diesel[10];
	private Gasoline[] gasolineArray = new Gasoline[10];
	// private Service[] serviceArray = new Service[10]; this array will hold the GasolineService and DieselService objects.
	private ArrayList<Service> serviceArrayList = new ArrayList<Service>(); // since I cannot do collections sort to an array I turned it into a ArrayList
	private ArrayList<Person>personList = new ArrayList<Person>();
	private ArrayList<Profitable> profitCalculate = new ArrayList<Profitable>();
	private int personCount = 0;
	private  double totalOfAllGasolineCosts = 0; 
	private  double totalOfallDieselCosts = 0;
	private int gasolinenumber = 0;
	private int dieselnumber = 0;
	private int servicenumber = 0;
	private static Scanner myScanner = new Scanner(System.in);
	private static Scanner myScannerString = new Scanner(System.in);

	public Station (String stationName, int ID) {
		this.stationName = stationName;
		this.ID = ID;
	}
	
	public static Station createStation() {;
		System.out.print("Please enter the name of the Station: ");
		String stationName = myScannerString.nextLine(); 
		int ID = 0;
		while(true){
			
			try{
				System.out.print("Please enter the Station ID: "); 
				ID = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		Station createdstation = new Station(stationName,ID);
		return createdstation;
	} 
	
	public static void findStationAndAddGasoline(Station[] stationArray) {
		int writenid;
		double pricePerLiter;
		double totalLiters;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to search: ");
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
					System.out.print("\nPlease enter the origin of gasoline: ");
					String origin = myScannerString.nextLine();
					myScanner.useLocale(Locale.US);//my computer is using Tr locale to use . I needed to add this line
					while(true){
						
						try{
							System.out.print("Please enter the price per liter: ");
							pricePerLiter = myScanner.nextDouble();
							break;
						}catch(InputMismatchException Double) {
							System.err.println("price should be a double...");
							myScanner.nextLine();
						}
					}
					while(true){
						
						try{
						System.out.print("Please enter the total shipment volume in liter: ");
						 totalLiters = myScanner.nextDouble();
							break;
						}catch(InputMismatchException Double) {
							System.err.println("Total liters should be a double...");
							myScanner.nextLine();
						}
					}
					e.gasolineArray[e.gasolinenumber] = new Gasoline(origin,pricePerLiter,totalLiters);
					e.gasolinenumber++;
					//System.out.println("Gasoline number ........: " + e.gasolinenumber);
					e.totalOfAllGasolineCosts += ( totalLiters * pricePerLiter);
					e.totalGasolineInStation += totalLiters;
					e.averageGasolinePrice = e.totalOfAllGasolineCosts/e.totalGasolineInStation;
					System.out.print("\nThe total gasoline liters in Station #"+ writenid + " is " + e.totalGasolineInStation);
					System.out.print("\nThe average gasoline price in Station #"+ writenid + " is " + e.averageGasolinePrice + "\n");
					found = 1;
					break;
				}
			else continue;
		}
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
	}
	
	public static void findStationAndAddDiesel(Station[] stationArray) {
		int writenid2;
		double pricePerLiter;
		double totalLiters;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to search: ");
				writenid2 = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid2 == e.ID) {
					System.out.print("\nPlease enter the origin of Diesel: ");
					String origin = myScannerString.nextLine();
					myScanner.useLocale(Locale.US);
					while(true){
						
						try{
							System.out.print("Please enter the price per liter: ");
							pricePerLiter = myScanner.nextDouble();
							break;
						}catch(InputMismatchException Double) {
							System.err.println("price should be a double...");
							myScanner.nextLine();
						}
					}
					while(true){
						
						try{
						System.out.print("Please enter the total shipment volume in liter: ");
						 totalLiters = myScanner.nextDouble();
							break;
						}catch(InputMismatchException Double) {
							System.err.println("Total liters should be a double...");
							myScanner.nextLine();
						}
					}
					e.dieselArray[e.dieselnumber] = new Diesel(origin,pricePerLiter,totalLiters);
					e.dieselnumber++;
				    e.totalOfallDieselCosts += ( totalLiters * pricePerLiter);
					e.totalDieselInStation += totalLiters;
					e.averageDieselPrice = e.totalOfallDieselCosts/e.totalDieselInStation;
					System.out.print("\nThe total diesel liters in Station #"+ writenid2 + " is " + e.totalDieselInStation);
					System.out.print("\nThe average diesel price in Station #"+ writenid2 + " is " + e.averageDieselPrice + "\n");
					found = 1; 
					break;
			} 
			else continue;
		}
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
	}
	
	
	public static void displayStationInventory(Station[] stationArray) {
		int writenid3;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to display: ");
				writenid3 = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) { 
			if (e == null) break;
			else if (writenid3 == e.ID) {
					System.out.print("\nDisplaying the inventory of Station #"+ writenid3 +"\n");
					for( Gasoline g : e.gasolineArray){
						if(g != null) {
							System.out.print(g.toString());
						}
					}
					
					System.out.print("\nThe total gasoline liters in Station #"+ writenid3 + " is " + e.totalGasolineInStation);
					System.out.print("\nThe average gasoline price in Station #"+ writenid3 + " is " + e.averageGasolinePrice + "\n");
					
					for( Diesel d : e.dieselArray){
						if(d != null) {
						System.out.print(d.toString());
						}
					}	
					
					System.out.print("\nThe total diesel liters in Station #"+ writenid3 + " is " + e.totalDieselInStation);
					System.out.print("\nThe average diesel price in Station #"+ writenid3 + " is " + e.averageDieselPrice + "\n");
					
					found = 1; 
					break; 
			} 
			else continue;
			}
			if (found != 1) {
				System.out.print("\nNo station found with the given ID!\n");
			}		
	}
	
	//for removing class variable stationName never used warning. Aslo for checking the names of the stations.
	 public String getStationName() {
		 return stationName;
	 }

	public static void sellGasoline(Station[] stationArray) {
		int writenid4;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
				writenid4 = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		boolean hasCoupon = false;
		double litersBought;
		String carPlate;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid4 == e.ID) {
				while(true) {
					System.out.print("\nPlease enter the car plate: ");
					carPlate = myScannerString.nextLine();
						try {
							authenticateCarPlate(carPlate);
							break;
						} catch (Exception e1) {
							System.err.println("Please enter a valid Car Plate...");
						}
					}
				while(true){
					try{
						System.out.print("Please enter the gasoline liter: ");
						litersBought = myScanner.nextDouble();
						break;
					}catch(InputMismatchException Double) {
						System.err.println("Liter should be a double...");
						myScanner.nextLine();
					}
				}
				
				if(litersBought < e.totalGasolineInStation){
					System.out.print("Please enter if you have a coupon (y/n): ");
					if(myScannerString.nextLine().charAt(0) == 'y') {
						hasCoupon = true;
					}
					else hasCoupon = false;
					
					System.out.print("Personnel that helped during this service: \n");
					while(true) {
						Random rand = new Random();
						int selectedPerson = rand.nextInt(e.personCount); 
						if(e.personList.get(selectedPerson).getClass() == Personnel.class) {
							Personnel p = (Personnel) e.personList.get(selectedPerson);
							if(p != null) {
								p.displayInformation();
								p.incJobCount();
								break;
							}
							else continue;
						}
						else continue;
					}
					
					GasolineService gasolineService = new GasolineService (carPlate,litersBought,hasCoupon);
					//I turn these lines so that they can be compatible with arraylist
					//e.serviceArray[e.servicenumber]= gasolineService; 
					e.serviceArrayList.add(gasolineService);
					e.profitCalculate.add(gasolineService);
					//e.serviceArray[e.servicenumber].makeTransaction(e.averageGasolinePrice); 
					e.serviceArrayList.get(e.servicenumber).makeTransaction(e.averageGasolinePrice);
					e.servicenumber++;
					e.totalGasolineInStation -= litersBought;
					found = 1;
					break;
					
				}
				else {
					System.out.println("Not enough gasoline in the station!");
					found = 1;
					break;
				}
				
			} 
			else continue;
			}
			if (found != 1) {
				System.out.print("\nNo station found with the given ID!\n");
			}		
	}
			
 
	
	//6
	public static void sellDiesel(Station[] stationArray){
		int writenid4;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
				writenid4 = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		int discountedAntiFreezeCount = 0; 
		boolean discountedAntiFreeze = false;
		double litersBought; 
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid4 == e.ID) {
				String carPlate;
				while(true) {
				System.out.print("\nPlease enter the car plate: ");
				carPlate = myScannerString.nextLine();
					try {
						authenticateCarPlate(carPlate);
						break;
					} catch (Exception e1) {
						System.err.println("Please enter a valid Car Plate...");
					}
				}
				while(true){
					try{
						System.out.print("Please enter the diesel liter: ");
						litersBought = myScanner.nextDouble();
						break;
					}catch(InputMismatchException Double) {
						System.err.println("Liter should be a double...");
						myScanner.nextLine();
					}
				}
				if(litersBought < e.totalDieselInStation){
					System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
					if(myScannerString.nextLine().charAt(0) == 'y') {
						discountedAntiFreeze = true;
						System.out.print("Please enter how many anti-freeze you want: ");
						discountedAntiFreezeCount = myScanner.nextInt();
					}
					else discountedAntiFreeze= false;
					
					System.out.print("Personnel that helped during this service: \n");
					while(true) {
						Random rand = new Random();
						int selectedPerson = rand.nextInt(e.personCount); 
						if(e.personList.get(selectedPerson).getClass() == Personnel.class) {
							Personnel p = (Personnel) e.personList.get(selectedPerson);
							if(p != null) {
								p.displayInformation();
								p.incJobCount();
								break;
							}
							else continue;
						}
						else continue;
					}
					
					DieselService DieselService = new DieselService(carPlate,litersBought,discountedAntiFreeze,discountedAntiFreezeCount);
					//e.serviceArray[e.servicenumber]= DieselService;
					e.serviceArrayList.add(DieselService);
					e.profitCalculate.add(DieselService);
					//e.serviceArray[e.servicenumber].makeTransaction(e.averageDieselPrice);
					e.serviceArrayList.get(e.servicenumber).makeTransaction(e.averageDieselPrice);
					e.totalDieselInStation -= litersBought;
					e.servicenumber++;
					found = 1;
					break;
				}
				else {
					System.out.println("Not enough diesel in the station!");
					found = 1;
					break;
				}
				
			}
			else continue;
			}
			if (found != 1) {
				System.out.print("\nNo station found with the given ID!\n");
				}		
	}
			
				 
	
	//8
	public static void displayServices(Station[] stationArray){
		int writenid;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to display: ");
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
				System.out.print("\nDisplaying the sold services of Station #"+writenid+"\n");
				Collections.sort(e.serviceArrayList);
				for( Service s : e.serviceArrayList){
					if(s != null) {
					s.displayServiceInfo();
					found=1; 
					}
					else if(s == null) break; 
				}	
			}
			else continue;
		}
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
		
	}
	
	//7
	public static void sellCarWash(Station[] stationArray){
		int writenid;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to sell car wash: ");
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
				System.out.print("\nPlease enter the car plate: ");
				String plate = myScannerString.nextLine();
				System.out.print("Personnel that helped during this service: \n");
				
				while(true) {
					Random rand = new Random();
					int selectedPerson = rand.nextInt(e.personCount); 
					if(e.personList.get(selectedPerson).getClass() == Personnel.class) {
						Personnel p = (Personnel) e.personList.get(selectedPerson);
						if(p != null) {
							p.displayInformation(); 
							p.incJobCount();
							break;
						}
						else continue;
					}
					else continue;
				}
				
				CarWash CarWash = new CarWash(plate);
				//e.serviceArray[e.servicenumber]= CarWash;
				e.serviceArrayList.add(CarWash);
				e.profitCalculate.add(CarWash);
				e.servicenumber++;
				found = 1;
			}
			else continue;
		}
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
		
	}
	
	//9
	public static void addPerson(Station[] stationArray) {
		int choice;
		int writenid ;
		while(true) {
		System.out.print("1. Add a personnel\n");
		System.out.print("2. Add a manager\n");
		choice = myScanner.nextInt();
			if(choice == 1 || choice == 2) {
				break;
			}
			else {
				System.out.print("Please enter 1 or 2!\n\n");
				continue;
			}
		}
		while(true){
			
			try{
				System.out.print("\nPlease enter the ID of the Station you want to add a person: ");
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
				System.out.print("\nPlease enter a name: ");
				String name = myScannerString.nextLine();
				System.out.print("Please enter a surname: ");
				String surname = myScannerString.nextLine();
				if(choice == 1) {
					Personnel personnel = new Personnel(name, surname);
					e.personList.add(personnel);
					e.personCount++; 
					e.profitCalculate.add(personnel); 
					found = 1;
					
				}
				if(choice == 2) {
				int jobYear;
					while(true){
						
						try{
							System.out.print("Please enter how many years the mager is working: ");
							jobYear = myScanner.nextInt();
							break;
						}catch(InputMismatchException B) {
							System.err.println("year should be an integer...");
							myScanner.nextLine();
						}
					}
					
					Manager manager = new Manager(name, surname, jobYear);
					e.personList.add(manager);
					e.profitCalculate.add(manager);
					e.personCount++;
					found = 1;
				}
			}
			else continue;
		} 
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
		
	}
	
	//10
	public static void calculateNetProfit(Station[] stationArray){
		double netProfit = 0.0;
		int writenid ;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to calculate profit: ");				
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		
		System.out.println(" ");
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
				for( Profitable profit : e.profitCalculate){
					if(profit != null) {
					netProfit += (double)profit.calculate();
					found = 1; 
					}
					else if(profit == null) {
						found = 1;
						break; 
					}
				}
			} 
			else continue; 
		}
		if (found != 1) {
			System.out.print("No station found with the given ID!\n");
		}
		if (found == 1) {
			System.out.print("Net profit of the station is: "+ netProfit + "\n");
		}
		
	}
	
	//11  
	public static void displayServices2(Station[] stationArray){
		int writenid ;
		while(true){
			
			try{
				System.out.print("Please enter the ID of the Station you want to search: ");
				writenid = myScanner.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.err.println("ID should be an integer...");
				myScanner.nextLine();
			}
		}
		
		int found = 0;
		for(Station e : stationArray) {
			if (e == null) break;
			else if (writenid == e.ID) {
				Collections.sort(e.serviceArrayList, new CarPlateComparator());
				System.out.print("\nDisplaying the sold services of Station #"+writenid+"\n");
				for( Service s : e.serviceArrayList){
					if(s != null) {
					s.displayServiceInfo();
					found=1; 
					}
					else if(s == null) break; 
				}	
			}
			else continue;
		}
		if (found != 1) {
			System.out.print("\nNo station found with the given ID!\n");
		}
		
	}
	

	private static void authenticateCarPlate(String carplate) throws Exception{
		if(carplate.length() <= 10 && carplate.length() >= 8) {
			try {
				if(Integer.parseInt(carplate.substring(0, 2))<82){
					if(!carplate.substring(5).matches("[^A-Za-z]") && carplate.substring(4,5).matches("\s")) {
						if(carplate.substring(2, 5).matches(".*[0-9].*")) {
							throw new Exception();
						}
					}
					else if(!carplate.substring(6).matches("[^A-Za-z]")&& carplate.substring(5,6).matches("\s")) {
						if(carplate.substring(2, 6).matches(".*[0-9].*")) {
							throw new Exception();
						}
					}
					else if(!carplate.substring(7).matches("[^A-Za-z]")&& carplate.substring(6,7).matches("\s")) {
						if(carplate.substring(2, 7).matches(".*[0-9].*")) {
							throw new Exception();
						}
					}
					else {
						throw new Exception();
					}
				}
				else if(Integer.parseInt(carplate.substring(0, 2))>=82){
					throw new Exception();
				}
			}catch(NumberFormatException e) {
				throw new Exception();
			}
		}else {
			throw new Exception();
		}
	}

}
