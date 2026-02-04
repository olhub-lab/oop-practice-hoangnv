package firsttaskoop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

  private String name;
  private List<Vehicle> vehicles = new ArrayList<>();
  private List<Customer> customers = new ArrayList<>();

  public Dealership(String name) {
    this.name = name;
  }

  public String getName() {

    return name;
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

  public void addCustomer(Customer customer) {
    if (!checkingExistCustomer(customer)) {
      customers.add(customer);
    }
  }

  public boolean checkingExistCustomer(Customer otherCustomer) {
    for (Customer customer : customers) {
      if (customer.getPhoneNumber().equals(otherCustomer.getPhoneNumber())) {

        return true;
      }
    }

    return false;
  }

  public boolean processActionBuy(Vehicle vehicle, Customer customer) {
    if (vehicle == null || vehicle.getQuantity() <= 0) {

      return false;
    }

    BigDecimal finalPrice = vehicle.calculatePrice().multiply(BigDecimal.ONE.subtract(customer.getDiscount()));

    if (customer.checkingBalance(finalPrice)) {
      customer.pay(finalPrice);
      customer.addVehicle(vehicle);
      vehicle.updateQuantity(1);
      this.addCustomer(customer);

      return true;
    }

    return false;
  }

  public Vehicle findVehicle(String modelName) {
    for (Vehicle vehicle : vehicles) {
      if (vehicle.getNameModel().equalsIgnoreCase(modelName.trim())) {
        return vehicle;
      }
    }

    return null;
  }

  public List<Vehicle> getInventory() {
    return vehicles;
  }

  public List<Vehicle> getAlternatives(Vehicle targetVehicle) {
    List<Vehicle> alternatives = new ArrayList<>();
    for (Vehicle v : vehicles) {
      if (v.getClass().equals(targetVehicle.getClass()) &&
          !v.getNameModel().equalsIgnoreCase(targetVehicle.getNameModel()) &&
          v.getQuantity() > 0 &&
          v.calculatePrice().compareTo(targetVehicle.calculatePrice()) < 0) {

        alternatives.add(v);
      }
    }

    return alternatives;
  }
}