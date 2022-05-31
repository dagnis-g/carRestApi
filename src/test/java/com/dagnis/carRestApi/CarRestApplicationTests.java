package com.dagnis.carRestApi;

import com.dagnis.carRestApi.model.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@SpringBootTest
class CarRestApiApplicationTests {

    @Autowired
    CarController carController;
    @Autowired
    CarRepository carRepository;

    @Test
    public void shouldAddCar() {
        String vinNumber = "JTHBE5C25A5510000";
        String make = "Honda";
        String model = "Civic";
        int year = 2000;
        String registrationNumber = "ZM1223";

        Car carToAdd = new Car(vinNumber, make, model, year, registrationNumber);
        carController.addCar(carToAdd);
        Car carExpected = carRepository.findById("JTHBE5C25A5510000").get();

        Assertions.assertEquals(carExpected, carToAdd);
    }

    @Test
    public void shouldThrowWithIncompleteCarData() {
        String vinNumber = "JTHBE5C25A5510001";
        String make = "";
        String model = "";
        int year = 2000;
        String registrationNumber = "ZM1223";

        Car carToAdd = new Car(vinNumber, make, model, year, registrationNumber);

        Assertions.assertThrows(ConstraintViolationException.class, () -> carController.addCar(carToAdd));
    }

    @Test
    public void shouldFindByMake() {
        String make = "exampleMake";
        Car car1 = new Car("JTHBE5C25A5510002", make, "model1", 2020, "EX1234");
        Car car2 = new Car("JTHBE5C25A5510003", make, "model2", 2021, "EX5678");
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> carsExpected = List.of(car1, car2);
        List<Car> carsFound = carController.getByMake(make);

        Assertions.assertEquals(carsExpected, carsFound);
    }

    @Test
    public void shouldThrowIfNoCarsFoundByMake() {
        String make = "noMake";
        Assertions.assertThrows(ResponseStatusException.class, () -> carController.getByMake(make));
    }

    @Test
    public void shouldImportJsonToDbAndOverwriteCurrentData() {
        Car car6 = new Car("JTHBE5C25A5510012", "make1", "model1", 2020, "PX1234");
        Car car5 = new Car("JTHBE5C25A5510023", "mak2", "model2", 2021, "PX5678");
        Car car4 = new Car("JTHBE5C25A5510024", "mak2", "model2", 2021, "PX5679");
        carRepository.save(car6);
        carRepository.save(car5);
        carRepository.save(car4);

        Car car1 = new Car("JTHBE5C25A5510004", "make3", "model1", 2020, "XX1234");
        Car car2 = new Car("JTHBE5C25A5510005", "mak4", "model2", 2021, "XX5678");
        List<Car> carsToImport = List.of(car1, car2);
        carController.importCarJson(carsToImport);

        List<Car> carsInDb = carRepository.findAll();

        Assertions.assertEquals(carsToImport.size(), carsInDb.size());
    }

    @Test
    public void shouldThrowIfSomeCarInJsonImportIncompleteData() {
        Car car1 = new Car("JTHBE5C25A5510006", "make5", "model1", 2020, "ZX1234");
        Car car2 = new Car("JTHBE5C25A5510006", "mak6", "", 2021, "ZX5678");
        List<Car> carsToImport = List.of(car1, car2);

        Assertions.assertThrows(ConstraintViolationException.class, () -> carController.importCarJson(carsToImport));
    }

    @Test
    public void shouldExportCorrectData() throws JsonProcessingException {
        carRepository.deleteAll();

        Car car1 = new Car("JTHBE5C25A5510004", "make3", "model1", 2020, "XX1234");
        Car car2 = new Car("JTHBE5C25A5510005", "mak4", "model2", 2021, "XX5678");
        carRepository.save(car1);
        carRepository.save(car2);
        
        ObjectMapper mapper = new ObjectMapper();
        List<Car> carsToImport = List.of(car1, car2);
        byte[] expected = mapper.writeValueAsBytes(carsToImport);

        byte[] actual = carController.exportCarJson().getBody();

        Assertions.assertArrayEquals(expected, actual);
    }
}
