package wsb.rest.cars.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsb.rest.cars.models.Car;
import wsb.rest.cars.services.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    final private CarService carService;


    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity findCar(@PathVariable Integer id) {
        Car car = carService.findCar(id);
        if (car != null) {
            return ResponseEntity.ok(car);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/bodyType/{bodyType}")
    ResponseEntity<List<Car>> findBodyType(@PathVariable String bodyType) {
        List<Car> cars = carService.findBody(bodyType);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/transmissionType/{transmissionType}")
    ResponseEntity<List<Car>> findTransmissionType(@PathVariable String transmissionType) {
        List<Car> cars = carService.findTransmission(transmissionType);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/fuelType/{fuelType}")
    ResponseEntity<List<Car>> findFuelType(@PathVariable String fuelType) {
        List<Car> cars = carService.findFuel(fuelType);
        if (!cars.isEmpty()) {
            return ResponseEntity.ok(cars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<Car> create(@RequestBody Car car) {
        Car createdCar = carService.create(car);
        if (createdCar != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Car> update(@PathVariable Integer id, @RequestBody Car car) {
        Car updatedCar = carService.update(id, car);
        if (updatedCar != null) {
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Integer id){
        carService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/priceRange")
    ResponseEntity<List<Car>>findByPriceRange(@RequestParam("minPrice") Double minPrice, @RequestParam("maxPrice") Double maxPrice){
        List<Car>cars = carService.findByPriceRange(minPrice, maxPrice);
        if (!cars.isEmpty()){
            return ResponseEntity.ok(cars);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
