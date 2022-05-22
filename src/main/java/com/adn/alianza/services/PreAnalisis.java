package com.adn.alianza.services;

import com.adn.alianza.exceptions.AdnValidado;
import com.adn.alianza.exceptions.TamanoInvalido;
import com.adn.alianza.model.Adn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class PreAnalisis {

    private String[] secuencias = {"AAAA","GGGG","CCCC","TTTT"};

    @Autowired
    private IAnalisisAdnService iAnalisisAdnService;

    @Autowired
    private IAdnServices iAdnServices;


    public boolean isMutant(Adn adn) throws Exception {
        int encontrados = 0;
        boolean isMutant;
        String count_adn;

       Adn adnEncontrado =  iAdnServices.getAdnby(adn);
        if(adnEncontrado != null){
            throw new AdnValidado();
        }
        for(int i = 0; i< secuencias.length; i++){
                if(iAnalisisAdnService.isMutant(adn.getAdn(), secuencias[i])){
                    encontrados++;
                }
            }


        iAdnServices.save(adn);


        if(encontrados > 1){
            count_adn = "count_mutant_dna";
            isMutant = true;
        }else{
            count_adn = "count_human_dna";
            isMutant = false;
        }
        int canti = 0;

        canti = iAdnServices.all(count_adn);

        iAdnServices.update(count_adn, canti+1);
    return isMutant;
    }

}
