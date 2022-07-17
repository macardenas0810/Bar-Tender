package com.aldeamo.config;

import com.aldeamo.service.IProcesarVasos;
import com.aldeamo.service.useCase.BarTenderUseCase;
import com.aldeamo.service.arrays.IObtenerArrayPila;
import com.aldeamo.service.numerosPrimo.INumerosPrimos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {


    @Bean
    public BarTenderUseCase barTenderUseCase(INumerosPrimos iNumerosPrimos, IObtenerArrayPila iObtenerArrayPila,IProcesarVasos iProcesarVasos){
        return new BarTenderUseCase(iNumerosPrimos,iObtenerArrayPila,iProcesarVasos);
    }

}
