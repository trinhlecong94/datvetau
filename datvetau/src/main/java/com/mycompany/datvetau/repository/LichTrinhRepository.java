package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.LichTrinhEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichTrinhRepository extends PagingAndSortingRepository<LichTrinhEntity, Integer> {

}
