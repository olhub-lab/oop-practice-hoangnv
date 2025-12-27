package firsttaskoop;

import java.util.ArrayList;

public class Dealership {

  private String nameDealer;
  private ArrayList<Vehicle> inventory = new ArrayList<>();
  private ArrayList<Customer> customers = new ArrayList<>();

  public Dealership(String nameDealer) {
    this.nameDealer = nameDealer;
  }

  public void addVehicle(Vehicle vehicle) {
    inventory.add(vehicle);
    System.out.println(
        "Đã thêm " + vehicle.getNameModel() + " vào kho. " + "Số lượng: " + vehicle.getQuantity());
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
    System.out.println("Đã thêm khách hàng " + customer.getName() + " vào danh sách!");
  }

  public Vehicle getVehicleById(int id) {
    return inventory.get(id);
  }

  public void getCustomerById(int id) {
    Customer customerById = customers.get(id);
    customerById.displayCustomer();

  }

  public void showInventory() {
    for (int i = 0; i < inventory.size(); i++) {
      System.out.println("Số lượng các loại xe hiện có:");
      System.out.println("Xe số " + (i + 1) + " có thông tin cơ bản như sau:");
      inventory.get(i).giveBasicInformation();
    }
  }

  public Customer showCustomerById(int id) {
    return customers.get(id);
  }

}
