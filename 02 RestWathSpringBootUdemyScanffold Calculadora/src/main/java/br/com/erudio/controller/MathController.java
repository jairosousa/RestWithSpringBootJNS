package br.com.erudio.controller;

import static br.com.erudio.controller.util.MathUtil.convertDouble;
import static br.com.erudio.controller.util.MathUtil.isNumeric;
import static java.lang.Math.sqrt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
@RequestMapping("/")
public class MathController {
	
	@Autowired
	private SimpleMath simpleMath;

	@GetMapping(value = "sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		return simpleMath.sum(numberOne, numberTwo);
	}

	@GetMapping(value = "sub/{numberOne}/{numberTwo}")
	public Double subtracao(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		return simpleMath.sub(numberOne, numberTwo);
	}

	@GetMapping(value = "mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		return simpleMath.mult(numberOne, numberTwo);
	}

	@GetMapping(value = "div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		return simpleMath.div(numberOne, numberTwo);
	}

	@GetMapping(value = "media/{numberOne}/{numberTwo}")
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {

		return simpleMath.media(numberOne, numberTwo);
	}

	@GetMapping(value = "raiz/{numberOne}")
	public Double raiz(@PathVariable("numberOne") String numberOne) throws Exception {

		return simpleMath.raiz(numberOne);
	}

}
