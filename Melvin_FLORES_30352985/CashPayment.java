package cafeMelvin;

public class CashPayment extends Payment {

	public CashPayment() {
		super();
	}

	public CashPayment(double amount, double paymentWithSurcharge) {
		super(amount, paymentWithSurcharge);
	}

	public static CashPayment createCashPayment(double payment, double paymentWithSurcharge) {
		return new CashPayment(payment, paymentWithSurcharge);
	}

}

