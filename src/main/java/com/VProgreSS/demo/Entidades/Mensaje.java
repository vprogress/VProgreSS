package com.VProgreSS.demo.Entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "Mensaje")
public class Mensaje {
    @Id
    private String mensaje;

}
