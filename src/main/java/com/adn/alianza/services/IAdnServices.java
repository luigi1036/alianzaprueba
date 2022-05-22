package com.adn.alianza.services;

import com.adn.alianza.model.Adn;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.sql.SQLException;


public interface IAdnServices {

    public void save(Adn adn) throws SQLException;

    public int all(String stat) throws SQLException;

    public void update(String stat, int valor) throws SQLException;

    public Adn getAdnby(Adn adn) throws SQLException;
}
