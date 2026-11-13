package entities;

public class Bill {

	// Product Prices
	public static final double BEER_PRICE = 5.0;
	public static final double SOFT_DRINK_PRICE = 3.0;
	public static final double BARBECUE_PRICE = 7.0;

	// Ticket Prices
	public static final double TICKET_PRICE_MALE = 10.0;
	public static final double TICKET_PRICE_FEMALE = 8.0;

	// Cover Charge Price
	public static final double COVER_CHARGE_PRICE = 4.0;
	public static final double COVER_CHARGE_EXEMPTION_LIMIT = 30.0;

	// Customer data
	public char gender;
	public int beer;
	public int barbecue;
	public int softDrink;

	public double cover() {
		return feeding() > COVER_CHARGE_EXEMPTION_LIMIT ? 0.0 : COVER_CHARGE_PRICE;
	}

	public double feeding() {
		double beerSubtotal = beer * BEER_PRICE;
		double softDrinksSubtotal = softDrink * SOFT_DRINK_PRICE;
		double barbecueSubtotal = barbecue * BARBECUE_PRICE;

		return beerSubtotal + softDrinksSubtotal + barbecueSubtotal;
	}

	public double ticket() {
		return gender == 'F' ? TICKET_PRICE_FEMALE : TICKET_PRICE_MALE;
	}

	public double total() {
		return feeding() + cover() + ticket();
	}

}
