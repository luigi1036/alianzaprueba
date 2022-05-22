package com.adn.alianza.controllers;

import com.adn.alianza.model.Stat;
import com.adn.alianza.services.IRatioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsAdnController {

    @Autowired
    private IRatioService iRatioService;

    @GetMapping
    public ResponseEntity<Stat> getStats() throws Exception{
        try {
            Stat stat = iRatioService.estadisticas();
            return new ResponseEntity<>(stat, HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
