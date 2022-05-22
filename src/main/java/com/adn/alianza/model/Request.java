package com.adn.alianza.model;

import lombok.Data;


@Data
public class Request {
    private String[] dna;

    public Request(){

    }
    public Request(String[] dna){
        this.dna = dna;
    }


}
