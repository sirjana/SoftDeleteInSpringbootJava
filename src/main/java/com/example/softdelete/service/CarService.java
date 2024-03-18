package com.example.softdelete.service;

import com.example.softdelete.model.Car;
import com.example.softdelete.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllEntities() {
        return carRepository.findAll();
    }

    public Car saveEntity(Car car) {
        return carRepository.save(car);
    }

    public void deleteEntity(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> findAllNotDeleted(){
        return carRepository.findAllNotDeleted();
    }

    public List<Car> findAllDeleted(){
        return carRepository.findAllDeleted();
    }

}
