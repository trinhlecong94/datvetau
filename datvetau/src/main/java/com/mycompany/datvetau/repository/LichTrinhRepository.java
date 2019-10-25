package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import com.mycompany.datvetau.entities.TauEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LichTrinhRepository extends PagingAndSortingRepository<LichTrinhEntity, Integer> {

    @Query(value = "select l from LichTrinhEntity l where l.tau = :tau")
    LichTrinhEntity findSchedulebyTrain(@Param("tau") TauEntity tau);
}
