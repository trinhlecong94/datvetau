package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.CarriageTrainEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarriageTrainRepository extends CrudRepository<CarriageTrainEntity, Integer> {

}
