package com.adn.alianza.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Estadisticas {

    @Id
    private String name;
    private Integer value;
}
