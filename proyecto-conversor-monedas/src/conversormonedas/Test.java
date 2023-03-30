package conversormonedas;

import javax.swing.JOptionPane;

public class Test {

	private static final String DE_YEN_A_PESOS = "de Yen a Pesos";

	private static final String DE_WON_COREANO_A_PESOS = "de Won Coreano a Pesos";

	private static final String KELVIN_A_FARENHEIT = "Kelvin a Farenheit";

	private static final String KELVIN_A_CELSIUS = "Kelvin a Celsius";

	private static final String FARENHEIT_A_KELVIN = "Farenheit a Kelvin";

	private static final String FARENHEIT_A_CELSIUS = "Farenheit a Celsius";

	private static final String CELSIUS_A_KELVIN = "Celsius a Kelvin";

	private static final String CELSIUS_A_FARENHEIT = "Celsius a Farenheit";

	private static final String DE_LIBRAS_A_PESOS = "de Libras a Pesos";

	private static final String DE_EURO_A_PESOS = "de Euro a Pesos";

	private static final String DE_DOLAR_A_PESOS = "de Dolar a Pesos";

	private static final String DE_PESOS_A_WON_COREANO = "de Pesos a Won Coreano";

	private static final String DE_PESOS_A_YEN = "de Pesos a Yen";

	private static final String DE_PESOS_A_LIBRAS = "de Pesos a Libras";

	private static final String DE_PESOS_A_EURO = "de Pesos a Euro";

	private static final String DE_PESOS_A_DOLAR = "de Pesos a Dolar";

	private static final String CONVERSOR_DE_TEMPERATURA = "Conversor de Temperatura";

	private static final String CONVERSOR_DE_MONEDA = "Conversor de Moneda";

	// --------------------------------------------------------------------------------------------------------------------//

	public static void main(String[] args) {

		double valor;
		double resultado = 0;

		int decisionContinuar;
		int valorConversion = 0;

		String decisionString;

		String opciones[] = { CONVERSOR_DE_MONEDA, CONVERSOR_DE_TEMPERATURA };
		String opcionesMoneda[] = { DE_PESOS_A_DOLAR, DE_PESOS_A_EURO, DE_PESOS_A_LIBRAS, DE_PESOS_A_YEN,
				DE_PESOS_A_WON_COREANO, DE_DOLAR_A_PESOS, DE_EURO_A_PESOS, DE_LIBRAS_A_PESOS, DE_WON_COREANO_A_PESOS,
				DE_YEN_A_PESOS };
		String opcionesTemperatura[] = { CELSIUS_A_FARENHEIT, CELSIUS_A_KELVIN, FARENHEIT_A_CELSIUS, FARENHEIT_A_KELVIN,
				KELVIN_A_CELSIUS, KELVIN_A_FARENHEIT };

		do {

			decisionString = (String) JOptionPane.showInputDialog(null, "Seleccione una opcion de conversion", "Menu",
					1, null, opciones, "Seleccion".toString());

			if (decisionString.equals(CONVERSOR_DE_MONEDA))
				;
			{
				valorConversion = 1;
			}

			if (decisionString.equals(CONVERSOR_DE_TEMPERATURA)) {
				valorConversion = 2;
			}

			switch (valorConversion) {
			case 1:
				valor = metodoConversor(opcionesMoneda, decisionString);

				String decisionMoneda = (String) JOptionPane.showInputDialog(null,
						"Seleccione una opcion de conversion", "Menu", 1, null, opcionesMoneda, "Seleccion".toString());

				resultado = swtichMoneda(valor, decisionMoneda, resultado);

				JOptionPane.showMessageDialog(null,
						"Usted eligio convertir " + decisionMoneda + " y su valor final es de: " + resultado + " $");

				break;

			// --------------------------------------------------------------------------------------------------------------------//

			case 2:

				valor = metodoConversorGrados(opcionesTemperatura, decisionString);

				String decisionTemperatura = (String) JOptionPane.showInputDialog(null,
						"Seleccione una opcion de conversion", "Menu", 1, null, opcionesTemperatura,
						"Seleccion".toString());

				resultado = switchGrados(valor, decisionTemperatura, resultado);

				JOptionPane.showMessageDialog(null, "Usted eligio convertir de " + decisionTemperatura
						+ " y su resultado es de " + resultado + " grados");

				break;

			default:
				break;
			}

			// Termina el while //

			decisionContinuar = JOptionPane.showConfirmDialog(null, "¿Desea continuar?");

		} while (decisionContinuar == JOptionPane.YES_OPTION);

		if (decisionContinuar == JOptionPane.CANCEL_OPTION || decisionContinuar == JOptionPane.NO_OPTION) {

			JOptionPane.showInternalMessageDialog(null, "Programa Finalizado", "Mensaje", 1);

		}

	}

