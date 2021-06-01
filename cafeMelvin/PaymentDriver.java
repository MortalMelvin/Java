package cafeMelvin;

import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PaymentDriver {

	private static Scanner scanner = new Scanner(System.in);
	private static CashPaymentArray cashPaymentArray = new CashPaymentArray("");
	private static CardPaymentArray cardPaymentArray = new CardPaymentArray("");
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void main(String[] args) {
		boolean quit = false;
		startPayment();
		printActions();
		while(!quit) {
			char action;
			System.out.println("\nEnter action (0, 1, 2, 3 or 4):");
			String s = scanner.next();
			action = s.charAt(0);
			scanner.nextLine();

			switch (action) {
			case '0':
				System.out.println("\nShutting down...");
				quit = true;
				break;

			case '1':
				double grandTotalCashSales=0;
				double grandTotalCardSales=0;
				double grandTotalProductSales=0;
				grandTotalCashSales += cashPaymentArray.printCashPayments();
				grandTotalCardSales += cardPaymentArray.printCardPayments();
				grandTotalProductSales = grandTotalCashSales + grandTotalCardSales;
				System.out.println("\nTotal Product Sales: $ " + df2.format(grandTotalProductSales));

				if (printNextActions() == true) {
					printActions();
				}
				else {
					System.out.println("\nShutting down...");
					quit = true;
				}
				break;


			case '2':
				addNewCashPayment();
				if (printNextActions() == true) {
					printActions();
				}
				else {
					System.out.println("\nShutting down...");
					quit = true;
				}
				break;

			case '3':
				printCardChoices();
				addNewCardPayment();
				if (printNextActions() == true) {
					printActions();
				}
				else {
					System.out.println("\nShutting down...");
					quit = true;
				}
				break;                	

			case '4':
				printActions();
				break;

			default:
				System.out.println("Invalid action. Choose again.\n");
				break;
			}

		}

	}

	private static void addNewCashPayment() {
		double paymentWithSurcharge;

		System.out.println("Enter payment amount: ");
		double amount = scanner.nextDouble();

		paymentWithSurcharge = amount; //No surcharge for cash payment

		CashPayment newCashPayment = CashPayment.createCashPayment(amount, paymentWithSurcharge);
		if(cashPaymentArray.addNewCashPayment(newCashPayment)) {
			System.out.println("New cash payment added: payment = $ "+ df2.format(amount));
		}
	}

	private static void addNewCardPayment() {

		boolean validCard = false;
		double cardSurchargeFactor = 0.0;

		while(!validCard) {
			char response;
			System.out.println("\nEnter action (1 or 2):");
			String s3 = scanner.next();
			response = s3.charAt(0);
			scanner.nextLine();

			switch (response) {
			case '1':
				cardSurchargeFactor = 0.015;
				System.out.println("\nMasterCard / Visa card surcharge factor : " + cardSurchargeFactor);
				validCard = true;
				break;

			case '2':
				cardSurchargeFactor = 0.03;
				System.out.println("\nAmex card surcharge factor : : " + cardSurchargeFactor);
				validCard = true;
				break;

			default:
				System.out.println("Invalid action. Choose again.\n");
				validCard = false;
				break;
			}
		}

		System.out.println("Enter payment amount: ");
		double amount = scanner.nextDouble();

		double paymentWithSurcharge;
		paymentWithSurcharge =amount*(1+cardSurchargeFactor); //With surcharge for card payment

		System.out.println("Enter card holder's name: ");
		String name = scanner.next();

		System.out.println("Enter credit card number: ");
		String number = scanner.next();

		System.out.println("Enter credit card expiration: ");
		String expiration = scanner.next();

		CardPayment newCardPayment = CardPayment.createCardPayment(amount,paymentWithSurcharge,name,number,expiration);
		if(cardPaymentArray.addNewCardPayment(newCardPayment)) {
			System.out.println("New card payment added: payment with surcharge= $ "+ df2.format(paymentWithSurcharge) + ", " +
					"name = " + name + ", " +
					"number = " + number + ", " +
					"expiration = " + expiration);
		}
	}


	private static void startPayment() {
		System.out.println("Starting payment...");
	}

	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("0  - to shutdown\n" +
				"1  - to view current payments received\n" +
				"2  - to add a new cash payment\n" +  
				"3  - to add a new card payment\n" +  
				"4  - to view a list of available actions.");
		System.out.println("Choose your action: ");
	}

	private static boolean printNextActions() {
		char answer;                	
		System.out.println("\nDo you want process another transaction?");
		System.out.println("Enter 'yes' or 'y' to proceed with another transaction.");
		String s2 = scanner.next();
		answer = s2.charAt(0);
		if (answer == 'y' || answer == 'Y' ) { 
			return true;
		}
		else {
			return false;
		}
	}

	private static void printCardChoices() {
		System.out.println("\nEnter credit card type:\npress");
		System.out.println("1  - for MasterCard/Visa card\n" +
				"2  - for AMEX card\n");
		System.out.println("Choose your action: ");
	}


}
