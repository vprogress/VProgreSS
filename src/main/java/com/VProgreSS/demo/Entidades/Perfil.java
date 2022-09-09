package com.VProgreSS.demo.Entidades;

import lombok.*;
// Libreria @Relacion
import javax.persistence.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String imagen;
    private String telefono;


}
