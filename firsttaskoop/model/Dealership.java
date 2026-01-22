package firsttaskoop.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Dealership {

  private String name;
  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private ArrayList<Customer> customers = new ArrayList<>();

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

  public boolean processActionBuy(Vehicle v, Customer c) {
    if (v == null || v.getQuantity() <= 0) {
      return false;
    }

    BigDecimal finalPrice = v.calculatePrice().multiply(BigDecimal.ONE.subtract(c.getDiscount()));

    if (c.checkingBalance(finalPrice)) {
      c.pay(finalPrice);
      c.addVehicle(v);
      v.updateQuantity(1);
      this.addCustomer(c);
      return true;
    }
    return false;
  }

  public Vehicle findVehicle(String modelName) {
    for (Vehicle v : vehicles) {
      if (v.getNameModel().equalsIgnoreCase(modelName.trim())) {
        return v;
      }
    }
    return null;
  }

  public List<Vehicle> getInventory() {
    return vehicles;
  }

  public ArrayList<Vehicle> getAlternatives(Vehicle targetVehicle) {
    ArrayList<Vehicle> alternatives = new ArrayList<>();
    for (Vehicle v : vehicles) {
      if (v.getClass().equals(targetVehicle.getClass()) &&
          !v.getNameModel().equalsIgnoreCase(targetVehicle.getNameModel()) &&
          v.getQuantity() > 0) {
        alternatives.add(v);
      }
    }
    return alternatives;
  }
}