/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Leovean
 */
public class TestRentalSystem {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Add cars
        Car car1 = new Car("ABC123", "Toyota Corolla");
        Car car2 = new Car("XYZ789", "Honda Civic");
        agency.addCar(car1);
        agency.addCar(car2);

        // Add customers
        Customer customer1 = new Customer(1, "John Doe", "123-456-7890");
        Customer customer2 = new Customer(2, "Jane Smith", "098-765-4321");
        agency.addCustomer(customer1);
        agency.addCustomer(customer2);

        // Test renting cars
        System.out.println(agency.rentCar(1, "ABC123")); // Success
        System.out.println(agency.rentCar(2, "ABC123")); // Already rented
        System.out.println(agency.rentCar(3, "XYZ789")); // Customer not found

        // Test returning cars
        System.out.println(agency.returnCar("ABC123")); // Success
        System.out.println(agency.returnCar("ABC123")); // Already returned

        // Test available cars
        System.out.println("Available cars:");
        for (Car car : agency.getAvailableCars()) {
            System.out.println(car);
        }
    }
}

