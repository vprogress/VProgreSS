package com.VProgreSS.demo.Controlador;

import com.VProgreSS.demo.Entidades.MovimientoDinero;
import com.VProgreSS.demo.Servicios.MovimientoDineroService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MovimientoDineroController {

    MovimientoDineroService service;

    public MovimientoDineroController(MovimientoDineroService services) {
        this.service = services;
    }

    @GetMapping("/movimientoDinero")
    public List<MovimientoDinero> getMovimientoDinero(){
        return this.service.getMovimientoDinero();
    }

    @GetMapping("/movimientoDinero/{id}")
    public MovimientoDinero getMovimientoDinero(@PathVariable("id") long id) {
        return this.service.getMovimientoDinero(id);

    }

    @PostMapping("/movimientoDineros")
    public MovimientoDinero createInvoice(@RequestBody MovimientoDinero movimientoDinero){
        return  this.service.createMovimientoDinero(movimientoDinero);
    }

    @PutMapping("/movimientoDinero/{id}")
    public MovimientoDinero updateUser(@PathVariable("id") long id, @RequestBody MovimientoDinero movimientoDinero){
        return this.service.updateMovimientoDinero(id,movimientoDinero);
    }

    @DeleteMapping("/movimientoDinero/{id}")
    public Boolean deleteMovimientoDinero(@PathVariable("id") long id){
        return this.service.deleteMovimientoDinero(id);

    }
}
