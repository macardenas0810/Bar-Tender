package com.aldeamo.service;

import com.aldeamo.service.procesarvasos.ProcesarVasos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProcesarVasosTest {

    @InjectMocks
    ProcesarVasos procesarVasos;


    @Test
    void obtenerVasos() {

        int[] numerosPrimos ={2,3,5};
        String[] vasos={"2","4","5","6","7","8"};
        int iteraciones=3;

        String obtenerVasos = procesarVasos.obtenerVasos(numerosPrimos,vasos,iteraciones);
        Assertions.assertTrue(obtenerVasos.equals("8,6,4,2,5,7"));

    }


}