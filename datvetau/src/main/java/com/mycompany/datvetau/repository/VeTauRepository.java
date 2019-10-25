package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.VeTauEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VeTauRepository extends PagingAndSortingRepository<VeTauEntity, Integer> {

    @Query(value = "select v from VeTauEntity v where v.maSo = :maSo")
    List<VeTauEntity> findAllTicketByCode(@Param("maSo") String maSo);
}
