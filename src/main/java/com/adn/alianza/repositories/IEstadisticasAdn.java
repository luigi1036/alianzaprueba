package com.adn.alianza.repositories;

import com.adn.alianza.model.Estadisticas;
import com.adn.alianza.model.Stat;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEstadisticasAdn extends CrudRepository<Estadisticas, String> {
    @Query(nativeQuery = true, value = "select name, value from analisisadn.stats")
    List<Estadisticas> getStat();

}
