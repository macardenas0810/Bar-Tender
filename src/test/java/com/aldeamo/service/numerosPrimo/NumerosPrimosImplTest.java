package com.aldeamo.service.numerosPrimo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
class NumerosPrimosImplTest {


    @InjectMocks
    NumerosPrimosImpl numerosPrimos;

    @Test
    void obtenerNumerosPrimos() {

        int[] rta =numerosPrimos.ObtenerNumerosPrimos(5);
        assertTrue(rta!=null);

    }
}