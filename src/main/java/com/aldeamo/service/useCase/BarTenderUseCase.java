package com.aldeamo.service.useCase;

import com.aldeamo.service.IProcesarVasos;
import com.aldeamo.service.arrays.IObtenerArrayPila;
import com.aldeamo.service.numerosPrimo.INumerosPrimos;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@AllArgsConstructor
public class BarTenderUseCase {

   @Autowired
   private INumerosPrimos iNumerosPrimos;

   @Autowired
   private IObtenerArrayPila iObtenerArrayPila;

   @Autowired
   private IProcesarVasos iProcesarVasos;


    public String retirarVasos(int iteraciones, int pila) {

        String[] vasos =null;
        int[] numerosPrimos =null;
        String respuesta=null;

        if(pila<1 || pila >5){
            throw  new RuntimeException("La pila a seleccionar debe estar dentro de 1 y 5");
        }
        if(iteraciones<1){
            throw  new RuntimeException("para obtener los numeros primos se debe enviar un numero mayor a 1");
        }

        vasos= iObtenerArrayPila.obtenerRegistroPila(pila);
        if(vasos.length==0){
            throw  new RuntimeException("La pila seleccionada no contiene registros validos");
        }

        try {
            numerosPrimos =iNumerosPrimos.ObtenerNumerosPrimos(iteraciones);
        }catch (Exception e){
            throw  new RuntimeException("No se pudo obtener los números primos para las iteraciones enviadas");
        }

        try {
            respuesta =iProcesarVasos.obtenerVasos(numerosPrimos,vasos,iteraciones);
        }catch (Exception e){
            throw  new RuntimeException("No se pudo obtener los números primos para las iteraciones enviadas");
        }





        return respuesta;
    }


}
