package com.aldeamo.service.useCase;

import com.aldeamo.model.Array;
import com.aldeamo.service.arrays.IObtenerArrayPila;
import com.aldeamo.service.numerosPrimo.INumerosPrimos;
import com.aldeamo.service.procesarvasos.IProcesarVasos;
import com.aldeamo.util.Constantes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BarTenderUseCaseTest {

    @Mock
    INumerosPrimos iNumerosPrimos;

    @Mock
    IObtenerArrayPila iObtenerArrayPila;

    @Mock
    IProcesarVasos iProcesarVasos;

    @InjectMocks
    BarTenderUseCase barTenderUseCase;


    @Test
    void retirarVasos() {
        String[] vasos = {"2","4","5","6","7","8"};
        int[] numerosPrimos ={2,3,5};
        when(iObtenerArrayPila.obtenerRegistroPila(1)).thenReturn(vasos );
        when(iNumerosPrimos.ObtenerNumerosPrimos(3)).thenReturn(numerosPrimos );
        when(iProcesarVasos.obtenerVasos(numerosPrimos,vasos,3)).thenReturn("8,6,4,2,5,7");
        String rta = barTenderUseCase.retirarVasos(3,1);
        Assertions.assertTrue(rta.equals("8,6,4,2,5,7"));

    }

    @Test
    void validarErrores(){
        String[] vasos =null;
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            barTenderUseCase.retirarVasos(3,6);
        });
        assertTrue(Constantes.ERROR_RANGO_PILA.contains(exception.getMessage()));


        RuntimeException exception2 = assertThrows(RuntimeException.class, () -> {
            barTenderUseCase.retirarVasos(0,5);
        });
        assertTrue(Constantes.ERROR_VALOR_ITERACIONES.contains(exception2.getMessage()));

         vasos = new String[0];
        when(iObtenerArrayPila.obtenerRegistroPila(1)).thenReturn(vasos);

        RuntimeException exception3 = assertThrows(RuntimeException.class, () -> {
            barTenderUseCase.retirarVasos(3,1);
        });
        assertTrue(Constantes.ERROR_OBT_REGISTRO_PILA.contains(exception3.getMessage()));

        String[] vasos2 = {"2","4","5","6","7","8"};
        int[] numerosPrimos ={2,3,5};
        when(iObtenerArrayPila.obtenerRegistroPila(1)).thenReturn(vasos2 );
        when(iNumerosPrimos.ObtenerNumerosPrimos(3)).thenThrow(new RuntimeException());
        Exception exception4 = assertThrows(Exception.class, () -> {
            barTenderUseCase.retirarVasos(3,1);
        });
        assertTrue(Constantes.ERROR_OBT_NUMEROS_PRIMOS.contains(exception4.getMessage()));


    }


    @Test
    void ErrorObtenerVasos(){
        String[] vasos = {"2","4","5","6","7","8"};
        int[] numerosPrimos ={2,3,5};
        when(iObtenerArrayPila.obtenerRegistroPila(1)).thenReturn(vasos );
        when(iNumerosPrimos.ObtenerNumerosPrimos(3)).thenReturn(numerosPrimos );
        when(iProcesarVasos.obtenerVasos(numerosPrimos,vasos,3)).thenThrow(new RuntimeException());
        Exception exception5 = assertThrows(Exception.class, () -> {
            barTenderUseCase.retirarVasos(3,1);
        });
        assertTrue(Constantes.ERROR_OBT_VASOS.contains(exception5.getMessage()));
    }



}