package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.GioTauChayEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioTauChayRepository extends PagingAndSortingRepository<GioTauChayEntity, Integer> {

}
