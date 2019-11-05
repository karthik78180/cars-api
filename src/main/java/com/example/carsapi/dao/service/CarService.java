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
        return carDbService.findAllCars().stream().map(CarService::mapCarDomainToCar).collect(Collectors.toList());
    }

    public  Car getCarByVin(String vin){
        return mapCarDomainToCar(carDbService.findCarByVin(vin));
    }


    private static Car mapCarDomainToCar(CarDomain carDomain) {
        Car car = new Car();
        car.setModel(carDomain.getModel());
        car.setMake(carDomain.getMake().trim());
        car.setVin(carDomain.getVin());

        return car;
    }

    private static CarDomain mapCarToCarDomain(Car car) {
        CarDomain carDomain = new CarDomain();
        carDomain.setModel(car.getModel());
        carDomain.setMake(car.getMake());
        carDomain.setVin(car.getVin());

        return carDomain;
    }

    public Car saveCar(Car car) {
        return mapCarDomainToCar(carDbService.save(mapCarToCarDomain(car)));
    }

    public void deleteByVin(String vin) {
         carDbService.deleteByVin(vin);
    }

    public Car updateByVin(Car car, String vin) {
        CarDomain carDomain =  carDbService.findCarByVin(vin);
        if(carDomain!=null) {
            carDomain.setMake(car.getMake());
            carDomain.setModel(car.getModel());
            return mapCarDomainToCar(carDbService.save(carDomain));
        }
        carDomain = mapCarToCarDomain(car);
        carDomain.setVin(vin);
        return mapCarDomainToCar(carDbService.save(carDomain));
    }
}
