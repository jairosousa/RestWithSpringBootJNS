package br.com.erudio.controller.util;

public class MathUtil {
	
	public static Double convertDouble(String strNumber) {
		if (strNumber == null || strNumber.equals("0"))
			return 0D;
		String number = strNumber.replace(",", ".");
		if (isNumeric(number))
			return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null)
			return false;
		String number = strNumber.replace(",", ".");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); // Regex Verifica se é um number
	}

}
