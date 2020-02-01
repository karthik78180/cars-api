package com.example.carsapi.rest;

import com.example.carsapi.dao.dto.Car;
import com.example.carsapi.dao.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET, value = VERSION + "/cars",  produces={"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.ok().body(cars);
    }

    @RequestMapping(method = RequestMethod.GET, value = VERSION+ "/cars/{vin}")
    public ResponseEntity<Car> getCarByVin(@NotNull @NotEmpty @PathVariable("vin") String vin){
        Car car = carService.getCarByVin(vin);
        return ResponseEntity.ok().body(car);
    }

    @RequestMapping(method = RequestMethod.POST, value = VERSION+ "/cars")
    public ResponseEntity<Car> saveCar(@NotNull @NotEmpty @RequestBody Car car){
         car = carService.saveCar(car);
        return ResponseEntity.ok().body(car);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = VERSION+ "/cars/{vin}")
    public void deleteCar(@NotNull @NotEmpty  @PathVariable("vin") String vin) {
          carService.deleteByVin(vin);

    }

    @RequestMapping(method = RequestMethod.PUT, value = VERSION+ "/cars/{vin}")
   public Car replaceCar(@NotNull @NotEmpty @RequestBody Car car,@NotNull @NotEmpty  @PathVariable("vin") String vin) {

        return carService.updateByVin(car, vin);
                    }



}
