package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.VeTauEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeTauRepository extends PagingAndSortingRepository<VeTauEntity, Integer> {

}
