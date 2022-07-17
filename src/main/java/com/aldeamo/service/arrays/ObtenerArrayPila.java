package com.aldeamo.service.arrays;

import com.aldeamo.model.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObtenerArrayPila implements IObtenerArrayPila{

    @Autowired
    private IArrayService iArrayService;

    @Override
    public String[] obtenerRegistroPila(int pila) {
        Array vasos=null;
        try {
            vasos = iArrayService.obtenerArrayById(pila);
        }catch (Exception e){
            throw new RuntimeException("Error al acceder a los datos");
        }
        return vasos.getInputArray().split(",");
    }
}
