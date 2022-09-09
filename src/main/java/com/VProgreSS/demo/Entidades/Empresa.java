package com.VProgreSS.demo.Entidades;

import javax.persistence.*;

import lombok.*;
// Marco de trabajo
@Entity
//Constructores
@AllArgsConstructor
//Para no incluir los constructores en la clase
@NoArgsConstructor
//Getters and setters
@Getter
@Setter
//
@ToString
@Table(name = "empresas")
//Declaracion de variables y Tabla empleado
public class Empresa {
    @Id
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private int telefono;
    @Column(name = "nit")
    private String nit;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Empleado.class)
    private Empleado empleado;

}
