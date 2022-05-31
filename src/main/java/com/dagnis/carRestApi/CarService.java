package com.dagnis.carRestApi;

import com.dagnis.carRestApi.model.Car;
import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getCarsByMake(String make) {
        List<Car> cars = carRepository.getCarsByMakeIgnoreCase(make);
        if (cars.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return cars;
    }

    public ResponseEntity<byte[]> exportCarsToJson() {
        Gson gson = new Gson();
        List<Car> carsList = carRepository.findAll();
        byte[] cars = gson.toJson(carsList).getBytes();
        
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=cars.json")
                .contentType(MediaType.APPLICATION_JSON)
                .contentLength(cars.length)
                .body(cars);
    }

    public List<Car> importCarJsonInDb(List<Car> json) {
        carRepository.deleteAll();
        return carRepository.saveAll(json);
    }

}
