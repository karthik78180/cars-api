package com.example.carsapi.data.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Cars")
@Data
@NoArgsConstructor
public class CarDomain {
    @Id
    @Column(name = "VIN")
    private String vin;

    @Column(name = "Make")
    private String make;

    @Column(name = "Model")
    private String model;
}
