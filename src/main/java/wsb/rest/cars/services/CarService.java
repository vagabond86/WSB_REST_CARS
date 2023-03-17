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

    public Car findCar(Integer id) {
        return carRepository.findCar(id);
    }

    public List<Car> findBody(String bodyType) {
        return carRepository.findBody(bodyType);
    }

    public List<Car> findTransmission(String transmissionType) {
        return carRepository.findTransmission(transmissionType);
    }

    public List<Car> findFuel(String fuelType) {
        return carRepository.findFuel(fuelType);
    }

    public Car create(Car car) {
        return carRepository.create(car);
    }

    public Car update(Integer id, Car car) {
        return carRepository.update(id, car);
    }
}
