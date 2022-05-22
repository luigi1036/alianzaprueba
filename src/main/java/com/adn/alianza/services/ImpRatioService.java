package com.adn.alianza.services;

import com.adn.alianza.model.Estadisticas;
import com.adn.alianza.model.Stat;
import com.adn.alianza.repositories.AdnRepository;
import com.adn.alianza.repositories.IEstadisticasAdn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImpRatioService implements IRatioService{

    @Autowired
    private IEstadisticasAdn iEstadisticasAdn;

    @Autowired
    private AdnRepository adnRepository;


    @Override
    public Stat estadisticas() throws Exception {
        List<Estadisticas> listAdn = new ArrayList<>();
        listAdn = iEstadisticasAdn.getStat();
         Stat statratio = calcularratio(listAdn);
        return statratio;
    }

    private Stat calcularratio(List<Estadisticas> listaAdn) throws Exception{
        Stat statRatio = new Stat();
        System.out.println(listaAdn );
        Integer humanos = listaAdn.get(0).getValue();
        Integer mutantes = listaAdn.get(1).getValue();
        if(humanos == 0){
            throw new Exception("No se puede sacar el ratio");
        }
        double ratio = (mutantes/humanos);

        statRatio.setCount_human_dna(humanos);
        statRatio.setCount_mutant_dna(mutantes);
        statRatio.setRatio(ratio);
        return statRatio;
    }
}
