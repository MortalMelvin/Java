package cafeMelvin;

public class CardPayment extends Payment {
	private String name;        //credit card holder's name 
	private String number;      //16 characters, a 16 digit credit card number
	private String expiration;  //05 characters, format is 'mm/yy'


	public CardPayment() {
		super();
		this.name = "Unknown name";
		this.number = "Unknown number";
		this.expiration = " Unknown expiration";

	}

	public CardPayment(double amount, double paymentWithSurcharge, String name, String number, String expiration) {
		super(amount, paymentWithSurcharge);
		this.name = name;
		this.number = number;
		this.expiration = expiration;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}


	public static CardPayment createCardPayment(double amount, double paymentWithSurcharge, String name, String number, String expiration) {
		return new CardPayment(amount, paymentWithSurcharge, name, number, expiration);
	}

}
