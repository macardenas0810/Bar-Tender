package com.aldeamo.service;

import com.aldeamo.service.numerosPrimo.NumerosPrimosImpl;

public class nn {



    public static void main(String[] args) {

        NumerosPrimosImpl nn = new NumerosPrimosImpl();


        int[] i = nn.ObtenerNumerosPrimos(100);


        for (int j=0;j<i.length;j++){
            System.out.println(i[j]);

        }


    }
}
