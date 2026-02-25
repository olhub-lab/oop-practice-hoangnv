package firsttaskoop.service;

import firsttaskoop.enums.Origin;
import firsttaskoop.exception.InvalidInputException;
import firsttaskoop.model.Bike;
import firsttaskoop.model.Car;
import firsttaskoop.model.Customer;
import firsttaskoop.model.Dealership;
import firsttaskoop.model.MotorBike;
import firsttaskoop.model.Vehicle;
import firsttaskoop.repository.CustomerRepository;
import firsttaskoop.repository.DBContext;
import firsttaskoop.repository.DealershipRepository;
import firsttaskoop.repository.VehicleRepository;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealershipService {

  private DealershipRepository dealershipRepository = new DealershipRepository();
  private VehicleRepository vehicleRepository = new VehicleRepository();
  private CustomerRepository customerRepository = new CustomerRepository();

  public List<Dealership> getAllDealerships() {
    return dealershipRepository.findAll();
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public void addDealership(String name) {
    dealershipRepository.save(new Dealership(name));
  }

  public void addCustomer(String name, String phone, String address, BigDecimal balance) {
    Connection conn = null;
    try {
      conn = DBContext.getInstance().getConnection();

      conn.setAutoCommit(false);

      Customer c = new Customer(name, phone, address, balance);

      customerRepository.save(conn, c);

      conn.commit();
      System.out.println("Thêm khách hàng thành công với ID: " + c.getId());

    } catch (Exception e) {
      if (conn != null) {
        try {
          conn.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      e.printStackTrace();
    } finally {
      if (conn != null) {
        DBContext.getInstance().releaseConnection(conn);
      }
    }
    ;
  }

  public boolean sellVehicle(int customerId, String modelName, int dealerId) {
    Connection conn = null;
    try {
      conn = DBContext.getInstance().getConnection();
      conn.setAutoCommit(false);

      Vehicle vehicle = vehicleRepository.findByNameAndDealer(conn, modelName, dealerId);
      if (vehicle == null || vehicle.getQuantity() <= 0) {
        return false;
      }

      Customer customer = customerRepository.findById(conn, customerId);
      if (customer == null) {
        return false;
      }

      BigDecimal discountRate = customer.getDiscount();
      BigDecimal priceAfterTax = vehicle.calculatePrice();
      BigDecimal finalPrice = priceAfterTax.multiply(BigDecimal.ONE.subtract(discountRate));

      if (customer.checkingBalance(finalPrice)) {
        customer.setAccountBalance(customer.getAccountBalance().subtract(finalPrice));
        customer.setOwnerVehicle(customer.getOwnerVehicle() + 1);
        customer.updateLoyaltyLevel();

        customerRepository.updateCustomerAfterSale(conn, customer);
        vehicleRepository.updateQuantity(conn, vehicle.getId(), -1);

        conn.commit();
        return true;
      }
      return false;
    } catch (Exception e) {
      if (conn != null) {
        try {
          conn.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      e.printStackTrace();
      return false;
    } finally {
      if (conn != null) {
        DBContext.getInstance().releaseConnection(conn);
      }
    }
  }

  public List<Vehicle> getSuggestedVehicles(int dealerId, String modelName) {
    Connection conn = null;
    try {
      conn = DBContext.getInstance().getConnection();
      Vehicle target = vehicleRepository.findByNameAndDealer(conn, modelName, dealerId);
      if (target == null) {
        return vehicleRepository.findByDealerId(dealerId);
      }
      return vehicleRepository.findAlternatives(dealerId, target.getId(),
          target.getClass().getSimpleName(), target.calculatePrice());
    } catch (SQLException e) {
      e.printStackTrace();
      return new ArrayList<>();
    } finally {
      if (conn != null) {
        DBContext.getInstance().releaseConnection(conn);
      }
    }
  }

  public void addCarToDealer(int dealerId, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, int seats, String fuel, int cap, String body, int qty) {
    Car car = new Car(name, manufacturer, year, price, origin, seats, fuel, cap, body, qty);
    saveVehicleHelper(car, dealerId);
  }

  public void addMotorbikeToDealer(int dealerId, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, int cap, int power, String bikeType, int qty) {
    MotorBike motorBike = new MotorBike(name, manufacturer, year, price, origin, cap, power,
        bikeType, qty);
    saveVehicleHelper(motorBike, dealerId);
  }

  public void addBikeToDealer(int dealerId, String name, String manufacturer, int year,
      BigDecimal price, Origin origin, String bikeType, String materials, int qty) {
    Bike bike = new Bike(name, manufacturer, year, price, origin, bikeType, materials, qty);
    saveVehicleHelper(bike, dealerId);
  }

  private void saveVehicleHelper(Vehicle v, int dealerId) {
    Connection conn = null;
    try {
      conn = DBContext.getInstance().getConnection();
      conn.setAutoCommit(false);

      if (v.getOriginalPrice().compareTo(BigDecimal.ZERO) < 0) {
        throw new InvalidInputException("Giá xe không được âm!");
      }

      vehicleRepository.save(conn, v, dealerId);
      conn.commit();
    } catch (Exception e) {
      if (conn != null) {
        try {
          conn.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      throw new RuntimeException("Lỗi hệ thống khi lưu xe: " + e.getMessage());
    } finally {
      if (conn != null) {
        DBContext.getInstance().releaseConnection(conn);
      }
    }
  }
}
