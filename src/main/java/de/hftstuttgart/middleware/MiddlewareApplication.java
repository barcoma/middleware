package de.hftstuttgart.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddlewareApplication.class, args);
	}

	@RestController
	class Greeter {
		@GetMapping("/")
		public String greeting(){
			return "Hello World2";
		}

		@GetMapping("/hello/{parameter}")
		public String greetingWithParameter(@PathVariable String parameter){
			return "Hello" + parameter;
		}
	}
}
