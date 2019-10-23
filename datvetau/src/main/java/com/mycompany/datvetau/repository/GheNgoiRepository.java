package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.GheNgoiEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GheNgoiRepository extends PagingAndSortingRepository<GheNgoiEntity, Integer> {

}
