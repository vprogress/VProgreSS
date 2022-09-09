package com.VProgreSS.demo.Servicios;

import com.VProgreSS.demo.Entidades.MovimientoDinero;
import com.VProgreSS.demo.Repositorio.IEmpleado;
import com.VProgreSS.demo.Repositorio.IMovimientoDinero;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoDineroService {

    private IMovimientoDinero iMovimientoDinero;
    private IEmpleado iEmpleado;

    //Enlace - Arrastra movimiento -> empleado
    public MovimientoDineroService(IMovimientoDinero iMovimientoDinero, IEmpleado iEmpleado) {
        this.iMovimientoDinero = iMovimientoDinero;
        this.iEmpleado = iEmpleado;
    }

    //Busqueda Empleado en movimiento dinero en DB
    public List<MovimientoDinero> getMovimientoDinero() {
        return this.iMovimientoDinero.findAll();
    }

    //Retorna el movimientoDinero, solo si el movimiento es igual 0
    public MovimientoDinero getMovimientoDinero(Long id) {
        Optional<MovimientoDinero> movimientoDinero = this.iMovimientoDinero.findById(id);
        return movimientoDinero.orElse(null);
    }

    // Guarda el movimiento al empleado !
    public MovimientoDinero createMovimientoDinero(MovimientoDinero movimientoDinero) {
        //movimientoDinero.setNombre(this.iEmpleado.findBy(movimientoDinero.getNombre().get());
        return this.iMovimientoDinero.save(movimientoDinero);
    }

    //Se ingresa y se elimina un monto al movimiento dinero al usuario y se puede eliminar.
    public MovimientoDinero updateMovimientoDinero(Long id, MovimientoDinero movimientoDinero) {
        Optional<MovimientoDinero> dbData = this.iMovimientoDinero.findById(id);

        if (dbData.isPresent()) {
            MovimientoDinero e = dbData.get();
            e.setNombre(movimientoDinero.getNombre());
            e.setMonto(movimientoDinero.getMonto());
            e.setEgresos(movimientoDinero.getEgresos());
            this.iMovimientoDinero.save(e);
            return e;
        }

        return null;
    }

    public Boolean deleteMovimientoDinero(Long id) {
        try {
            this.iMovimientoDinero.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}