package com.example.carsapi.rest;

import com.example.carsapi.dao.dto.Car;
import com.example.carsapi.dao.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/cars-api")
public class CarRestController {
    private CarService carService;

    private static final String VERSION ="v1";

    @Autowired
    public void setCarService(CarService carService){this.carService = carService;}

    @RequestMapping(method = RequestMethod.GET, value = VERSION + "/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok().body(cars);
    }

    @RequestMapping(method = RequestMethod.GET, value = VERSION+ "/cars/{vin}")
    public ResponseEntity<Car> getCarByVin(@NotNull @NotEmpty @PathVariable("vin") String vin){
        Car car = carService.getCarByVin(vin);
        return ResponseEntity.ok().body(car);
    }


}
