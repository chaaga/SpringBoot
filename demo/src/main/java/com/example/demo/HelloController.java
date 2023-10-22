package com.example.demo;

import com.example.demo.model.Item;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class HelloController {

	ArrayList<Item> items = new ArrayList<Item>();

	@GetMapping("/")
	public String index() {

		return "Greetings from Spring Boot!";
	}
	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello "+name;
	}



	@PostMapping(
			path="/items",
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseStatus(HttpStatus.CREATED)
	Item createNew(@Valid @RequestBody Item newItem) {
		items.add(newItem);
		return newItem;
	}
	@GetMapping("/allitems")
	public String getAllitems () {
		return items.toString();
	}
}
