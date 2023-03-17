package wsb.rest.cars.controllers;

import org.springframework.web.bind.annotation.GetMapping;
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
}
