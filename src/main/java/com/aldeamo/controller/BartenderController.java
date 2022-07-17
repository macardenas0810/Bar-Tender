package com.aldeamo.controller;

import com.aldeamo.service.useCase.BarTenderUseCase;
import com.aldeamo.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class BartenderController {

 @Autowired
 private BarTenderUseCase barTenderUseCase;
 private ResponseEntity response;


 @GetMapping(value = "/retirarVasos/{q}/{pila}",produces = "application/json")
    public ResponseEntity<?> barTenderRetirarVasos(@PathVariable(name ="q" ) int iteraciones,@PathVariable(name ="pila" ) int pila){
        Map<String,Object> rta = new HashMap<>();
        String respuesta="";

        try{
            respuesta = barTenderUseCase.retirarVasos(iteraciones,pila);
            rta.put(Constantes.MSG,Constantes.PROCESO);
            rta.put(Constantes.CUERPO,respuesta);
            response = new ResponseEntity(rta,HttpStatus.OK);
          }catch (Exception e){
              rta.put(Constantes.MSG,e.getMessage());
              rta.put(Constantes.CUERPO,"");

              response = new ResponseEntity<>(rta, HttpStatus.NOT_FOUND);
          }



     return response;

 }


}
