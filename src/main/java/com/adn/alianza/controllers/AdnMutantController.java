package com.adn.alianza.controllers;

import com.adn.alianza.model.Adn;
import com.adn.alianza.model.Request;
import com.adn.alianza.model.Response;
import com.adn.alianza.services.PreAnalisis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class AdnMutantController {

    @Autowired
    private PreAnalisis preAnalisis;

    @PostMapping
    public ResponseEntity isMutant(@RequestBody Request request){
        try {
            System.out.println();
            if(preAnalisis.isMutant( new Adn(request.getDna())) ){
                return new ResponseEntity("Is Mutant", HttpStatus.OK);
            }else{
                return new ResponseEntity("isn't Mutant", HttpStatus.FORBIDDEN);
            }
        }catch (Exception e){
            Response response = new Response();
            response.setMensaje(e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }
}
