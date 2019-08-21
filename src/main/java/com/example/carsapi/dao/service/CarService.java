package com.example.carsapi.dao.service;

import com.example.carsapi.dao.dto.Car;
import com.example.carsapi.data.domain.CarDomain;
import com.example.carsapi.data.service.CarDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private CarDbService carDbService;

    @Autowired
    public void setCarDbService(CarDbService carDbService){
        this.carDbService = carDbService;
    }
    public List<Car> getAllCars(){
        return carDbService.findAllCars().stream().map(CarService::mapCarToCarDomain).collect(Collectors.toList());
    }

    public  Car getCarByVin(String vin){
        return mapCarToCarDomain(carDbService.findCarByVin(vin));
    }


    private static Car mapCarToCarDomain(CarDomain carDomain) {
        Car car = new Car();
        car.setModel(carDomain.getModel());
        car.setMake(carDomain.getMake());
        car.setVin(carDomain.getVin());

        return car;
    }


}
