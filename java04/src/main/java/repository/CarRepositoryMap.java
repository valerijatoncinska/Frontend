package repository;

import domain.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryMap implements CarRepository {

    private Map<Long, Car> database = new HashMap<>();
    private long currentId;

    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(currentId, car);
        return car;
    }

    @Override
    public Car getById(Long id) {
        return database.get(id);
    }

    @Override
    public List<Car> getAll() {
        final long[] i = {0};
        List<Car> allCars = new ArrayList<>();
        database.forEach((key, value) -> {
            i[0] += key;
            allCars.add(getById(key));
        });
        return allCars;
    }

    @Override
    public Car update(Car car) {

//        BigDecimal newPrice = car.setPrice(car);
//
//        return new Car(car.getId(), car.getBrand(), newPrice, car.getYear());

        return null;
    }

    @Override
    public void delete(Long id) {
        database.remove(id);
    }
}