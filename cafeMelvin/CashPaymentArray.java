package cafeMelvin;

import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CashPaymentArray {
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	private ArrayList<CashPayment> myCashPayments;

	public CashPaymentArray(String myNumber) {
		this.myCashPayments = new ArrayList<CashPayment>();
	}

	public boolean addNewCashPayment(CashPayment cashPayment) {
		myCashPayments.add(cashPayment);
		return true;

	}

	public double printCashPayments() {
		System.out.println("\nCash Payment List");
		System.out.println("-----------------");

		double totalCashSales = 0;
		if (this.myCashPayments.size() == 0) {
			System.out.println("No cash payment received!");
		}	
		else {
			for(int i=0; i<this.myCashPayments.size(); i++) {
				System.out.println((i+1) + ". $ " +
						df2.format(this.myCashPayments.get(i).getAmount()));
				totalCashSales += this.myCashPayments.get(i).getAmount();
			}
		}
		System.out.println("\nTotal Cash Sales: $ " + df2.format(totalCashSales));
		return totalCashSales;

	}
}