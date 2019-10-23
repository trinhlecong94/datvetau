package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.TauEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauRepository extends PagingAndSortingRepository<TauEntity, Integer> {

}
