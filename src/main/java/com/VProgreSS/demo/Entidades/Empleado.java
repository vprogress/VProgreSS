package com.VProgreSS.demo.Entidades;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Empleado_id")
    private int codempleado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombre")
    private String apellido;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<MovimientoDinero> MovimientoDineros;


}
