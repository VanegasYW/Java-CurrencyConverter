package main;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

import resources.Converter;
import resources.Currencies;

public class CurrencyConverter {
	public static void main(String[] args) {
		int userChoice = 0;
		String monedas = "COP - Pesos Colombianos\n"
				+ "	USD - Dolares\n"
				+ "	EUR - Euros\n"
				+ "	GBP - Libras Esterlinas\n"
				+ "	JPY - Yenes Japoneses\n"
				+ "	KRW - Won sul-coreano\n";
		do {
			// Prompt user to select a base currency
			Currencies from = selectCurrency("Seleccione su moneda:\n"+monedas, "Monedas",
					Currencies.getAvailableCurrencies(null));

			if (from != null) {
				// Prompt user to select a target currency
				Currencies to = selectCurrency("Seleccione la moneda de cambio\n"+monedas, "Monedas",
						Currencies.getAvailableCurrencies(from));

				if (to != null) {
					Converter converter;
					try {
						// Prompt user to enter amount to convert
						double amount = Double.parseDouble(inputValue("Ingrese el valor que desea convertir"));

						// Convert currency and display result to user
						converter = new Converter(from, to, amount);

						String fromText = converter.getFrom().getText();
						String toText = converter.getTo().getText();
						String text = MessageFormat.format("De: {0}\nA: {1} \nTienes ${2} {3}", fromText, toText,
								converter.getValueConverted(), toText);

						JOptionPane.showMessageDialog(null, text);

						// Prompt user if they want to do another conversion
						userChoice = confirmDialog("¿Desea realizar otra conversión?", "Confirmar");

					} catch (NumberFormatException | NullPointerException e) {
						// Handle invalid input values
						userChoice = confirmDialog("Valor no válido. ¿Desea intentarlo de nuevo?", "Error");
						e.getStackTrace();
					}
				} else {
					// User cancelled or didn't select a target currency
					userChoice = confirmDialog("¿Desea intentarlo de nuevo?", "Salir");
				}

			} else {
				// User cancelled or didn't select a base currency
				userChoice = confirmDialog("¿Desea intentarlo de nuevo?", "Salir");
			}
			JOptionPane.showMessageDialog(null, "Programa finalizado");
		} while (userChoice == JOptionPane.YES_NO_OPTION);

	}

	private static Currencies selectCurrency(String message, String title, Object[] options) {
		return (Currencies) JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE, null,
				options, "Seleccione");
	}

	private static String inputValue(String message) {
		return JOptionPane.showInputDialog(message);
	}

	private static int confirmDialog(String message, String title) {
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
	}
}
