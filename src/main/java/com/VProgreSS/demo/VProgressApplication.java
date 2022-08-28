package com.VProgreSS.demo;

import Entidades.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VProgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(VProgressApplication.class, args);
	}

	Empresa empresa = new Empresa();


}
