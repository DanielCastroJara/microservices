package com.example.curso.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.curso.objects.Greeting;

@RestController
@RequestMapping(value = "greeting")
public class GreetingController {
	
	private final AtomicLong count = new AtomicLong();
	private static final String template = "Hello %s";
	
	@GetMapping
	public Greeting getGeeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(count.incrementAndGet(), String.format(template, name));
		
	}

}
