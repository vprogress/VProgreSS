package com.VProgreSS.demo.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "MovimientoDinero")
@JsonIgnoreProperties({"empleado"})
public class MovimientoDinero{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MovimiendoDinero_id")
    private long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "monto")
    private float monto;
    @Column(name = "egresos")
    private float egresos;

    @Column(name = "registro")
    private LocalDate registro;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Empleado.class)
    @JoinColumn(name ="empleado_id")
    private Empleado empleado;


}