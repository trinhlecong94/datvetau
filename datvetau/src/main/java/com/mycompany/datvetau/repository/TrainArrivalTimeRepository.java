package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.TrainArrivalTimeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainArrivalTimeRepository extends CrudRepository<TrainArrivalTimeEntity, Integer> {

}
