package com.aldeamo.service.procesarvasos;


import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ProcesarVasos implements IProcesarVasos {


    @Override
    public String obtenerVasos(int[] numerosPrimos, String[] vasos,int iteraciones) {

        Integer[] a=new Integer[0];
        Integer[] b= new Integer[0];
        int posNumPrimo=0;
        int incrementArrayA=1;
        int incrementArrayB=1;
        Object[] ai=null;
        vasos= invertirArray(vasos);
        ai=vasos;
        String respuesta="";
       for(int i=1;i<=iteraciones;i++){
           if(i!=1){
               ai =a;
               a=new Integer[0];
               incrementArrayA=1;
           }
           for(int j=0;j<(ai.length);j++){
               if(Integer.parseInt(ai[j].toString())%numerosPrimos[posNumPrimo]==0){
                    b= Arrays.copyOf(b,incrementArrayB);
                   incrementArrayB++;
                  b[(b.length-1)]=Integer.parseInt(ai[j].toString());
               }else{
                   a= Arrays.copyOf(a,incrementArrayA);
                   incrementArrayA++;
                   a[(a.length-1)]=Integer.parseInt(ai[j].toString());
               }
           }
           posNumPrimo++;
       }
        if(a.length>0){
            for(Object elementoA :a){
                b= Arrays.copyOf(b,incrementArrayB);
                incrementArrayB++;
                b[(b.length-1)]=Integer.parseInt(elementoA.toString());
            }
        }

        for(Object elementoB:b){
            respuesta=respuesta.concat(elementoB.toString()).concat(",");
        }
        return respuesta.substring(0,(respuesta.length()-1));
    }

    @Override
    public String[] invertirArray(String[] numerosPrimos) {

        String[] invertir = new String[(numerosPrimos.length)];
         int cont=0;
        for(int i=(numerosPrimos.length-1);i>=0;i--){
           invertir[cont]=numerosPrimos[i];
           cont ++;
        }
        return invertir;
    }
}
