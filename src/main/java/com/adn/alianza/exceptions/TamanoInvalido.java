package com.adn.alianza.exceptions;

public class TamanoInvalido extends Exception{
    public TamanoInvalido(){
        super("Tamaño del ADN no valido, Debe ser NxN");
    }
}