	// Metodos //

	private static double swtichMoneda(double valor, String decisionMoneda, double resultado) {
		switch (decisionMoneda) {

		case DE_PESOS_A_DOLAR:

			resultado = valor * 0.0048;

			break;

		case DE_PESOS_A_EURO:

			resultado = valor * 0.0044;

			break;

		case DE_PESOS_A_LIBRAS:

			resultado = valor * 0.0039;

			break;

		case DE_PESOS_A_YEN:

			resultado = valor * 0.64;

			break;

		case DE_PESOS_A_WON_COREANO:

			resultado = valor * 6.27;

			break;

		case DE_DOLAR_A_PESOS:

			resultado = valor * 208.30;

			break;

		case DE_EURO_A_PESOS:

			resultado = valor * 225.73;

			break;

		case DE_LIBRAS_A_PESOS:

			resultado = valor * 256.26;

			break;

		case DE_YEN_A_PESOS:

			resultado = valor * 1.57;

			break;

		case DE_WON_COREANO_A_PESOS:

			resultado = valor * 0.16;

			break;

		default:
			break;
		}
		return resultado;
	}

	private static double switchGrados(double valor, String decisionMoneda, double resultado) {
		switch (decisionMoneda) {

		case CELSIUS_A_FARENHEIT:

			resultado = (valor * (9 / 5)) + 32;

			break;

		case CELSIUS_A_KELVIN:

			resultado = valor + 273.15;

			break;

		case KELVIN_A_CELSIUS:

			resultado = valor - 273.15;

			break;

		case KELVIN_A_FARENHEIT:

			resultado = ((valor - 273.15) * (9 / 5)) + 32;

			break;

		case FARENHEIT_A_CELSIUS:

			resultado = (valor - 32) * (5 / 9);

			break;

		case FARENHEIT_A_KELVIN:

			resultado = ((valor - 32) * (5 / 9)) + 273.15;

			break;

		default:

			break;
		}
		return resultado;
	}

	private static double metodoConversor(String[] opcionesMoneda, String decisionString) {

		double monto = 0;

		try {

			double decisionDouble = Double
					.parseDouble(JOptionPane.showInputDialog(null, "Introduce el monto a convertir", "input", 3));

			while (decisionDouble <= 0) {

				decisionDouble = Double
						.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un valor valido!", "ERORR", 0));

			}

			monto = decisionDouble;

		} catch (java.lang.NumberFormatException exception) {

			Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un valor valido!", "ERORR", 0));

		}

		return monto;

	}

	private static double metodoConversorGrados(String[] opcionesTemperatura, String decisionString) {

		double monto = 0;
		double decisionDouble = 0;

		try {
			decisionDouble = Double.parseDouble(
					JOptionPane.showInputDialog(null, "Introduce el numero de temperatura a convertir", "input", 3));

		} catch (java.lang.NumberFormatException e) {
			Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese un valor valido!", "ERORR", 0));
		}

		return monto = decisionDouble;

	}

}
