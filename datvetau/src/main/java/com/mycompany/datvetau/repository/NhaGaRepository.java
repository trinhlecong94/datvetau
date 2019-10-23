package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.NhaGaEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaGaRepository extends PagingAndSortingRepository<NhaGaEntity, Integer> {

}
