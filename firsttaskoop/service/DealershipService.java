package firsttaskoop.service;

import firsttaskoop.enums.Origin;
import firsttaskoop.model.Bike;
import firsttaskoop.model.Car;
import firsttaskoop.model.Customer;
import firsttaskoop.model.Dealership;
import firsttaskoop.model.MotorBike;
import firsttaskoop.model.Vehicle;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DealershipService {

  private List<Dealership> dealerships = new ArrayList<>();
  private List<Customer> customerSystem = new ArrayList<>();

  public List<Dealership> getAllDealerships() {
    return dealerships;
  }

  public List<Customer> getAllCustomers() {
    return customerSystem;
  }

  public void addDealership(String name) {
    dealerships.add(new Dealership(name));
  }

  public void addCustomer(String name, String phone, String address, BigDecimal balance) {
    customerSystem.add(new Customer(name, phone, address, balance));
  }

  public boolean sellVehicle(Customer customer, String model, Dealership dealership) {
    Vehicle vehicle = dealership.findVehicle(model);
    if (vehicle == null) {
      return false;
    }
    return dealership.processActionBuy(vehicle, customer);
  }

  public List<Vehicle> getSuggestedVehicles(Dealership dealer, String modelName) {
    Vehicle vehicle = dealer.findVehicle(modelName);
    if (vehicle == null) {
      return dealer.getInventory();
    }
    return dealer.getAlternatives(vehicle);
  }

  public void addCarToDealer(Dealership dealer, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, int seats, String fuel, int cap, String body, int qty) {
    Car car = new Car(name, manufacturer, year, price, origin, seats, fuel, cap, body, qty);
    dealer.addVehicle(car);
  }

  public void addMotorbikeToDealer(Dealership dealer, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, int cap, int power, String bikeType, int qty) {
    MotorBike motorBike = new MotorBike(name, manufacturer, year, price, origin, cap, power,
        bikeType, qty);
    dealer.addVehicle(motorBike);
  }

  public void addBikeToDealer(Dealership dealer, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, String bikeType, String materials, int qty) {
    Bike bike = new Bike(name, manufacturer, year, price, origin, bikeType, materials, qty);
    dealer.addVehicle(bike);
  }
}
