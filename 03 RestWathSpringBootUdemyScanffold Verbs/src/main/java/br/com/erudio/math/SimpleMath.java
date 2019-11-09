package br.com.erudio.math;

import static br.com.erudio.controller.util.MathUtil.convertDouble;
import static br.com.erudio.controller.util.MathUtil.isNumeric;
import static java.lang.Math.sqrt;

import org.springframework.stereotype.Service;

import br.com.erudio.exception.UnsuportMathOperationException;

@Service
public class SimpleMath {

	public Double sum(String numberOne, String numberTwo) {
		validar(numberOne, numberTwo);

		return convertDouble(numberOne) + convertDouble(numberTwo);

	}

	public Double sub(String numberOne, String numberTwo) {
		validar(numberOne, numberTwo);

		return convertDouble(numberOne) - convertDouble(numberTwo);

	}

	public Double mult(String numberOne, String numberTwo) {
		validar(numberOne, numberTwo);

		return convertDouble(numberOne) * convertDouble(numberTwo);

	}
	
	public Double div(String numberOne, String numberTwo) {
		validar(numberOne, numberTwo);
		
		validarDivisorIgualZero(numberTwo);

		return convertDouble(numberOne) / convertDouble(numberTwo);

	}
	
	public Double media(String numberOne, String numberTwo) {
		validar(numberOne, numberTwo);
		
		return (convertDouble(numberOne) + convertDouble(numberTwo))/2;
		
	}
	
	public Double raiz(String numberOne) {
		validar(numberOne, "0");
		
		return sqrt(convertDouble(numberOne));

		
	}

	private void validarDivisorIgualZero(String numberTwo) {
		if (convertDouble(numberTwo) == 0D) {
			throw new UnsuportMathOperationException("Por Favor informe um divisor diferente de zero");
		}
		
	}

	private void validar(String numberOne, String numberTwo) {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportMathOperationException("Por Favor informe um valor numerico");
		}
	}

}
