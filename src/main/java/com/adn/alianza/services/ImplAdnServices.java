package com.adn.alianza.services;

import com.adn.alianza.model.Adn;
import com.adn.alianza.repositories.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
public class ImplAdnServices implements IAdnServices {

    @Autowired
    private AdnRepository adnRepository;

    @Override
    public void save(Adn adn)  throws SQLException {
       String resultado = getResultado(adn);
        adnRepository.save(resultado);
    }

    @Override
    public int all(String stat) {
        int cantidad = adnRepository.all(stat);
        return cantidad;
    }

    @Override
    public void update(String stat, int valor) {
        adnRepository.update(stat, valor);
    }

    @Override
    public Adn getAdnby(Adn adn) throws SQLException {
        String resultado = getResultado(adn);
        String resultadoEncontrado = adnRepository.getAdnby(resultado);
        if(resultadoEncontrado != null){
            Adn Adnencontrado = new Adn();
            Adnencontrado.setAdn(resultadoEncontrado.split("-"));
            return Adnencontrado;
        }
        return null;
    }

    private String getResultado(Adn adn){
        String resultado = "";
        for (int i = 0; i < adn.getAdn().length; i++) {
            resultado += adn.getAdn()[i] + "-";
        }
        resultado.substring(0, resultado.length() - 1);
        return resultado.substring(0, resultado.length() - 1);
    }

}
