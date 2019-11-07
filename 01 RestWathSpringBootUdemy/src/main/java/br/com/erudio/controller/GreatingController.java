package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.Greeating;

@RestController
public class GreatingController {
	
	private static final String template = "Hello, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greating")
	public Greeating greating(@RequestParam(value = "name", defaultValue = "Word") String name) {
		return new Greeating(counter.incrementAndGet(), String.format(template, name));
	}

}
