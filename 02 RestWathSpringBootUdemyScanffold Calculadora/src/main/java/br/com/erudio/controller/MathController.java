package br.com.erudio.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MathController {
	
	@GetMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double greating(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		
		Double sum = convertDouble(numberOne) + convertDouble(numberTwo);
		
		return sum;
	}

	private Double convertDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replace(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",", ".");
		
		return number.matches("[-+]?[0-9]*\\.?[0-9]+"); //Regex Verifica se é um number
	}

}
