package com.aldeamo.repositpory;

import com.aldeamo.model.Array;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrayRepository extends CrudRepository<Array,Integer> {
}
