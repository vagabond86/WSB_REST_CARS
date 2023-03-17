package wsb.rest.cars.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    ResponseEntity findAria(@PathVariable Integer id) {
        Car car = carService.find(id);
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
}
