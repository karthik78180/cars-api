package com.example.carsapi.data.service;

import com.example.carsapi.data.domain.CarDomain;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICarRepository extends PagingAndSortingRepository<CarDomain, Long> {
    List<CarDomain> findAll();

    CarDomain findByVin(String vin);

    void deleteByVin(String vin);


}
