package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.TauEntity;
import com.mycompany.datvetau.entities.VeTauEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TauRepository extends PagingAndSortingRepository<TauEntity, Integer> {

    @Query(value = "select t from TauEntity t where t.tenTau = :tenTau")
    TauEntity findTrainByName(@Param("tenTau") String tenTau);
}
