package com.aldeamo.service.numerosPrimo;

import org.springframework.stereotype.Service;

@Service
public class NumerosPrimosImpl implements INumerosPrimos {


    @Override
    public int[] ObtenerNumerosPrimos(int numeroMax) {

        int validador=1;
        int numeroAEvaluar=2;
        int contador=0;
        int[] respuesta = new int[numeroMax];
        int pos =0;

        while(validador<=numeroMax){
            contador=0;
            for(int i=1;i<=numeroAEvaluar;i++){
                if(numeroAEvaluar%i==0){
                   contador++;
                }
            }
              if(contador==2){
                  respuesta[pos]=numeroAEvaluar;
                  pos++;
                  validador++;
              }
            numeroAEvaluar++;
        }
        return respuesta;
    }
}
