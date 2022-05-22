package com.adn.alianza.model;

import com.adn.alianza.exceptions.ElementosNoValidos;
import com.adn.alianza.exceptions.TamanoInvalido;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Adn {

    @Id
    private String[] adn;


    public Adn() {
    }

    public Adn(String[] adn) throws TamanoInvalido {
        if(adn == null || adn.length == 0 || adn.length != adn[0].length()){
            throw new TamanoInvalido();
        }

        this.adn = adn;

    }

}
