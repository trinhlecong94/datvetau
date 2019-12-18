package com.mycompany.datvetau.repository;

import com.mycompany.datvetau.entities.AdministratorsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorsRepository extends CrudRepository<AdministratorsEntity, Integer> {

}
