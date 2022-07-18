package com.aldeamo.service.arrays;


import com.aldeamo.model.Array;
import com.aldeamo.repository.ArrayRepository;
import com.aldeamo.util.Constantes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(MockitoExtension.class)
public class ArrayServiceImplTest {

    @InjectMocks
    ArrayServiceImpl arrayService;
    @Mock
    ArrayRepository arrayRepository;
    Array array=null;

    @BeforeEach
    void setUp() {
        array= Array.builder().id(1).inputArray("2,3,4,5,6").build();
    }


    @Test
    public void obtenerArrayById() {

        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            arrayService.obtenerArrayById(1);
        });
        assertTrue(Constantes.ERROR_NO_VALUE_PRESENT.contains(exception.getMessage()));

    }
}