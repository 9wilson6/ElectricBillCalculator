import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
/*
 * name: Viswas Vatte              
 * date: September 13,2019
 * description:
 * this application calculates electric bill based on the number of units consumed.
 *  different charge rates are applied for different ranges of units consumed.
 *  the application gives the user the total cost of consumed units alongside the number of units consumed. 
 * */
public class ElectricBillCalculator {

	private static Scanner scanner;
	private static int option;
	private static double unitsConsumed;
	private static double billAmount;

	public static void main(String[] args) {
		String shouldContinue = "Y";
		scanner = new Scanner(System.in);
		while (shouldContinue.equalsIgnoreCase("y")) {
			System.out.println(
					"=========================================\nWelcome to the ABC Power Supply Company!\n=========================================");
			System.out.println("1. Bill Payment.");
			System.out.println("2. Quit.");
			System.out.println("Please enter your option:");
			option = scanner.nextInt();
			if (option == 1) {
				System.out.println("Please enter units consumed:");
				unitsConsumed = scanner.nextInt();
				if (unitsConsumed < 0) {
					System.out.println("Units consumed cannot be negative");
					System.out.println("Do you want to continue?");
					shouldContinue = scanner.next();
				} else {

					if (unitsConsumed >= 0 && unitsConsumed <= 100) {
						billAmount = unitsConsumed * 0.2;
					}
					if (unitsConsumed > 100 && unitsConsumed <= 250) {
						billAmount += 100 * 0.2;
						billAmount += (unitsConsumed - 100) * 0.5;
					}
					if (unitsConsumed > 250 && unitsConsumed <= 500) {
						billAmount += 100 * 0.2;
						billAmount += 150 * 0.5;
						billAmount += (unitsConsumed - 250) * 0.75;
					}
					if (unitsConsumed > 500) {
						billAmount += 100 * 0.2;
						billAmount += 150 * 0.5;
						billAmount += 250 * 0.75;
						billAmount += (unitsConsumed - 500) * 1;
					}
					
					System.out.println("****************************");
					System.out.printf("Total bill: $ %.2f \n", billAmount);
					System.out.printf("Power consumed: %.2f units \n", unitsConsumed);
					System.out.println("****************************");
					System.out.println("Do you want to continue?");
					shouldContinue = scanner.next();
				}

				
			} else {
				break;
			}

		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println("========================================");
		System.out.println(dateFormat.format(date));
		System.out.println("Thank you! See you next time!");
		System.out.println("========================================");
	}

}
