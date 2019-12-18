package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.ScheduleEntity;
import com.mycompany.datvetau.entities.TrainEntity;
import java.util.Date;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Integer> {

    @Query(value = "select s from ScheduleEntity s where s.train = :train")
    ScheduleEntity findSchedulebyTrain(@Param("train") TrainEntity train);

    @Query(value = "select s from ScheduleEntity s where s.departureTime = :departureTime")
    List<ScheduleEntity> findScheduleByDate(@Param("departureTime") Date departureTime);

    @Query(value = "select s from ScheduleEntity s where s.departureTime = :departureTime and s.train = :train")
    List<ScheduleEntity> findScheduleByDateAndTrain(@Param("departureTime") Date departureTime,@Param("train") TrainEntity train);
}
