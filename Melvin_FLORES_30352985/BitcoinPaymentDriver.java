package cafeMelvin;

public class BitcoinPaymentDriver {

	public static void main(String[] args) {
		BitcoinPaymentDriver bpd = new BitcoinPaymentDriver();
		bpd.testBitcoinPayment();
	}

	//additional functionality at a later date
	public void payBitcoinPayment (Payable p) {
		if (p instanceof Payable)
			p.pay();
		else
			System.out.println ("No permission for BitcoinPayment");
	}

	private void testBitcoinPayment () {
		BitcoinPayment bp = new BitcoinPayment();
		payBitcoinPayment(bp);
	}

}
