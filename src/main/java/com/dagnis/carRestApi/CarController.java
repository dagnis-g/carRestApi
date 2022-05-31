package com.dagnis.carRestApi;

import com.dagnis.carRestApi.model.Car;
import com.dagnis.carRestApi.model.swagger.ErrorSchema;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@CrossOrigin
@RestController
@RequestMapping("api/")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Add car in database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Car.class))}),
            @ApiResponse(responseCode = "400", description = "Error, invalid data, can't add car",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorSchema.class))})
    })
    @PostMapping("/add")
    public Car addCar(@Valid @RequestBody Car car) {
        return carService.addCar(car);
    }

    @Operation(summary = "Get all cars by Make")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found cars",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Car.class)))}),
            @ApiResponse(responseCode = "404", description = "No cars found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorSchema.class))})
    })
    @GetMapping("/make")
    public List<Car> getByMake(@Parameter(description = "make of cars to return") @RequestParam String make) {
        return carService.getCarsByMake(make);
    }

    @Operation(summary = "Export cars.json from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Json file exported",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Car.class)))})
    })
    @GetMapping("/export-car-json")
    public ResponseEntity<byte[]> exportCarJson() throws JsonProcessingException {
        return carService.exportCarsToJson();
    }

    @Operation(summary = "Import JSON file into database, overwrite all existing data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Json imported",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Car.class)))}),
            @ApiResponse(responseCode = "500", description = "Error, invalid data",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorSchema.class))})

    })
    @PostMapping(value = "import-car-json")
    public List<Car> importCarJson(@RequestBody List<@Valid Car> json) {
        return carService.importCarJsonInDb(json);
    }

}
