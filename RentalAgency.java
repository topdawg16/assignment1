/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leovean
 */
import java.util.*;

public class RentalAgency {
    private List<Car> cars;
    private Map<Integer, Customer> customers;
    private Map<Integer, List<String>> rentalRecords;

    public RentalAgency() {
        cars = new ArrayList<>();
        customers = new HashMap<>();
        rentalRecords = new HashMap<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public String rentCar(int customerId, String licensePlate) {
        if (!customers.containsKey(customerId)) {
            return "Customer not found!";
        }

        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && car.isAvailable()) {
                car.setAvailable(false);
                rentalRecords.computeIfAbsent(customerId, k -> new ArrayList<>()).add(licensePlate);
                return "Car rented successfully!";
            }
        }
        return "Car is not available!";
    }

    public String returnCar(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && !car.isAvailable()) {
                car.setAvailable(true);
                return "Car returned successfully!";
            }
        }
        return "Car not found or already returned!";
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }
}
