package com.example.hw2.repository;

import com.example.hw2.pojo.entity.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends CrudRepository<Provider,Integer> {

}
