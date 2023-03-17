package wsb.rest.cars.services;

import org.springframework.stereotype.Service;
import wsb.rest.cars.models.Car;
import wsb.rest.cars.repositories.CarRepository;

import java.util.List;

@Service
public class CarService {

    final private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }
}
