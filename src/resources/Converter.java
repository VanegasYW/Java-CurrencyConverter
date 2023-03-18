package resources;

public class Converter {

	private final Currencies to;
	private final Currencies from;
	private final double amount;

	public Converter(Currencies from, Currencies to, double amount) {
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	/**
	 * @return the value converted
	 */
	public double getValueConverted() {

		if (this.amount <= 0) {
			return 0;
		}

		// Convert the amount to dollars and then to the target currency
		double dollars = this.amount / this.from.getRate();

		return dollars * this.to.getRate();
	}

	/**
	 * @return the to
	 */
	public Currencies getTo() {
		return to;
	}

	/**
	 * @return the from
	 */
	public Currencies getFrom() {
		return from;
	}

}
