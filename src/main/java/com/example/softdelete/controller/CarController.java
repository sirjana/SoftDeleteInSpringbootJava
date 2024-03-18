package com.example.softdelete.controller;

import com.example.softdelete.model.Car;
import com.example.softdelete.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/list")
    public List<Car> getAllEntities() {
        return carService.getAllEntities();
    }

    @PostMapping("/save")
    public ResponseEntity<Car> createEntity(@RequestBody Car car) {
        Car car1 = carService.saveEntity(car);
        return ResponseEntity.ok(car1);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable Long id) {
        carService.deleteEntity(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAllNotDeleted")
    public List<Car> findAllNotDeleted() {
       return carService.findAllNotDeleted();
    }

    @GetMapping("/findAllDeleted")
    public List<Car> findAllDeleted() {
        return carService.findAllDeleted();
    }
}
