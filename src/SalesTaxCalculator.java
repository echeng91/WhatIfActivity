import java.util.Scanner;
import java.text.NumberFormat;

public class SalesTaxCalculator {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		
		System.out.print("Input customer number: ");
		int customerNumber = keyboard.nextInt();
		keyboard.nextLine();//takes the enter press from previous user entry.
		
		System.out.print("Input customer name: ");
		String customerName = keyboard.nextLine();
		
		System.out.print("Input sales amount: ");
		double salesAmount = keyboard.nextDouble();
		
		double taxAmount = getTaxAmount(keyboard);
		double salesTax = salesAmount * taxAmount;
		double totalDue = salesAmount + salesTax;

		keyboard.close();
		
		System.out.println("\n");
		System.out.println("Customer number:\t" + customerNumber);
		System.out.println("Customer name:\t\t" + customerName);
		System.out.println("Sales Amount:\t\t" + currency.format(salesAmount));
		System.out.println("Sales Tax:\t\t" + currency.format(salesTax));
		System.out.println("Total:\t\t\t" + currency.format(totalDue));
	}

	public static double getTaxAmount(Scanner sc) {
		//tax amounts for tax codes are listed as percents
		final double NRM = 6.0;
		final double NPF = 0.0;
		final double BIZ = 4.5;
		
		String taxCode = "";
		double taxAmount = 0;
		while(!taxCode.equalsIgnoreCase("NRM") && !taxCode.equalsIgnoreCase("NPF") && !taxCode.equalsIgnoreCase("BIZ")) {
			System.out.print("Input tax code: ");
			taxCode = sc.next();
			if(taxCode.equalsIgnoreCase("NRM")) {
				taxAmount = NRM / 100;
			}
			else if(taxCode.equalsIgnoreCase("NPF")) {
				taxAmount = NPF / 100;
			}
			else if(taxCode.equalsIgnoreCase("BIZ")) {
				taxAmount = BIZ / 100;
			}
			else {
				System.out.println("Invalid input.");
			}
		}
		
		return taxAmount;
	}


}
