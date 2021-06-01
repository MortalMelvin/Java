package cafeMelvin;

import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CardPaymentArray {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private ArrayList<CardPayment> myCardPayments;

	public CardPaymentArray(String myNumber) {
		this.myCardPayments = new ArrayList<CardPayment>();
	}

	public boolean addNewCardPayment(CardPayment cardPayment) {
		myCardPayments.add(cardPayment);
		return true;

	}

	public double printCardPayments() {
		System.out.println("\nCard Payment List");
		System.out.println("-----------------");

		double totalCardSales = 0;
		double totalCardWithSurcharges = 0;
		double totalCardSurcharges = 0;

		if (this.myCardPayments.size() == 0) {
			System.out.println("No card payment received!");
		}	
		else {
			for(int i=0; i<this.myCardPayments.size(); i++) {
				System.out.println((i+1) + ". $ " +
						df2.format(this.myCardPayments.get(i).getPaymentWithSurcharge()) + ", " +
						this.myCardPayments.get(i).getName()    + ", " +
						this.myCardPayments.get(i).getNumber()  + ", " +
						this.myCardPayments.get(i).getExpiration());

				totalCardSales += this.myCardPayments.get(i).getAmount();
				totalCardWithSurcharges += this.myCardPayments.get(i).getPaymentWithSurcharge();
			}
			totalCardSurcharges = totalCardWithSurcharges - totalCardSales;
		}
		System.out.println("\nTotal Card Sales: $ " + df2.format(totalCardSales));
		System.out.println("\nTotal Card Surcharges: $ " + df2.format(totalCardSurcharges));
		return totalCardWithSurcharges;

	}
}