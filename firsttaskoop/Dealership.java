package firsttaskoop;

import java.util.ArrayList;

public class Dealership {

  private String name;
  private ArrayList<Vehicle> vehicles = new ArrayList<>();
  private ArrayList<Customer> customers = new ArrayList<>();

  public Dealership(String name) {
    this.name = name;
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
    System.out.println(
        "Đã thêm " + vehicle.getNameModel() + " vào kho. " + "Số lượng: " + vehicle.getQuantity());
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
    System.out.println("Đã thêm khách hàng " + customer.getName() + " vào danh sách!");
  }

  public Vehicle getVehicleById(int id) {
    if (id >= 0 || id < vehicles.size()) {
      return vehicles.get(id);
    } else {
      System.out.println("Lỗi: Không tìm thấy xe có id " + id);
      return null;
    }
  }

  public void getCustomerById(int id) {
    Customer customerById = customers.get(id);
    customerById.displayCustomer();

  }

  public void showvehicles() {
    System.out.println("Số lượng các loại xe hiện có:");
    for (int i = 0; i < vehicles.size(); i++) {
      System.out.println("Xe số " + (i + 1) + " có thông tin cơ bản như sau:");
      vehicles.get(i).giveBasicInformation();
    }
  }

  public Customer showCustomerById(int id) {
    return customers.get(id);
  }

}
