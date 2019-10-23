package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.QuanTriVienEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuanTriVienRepository extends PagingAndSortingRepository<QuanTriVienEntity, Integer> {

}
