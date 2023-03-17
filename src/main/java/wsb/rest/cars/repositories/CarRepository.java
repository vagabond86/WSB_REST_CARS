package wsb.rest.cars.repositories;

import org.springframework.stereotype.Repository;
import wsb.rest.cars.models.Car;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    static Integer currentId = 26;
    private final List<Car> cars = new LinkedList<>() {{
        add(new Car(1, "sedan", "Toyota", "Camry", "XV50", 25000.0, 2018, "gasoline", 50000, "automatic"));
        add(new Car(2, "hatchback", "Honda", "Civic", "FK8", 30000.0, 2019, "gasoline", 35000, "manual"));
        add(new Car(3, "suv", "Jeep", "Grand Cherokee", "WK2", 40000.0, 2016, "diesel", 80000, "automatic"));
        add(new Car(4, "coupe", "BMW", "M4", "F82", 50000.0, 2015, "gasoline", 60000, "manual"));
        add(new Car(5, "convertible", "Audi", "A5", "B9", 35000.0, 2017, "gasoline", 40000, "automatic"));
        add(new Car(6, "sedan", "Mercedes-Benz", "C-Class", "W205", 28000.0, 2016, "diesel", 70000, "automatic"));
        add(new Car(7, "hatchback", "Volkswagen", "Golf", "Mk7", 20000.0, 2019, "gasoline", 25000, "manual"));
        add(new Car(8, "suv", "Ford", "Explorer", "Fifth generation", 35000.0, 2018, "gasoline", 50000, "automatic"));
        add(new Car(9, "coupe", "Chevrolet", "Camaro", "Sixth generation", 40000.0, 2017, "gasoline", 45000, "manual"));
        add(new Car(10, "convertible", "Fiat", "500", "Third generation", 15000.0, 2020, "gasoline", 10000, "manual"));
        add(new Car(11, "sedan", "Hyundai", "Elantra", "Sixth generation", 20000.0, 2017, "gasoline", 40000, "automatic"));
        add(new Car(12, "hatchback", "Subaru", "Impreza", "Fifth generation", 25000.0, 2018, "gasoline", 30000, "manual"));
        add(new Car(13, "suv", "Nissan", "Rogue", "Second generation", 30000.0, 2017, "gasoline", 50000, "automatic"));
        add(new Car(14, "coupe", "Lexus", "RC", "AL10", 45000.0, 2016, "gasoline", 60000, "automatic"));
        add(new Car(15, "convertible", "Mazda", "MX-5", "ND", 30000.0, 2019, "gasoline", 25000, "manual"));
        add(new Car(16, "coupe", "Porsche", "911", "992", 100000.0, 2021, "gasoline", 0, "automatic"));
        add(new Car(17, "coupe", "Ferrari", "488", "Pista", 350000.0, 2019, "gasoline", 5000, "automatic"));
        add(new Car(18, "coupe", "Lamborghini", "Huracan", "EVO", 300000.0, 2020, "gasoline", 10000, "automatic"));
        add(new Car(19, "coupe", "McLaren", "720S", "1st gen", 350000.0, 2019, "gasoline", 8000, "automatic"));
        add(new Car(20, "coupe", "Aston Martin", "Vantage", "2nd gen", 150000.0, 2021, "gasoline", 0, "automatic"));
        add(new Car(21, "coupe", "Mercedes-AMG", "GT", "2nd gen", 200000.0, 2021, "gasoline", 0, "automatic"));
        add(new Car(22, "coupe", "Nissan", "GT-R", "R35", 120000.0, 2021, "gasoline", 15000, "automatic"));
        add(new Car(23, "coupe", "Chevrolet", "Corvette", "C8", 80000.0, 2021, "gasoline", 0, "automatic"));
        add(new Car(24, "coupe", "BMW", "M8", "G15", 150000.0, 2021, "gasoline", 0, "automatic"));
        add(new Car(25, "coupe", "Ford", "Mustang", "Shelby GT500", 80000.0, 2021, "gasoline", 0, "manual"));
    }};

    public List<Car> findAll() {
        return cars;
    }

    public Car findCar(Integer id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Car> findBody(String bodyType) {
        return cars.stream()
                .filter(car -> car.getBodyType().equals(bodyType))
                .collect(Collectors.toList());
    }

    public List<Car> findTransmission(String transmissionType) {
        return cars.stream()
                .filter(car -> car.getTransmissionType().equals(transmissionType))
                .collect(Collectors.toList());
    }

    public List<Car> findFuel(String fuelType) {
        return cars.stream()
                .filter(car -> car.getFuelType().equals(fuelType))
                .collect(Collectors.toList());
    }


    public Car create(Car car) {
        Car createdCar = new Car(
                currentId++,
                car.getBodyType(),
                car.getBrand(),
                car.getModel(),
                car.getGeneration(),
                car.getPrice(),
                car.getProductionYear(),
                car.getFuelType(),
                car.getMileage(),
                car.getTransmissionType()
        );

        cars.add(createdCar);
        return createdCar;
    }

    public Car update(Integer id, Car car) {
        Car carToUpdate = findCar(id);
        if (carToUpdate == null){
            return null;
        }

        carToUpdate.setBodyType(car.getBodyType());
        carToUpdate.setBrand(car.getBrand());
        carToUpdate.setModel(car.getModel());
        carToUpdate.setGeneration(car.getGeneration());
        carToUpdate.setPrice(car.getPrice());
        carToUpdate.setProductionYear(car.getProductionYear());
        carToUpdate.setFuelType(car.getFuelType());
        carToUpdate.setMileage(carToUpdate.getMileage());
        carToUpdate.setTransmissionType(car.getTransmissionType());

        return carToUpdate;



    }
}
