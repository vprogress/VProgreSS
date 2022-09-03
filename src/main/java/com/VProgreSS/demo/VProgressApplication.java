package com.VProgreSS.demo;

import com.VProgreSS.demo.Entidades.Empleado;
import com.VProgreSS.demo.Entidades.Empresa;
import com.VProgreSS.demo.Entidades.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VProgressApplication {

	public static void main(String[] args) {
		SpringApplication.run(VProgressApplication.class, args);
	}

Empresa miEmpresa = new Empresa();
Empleado miEmpleado = new Empleado();
MovimientoDinero UnMovimiento = new MovimientoDinero();




}

