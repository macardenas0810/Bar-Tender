package com.aldeamo.service.arrays;


import com.aldeamo.model.Array;
import com.aldeamo.repository.ArrayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ArrayServiceImpl implements IArrayService {

    @Autowired
    ArrayRepository arrayRepository;


    @Override
    @Transactional(readOnly = true)
    public Array obtenerArrayById(Integer id) {
        return arrayRepository.findById(id).get();
    }
}
