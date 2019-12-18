package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.SeatEntity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends CrudRepository<SeatEntity, Integer> {

    @Query(value = "select s from SeatEntity s where s.id = :id")
    SeatEntity findSeatById(@Param("id") int id);
}
