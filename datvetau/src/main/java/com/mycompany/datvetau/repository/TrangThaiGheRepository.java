package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.TrangThaiGheEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrangThaiGheRepository extends PagingAndSortingRepository<TrangThaiGheEntity, Integer> {

}
