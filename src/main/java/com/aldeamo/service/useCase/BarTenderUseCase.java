package com.aldeamo.service.useCase;

import com.aldeamo.service.procesarvasos.IProcesarVasos;
import com.aldeamo.service.arrays.IObtenerArrayPila;
import com.aldeamo.service.numerosPrimo.INumerosPrimos;
import com.aldeamo.util.Constantes;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;



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
            throw  new RuntimeException(Constantes.ERROR_RANGO_PILA);
        }
        if(iteraciones<1){
            throw  new RuntimeException(Constantes.ERROR_VALOR_ITERACIONES);
        }

        vasos= iObtenerArrayPila.obtenerRegistroPila(pila);
        if(vasos.length==0){
            throw  new RuntimeException(Constantes.ERROR_OBT_REGISTRO_PILA);
        }

        try {
            numerosPrimos =iNumerosPrimos.ObtenerNumerosPrimos(iteraciones);
        }catch (Exception e){
            throw  new RuntimeException(Constantes.ERROR_OBT_NUMEROS_PRIMOS);
        }

        try {
            respuesta =iProcesarVasos.obtenerVasos(numerosPrimos,vasos,iteraciones);
        }catch (Exception e){
            throw  new RuntimeException(Constantes.ERROR_OBT_VASOS);
        }





        return respuesta;
    }


}
