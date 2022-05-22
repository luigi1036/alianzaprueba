package com.adn.alianza.services;

import org.springframework.stereotype.Service;

@Service
public class ImpAnalisisAdnService implements IAnalisisAdnService {


    @Override
    public boolean isMutant(String[] adn, String secuencia) throws Exception{

        for (int i = 0; i < adn.length; i++) {
            if (adn[i].contains(secuencia)) {
                return true;
            }

            String vertical = "";
            for (int j = 0; j < adn.length; j++) {
                vertical += adn[j].charAt(i);
            }
            if (vertical.contains(secuencia)) {
                return true;
            }

        }

        int diferenciaLengt = adn.length - secuencia.length();
        for(int i = diferenciaLengt; i >=0; i--) {
            String diagonal = "";
            for(int j = 0; j < adn.length-i; j++) {
                diagonal += adn[i+j].charAt(j);
            }
            if(diagonal.contains(secuencia)) {
                return true;
            }
        }
        for(int i = 1; i < adn.length - diferenciaLengt; i++ ) {
            String diagonalArriba = "";
            for(int j = 0; j < adn.length-i; j++) {
                diagonalArriba += adn[j].charAt(j+i);
            }
            if(diagonalArriba.contains(secuencia)) {
                return true;
            }
        }
        return false;
    }
}