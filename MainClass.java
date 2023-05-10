import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Station[] stationArray = new Station[10];
		int counter = 0;

		String choice = null;

		while (true) {
			MenuItem.printMenu();

			choice = sc.nextLine();

			if (choice.equals("1")) {
				stationArray[counter++] = Station.createStation();
			} else if (choice.equals("2")) {
				Station.findStationAndAddGasoline(stationArray);
			} else if (choice.equals("3")) {
				Station.findStationAndAddDiesel(stationArray);
			} else if (choice.equals("4")) {
				Station.displayStationInventory(stationArray);
			} else if (choice.equals("5")) {
				Station.sellGasoline(stationArray);
			} else if (choice.equals("6")) {
				Station.sellDiesel(stationArray);
			} else if (choice.equals("7")) {
				Station.sellCarWash(stationArray);
			} else if (choice.equals("8")) {
				Station.displayServices(stationArray);
			} else if (choice.equals("9")) {
				Station.addPerson(stationArray);
			} else if (choice.equals("10")) {
				Station.calculateNetProfit(stationArray);
			} else if (choice.equals("11")) {
				Station.displayServices2(stationArray);
			} else if (choice.equals("0")) {
				break;
			} else {
				System.out.println("Wrong choice!");
			}
			System.out.println();
		}

	}

}
