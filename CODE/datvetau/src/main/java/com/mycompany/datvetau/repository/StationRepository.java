package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.StationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<StationEntity, Integer> {

    @Query(value = "select s from StationEntity s where s.stationName = :stationName")
    StationEntity findStationByName(@Param("stationName") String stationName);

}
