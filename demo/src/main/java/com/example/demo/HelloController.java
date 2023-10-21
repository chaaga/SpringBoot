package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloController {

	HashMap <String, String> map = new HashMap<>();

	@GetMapping("/")
	public String index() {

		return "Greetings from Spring Boot!";
	}
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello "+name;
	}


	@PostMapping("/greeting/{id}/{age}")
	public String greetingId(@PathVariable String id,@PathVariable String age) {
		map.put(id,age);
		return "Hello by pathvariable "+id;
	}

	@GetMapping("/allcallers")
	public String greeting () {
		return map.toString();
	}
}
