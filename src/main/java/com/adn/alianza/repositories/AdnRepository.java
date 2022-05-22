package com.adn.alianza.repositories;


import com.adn.alianza.model.Adn;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AdnRepository extends CrudRepository<Adn, String> {


    @Query(nativeQuery = true, value = "select value from analisisadn.stats where name = :stats ")
    Integer all(String stats );

    @Query(nativeQuery = true, value = "select adn from analisisadn.adn where adn = :adn ")
    String getAdnby(String adn );

    @Modifying
    @Query(nativeQuery = true, value = "insert into analisisadn.adn (adn) VALUES(:adn)")
    void save(String adn );

    @Modifying
    @Query(nativeQuery = true, value = "update analisisadn.stats set value = :valor where name = :stats")
    void update(String stats, int valor );

}
