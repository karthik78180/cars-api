package com.example.carsapi.data.service;

import com.example.carsapi.dao.dto.Car;
import com.example.carsapi.data.domain.CarDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Component
@Transactional
public class CarDbService {
    @Autowired
    private ICarRepository carsRepository;

    public List<CarDomain> findAllCars() {
        List<CarDomain> cars;
        cars = carsRepository.findAll();

        if (cars == null || cars.isEmpty()) cars = Collections.emptyList();

        return cars;

    }

    public CarDomain findCarByVin(String vin) {
        return carsRepository.findByVin(vin);
    }

    //public void setCarsRepository(ICarRepository carsRepository){this.carsRepository = carsRepository;}

    public CarDomain save(CarDomain car) {
        return carsRepository.save(car);
    }

    public void deleteByVin(String vin) {
         carsRepository.deleteByVin(vin);
    }
}
