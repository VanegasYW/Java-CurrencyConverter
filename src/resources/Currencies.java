package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Currencies {
	COP("Pesos Colombianos", 4764.71),
	USD("Dolares", 1), 
	EUR("Euros", 0.93),
	GBP("Libras Esterlinas", 0.82),
	JPY("Yenes Japoneses", 131.84),
	KRW("Won sul-coreano", 1308.75);

	private final String text;
	private final double rate;

	Currencies(String text, double rate) {
		this.text = text;
		this.rate = rate;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return the rate
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @return the currencies array
	 */
	public static Object[] getAvailableCurrencies(Currencies currentCurrency) {
		List<Currencies> currencies = new ArrayList<>(Arrays.asList(Currencies.values()));
		currencies.remove(currentCurrency);
		return currencies.toArray();
	}
}
