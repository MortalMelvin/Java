package cafeMelvin;

public class Payment {
	private double amount;
	private double paymentWithSurcharge;
	
	public String toString() {
		return ("Payment superclass has amount:" + this.amount +
				"and payment with surcharge:" + this.paymentWithSurcharge);
	}

	public Payment() {
		this.amount = 0.0;
		this.paymentWithSurcharge = 0.0;
	}

	public Payment(double amount, double paymentWithSurcharge) {
		this.amount = amount;	
		this.paymentWithSurcharge = paymentWithSurcharge; 
	}

	public double getAmount() {
		return amount;
	}


	public double getPaymentWithSurcharge() {
		return paymentWithSurcharge;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setPaymentWithSurcharge(double paymentWithSurcharge) {
		this.paymentWithSurcharge = paymentWithSurcharge;
	}

	public void paymentDetails() {
		System.out.println("The amount is " + this.amount +
				           "and payment with surcharge is " + this.paymentWithSurcharge);
	}
		
}
