package wsb.rest.cars.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Car {

    private Integer id;
    private String bodyType;
    private String brand;
    private String model;
    private String generation;
    private Double price;
    private Integer productionYear;
    private String fuelType;
    private Integer mileage;
    private String transmissionType;

}
