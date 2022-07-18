package com.aldeamo.service.arrays;

import com.aldeamo.model.Array;
import com.aldeamo.util.Constantes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Assertions;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerArrayPilaTest {

    @Mock
    IArrayService iArrayService;

    @InjectMocks
    ObtenerArrayPila obtenerArrayPila;



    @Test
    void obtenerRegistroPila() {
        when(iArrayService.obtenerArrayById(1)).thenReturn(Array.builder().id(1).inputArray("1,2,3,5").build());
        String[] rta =obtenerArrayPila.obtenerRegistroPila(1);
        Assertions.assertTrue(rta!=null);
    }

    @Test
    void validarError() {
        when(iArrayService.obtenerArrayById(1)).thenThrow(new RuntimeException());
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            obtenerArrayPila.obtenerRegistroPila(1);
        });
        assertTrue(Constantes.ERROR_ACCEDER_DATOS.contains(exception.getMessage()));
    }
}