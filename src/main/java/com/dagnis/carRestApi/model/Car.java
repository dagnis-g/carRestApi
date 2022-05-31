package com.dagnis.carRestApi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @Column(name = "vin_number")
    @NotBlank
    private String vinNumber;
    @NotBlank
    private String make;
    @NotBlank
    private String model;
    @NotNull
    @Column(name = "car_year")
    private int year;
    @NotBlank
    @Column(name = "registration_number")
    private String registrationNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (year != car.year) return false;
        if (make != null ? !make.equals(car.make) : car.make != null) return false;
        if (vinNumber != null ? !vinNumber.equals(car.vinNumber) : car.vinNumber != null) return false;
        return registrationNumber != null ? registrationNumber.equals(car.registrationNumber) : car.registrationNumber == null;
    }

    @Override
    public int hashCode() {
        int result = make != null ? make.hashCode() : 0;
        result = 31 * result + year;
        result = 31 * result + (vinNumber != null ? vinNumber.hashCode() : 0);
        result = 31 * result + (registrationNumber != null ? registrationNumber.hashCode() : 0);
        return result;
    }
}
