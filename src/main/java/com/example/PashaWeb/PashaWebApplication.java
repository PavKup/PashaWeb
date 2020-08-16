package com.example.PashaWeb;

import lombok.var;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class PashaWebApplication {

	public static void main(String[] args) {
		var ctxt = SpringApplication.run(PashaWebApplication.class, args);
		ctxt.getBean(Bootstrap.class).init();
	}
}


