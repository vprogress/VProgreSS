package com.VProgreSS.demo.Entidades;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name = "empleados")
public class Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Empleado_id", nullable = false)
    private long id;

    @Column(name= "cedula")
    private long cedula;
    @Column(name= "nombre")
    private String nombre;
    @Column(name= "genero")
    private String genero;
    @Column(name= "edad")
    private String edad;
    @Column(name= "direccion")
    private String direccion;
    @Column(name= "correo")
    private String correo;

    //Relacion ->
    @Enumerated(EnumType.STRING)
    @Column(name = "empleado")
    private Empleado empleado;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<MovimientoDinero> MovimientoDineros;


}

