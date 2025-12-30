package firsttaskoop;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Hãy nhập tên đại lý: ");
    String nameDealer = sc.nextLine();
    Dealership dealership = new Dealership(nameDealer);

    System.out.println("Bạn muốn khai báo bao nhiêu loại phương tiện vào kho?");

    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
      System.out.println("Nhập thông tin xe thứ " + (i + 1));
      System.out.println("Chọn loại xe:");
      System.out.println("1. Ô tô");
      System.out.println("2. Xe máy");
      System.out.println("3. Xe đạp/Xe đạp điện");

      int choice = sc.nextInt();
      sc.nextLine();

      System.out.print("Tên Model: ");
      String modelName = sc.nextLine();
      System.out.print("Hãng sản xuất: ");
      String manufacturer = sc.nextLine();
      System.out.print("Năm sản xuất: ");
      int birthYear = sc.nextInt();
      sc.nextLine();
      System.out.print("Giá gốc: ");
      BigDecimal originalPrice = sc.nextBigDecimal();
      sc.nextLine();
      System.out.print("Xuất xứ (Trong nuoc/ Ngoai nuoc): ");
      String origin = sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Số chỗ ngồi: ");
          int seatNumber = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại nhiên liệu (xăng/dầu/điện): ");
          String typeOfField = sc.nextLine();
          System.out.print("Dung tích động cơ: ");
          int capacity = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại thân xe: ");
          String bodyType = sc.nextLine();
          System.out.print("Số lượng: ");
          int quantityOfCar = sc.nextInt();
          dealership.addVehicle(new Car(modelName, manufacturer, birthYear, originalPrice, origin,
              seatNumber, typeOfField, capacity,
              bodyType, quantityOfCar));
          break;
        case 2:
          System.out.print("Dung tích xi-lanh: ");
          int cylinderCapacity = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại xe (xe số/xe ga): ");
          String typeOfMotorBike = sc.nextLine();
          System.out.print("Công suất: ");
          int power = sc.nextInt();
          sc.nextLine();
          System.out.print("Số lượng: ");
          int quantityOfMotorBike = sc.nextInt();
          dealership.addVehicle(
              new MotorBike(modelName, manufacturer, birthYear, originalPrice, origin,
                  cylinderCapacity, power,
                  typeOfMotorBike, quantityOfMotorBike));
          break;
        case 3:
          System.out.print("Loại xe (Xe đạp thường/trợ lực điện): ");
          String bikeType = sc.nextLine();
          System.out.print("Chất liệu khung: ");
          String frameMaterial = sc.nextLine();
          System.out.print("Số lượng: ");
          int quantityOfBike = sc.nextInt();
          dealership.addVehicle(
              new Bike(modelName, manufacturer, birthYear, originalPrice, origin,
                  frameMaterial, bikeType, quantityOfBike));
          break;
        default:
          System.out.println("Nhập sai loại xe!!");
          break;
      }
    }

    System.out.println("--------------------------------------");
    System.out.println("Bạn muốn nhập bao nhiêu khách hàng?");
    int numberCustomers = sc.nextInt();
    sc.nextLine();
    for (int k = 0; k < numberCustomers; k++) {
      System.out.println("Nhập thông tin khách hàng thứ " + (k + 1));
      System.out.print("Tên khách hàng: ");
      String nameCustomer = sc.nextLine();
      System.out.print("Số điện thoại: ");
      String phoneNumber = sc.nextLine();
      System.out.print("Địa chỉ: ");
      String email = sc.nextLine();
      System.out.print("Số dư ban đầu (nhập -1 để mặc định là 0): ");
      BigDecimal balance = sc.nextBigDecimal();
      sc.nextLine();

      if (balance.compareTo(BigDecimal.ZERO) < 0) {
        dealership.addCustomer(new Customer(nameCustomer, phoneNumber, email));
      } else {
        dealership.addCustomer(new Customer(nameCustomer, phoneNumber, email, balance));
        System.out.println("Khách hàng " + numberCustomers + " có muốn mua xe không?");
        System.out.println("1. Có || 2. Không");
        int select = sc.nextInt();
        sc.nextLine();
        switch (select) {
          case 1:
            dealership.showvehicles();
            System.out.println("Chọn xe số mấy?");
            int choice = sc.nextInt();
            Vehicle choosenVehicle = dealership.getVehicleById(choice - 1);
            Customer choosenCustomer = dealership.showCustomerById(k);
            if (choosenCustomer.buyVehicle(choosenVehicle)) {
              System.out.println(
                  "Khách hàng " + nameCustomer + " đã mua xe " + choosenVehicle.getNameModel()
                      + " thành công!!!");
            } else {
              System.out.print("Nhập số tiền muốn nạp: ");
              BigDecimal price = sc.nextBigDecimal();
              sc.nextLine();
              choosenCustomer.deposit(price);
            }
            break;
          case 2:
            System.out.println("Vạn sự tùy duyên hẹn khách hàng lần sau lại đến xem !!");
            break;
        }

      }
    }

    //Hiển thị số lượng khách hàng
    System.out.println("Số lượng khách hàng");
    for (int num = 0; num < numberCustomers; num++) {
      System.out.println("Thông tin cơ bản của khách hàng thứ " + (num + 1));
      dealership.getCustomerById(num);
    }

  }
}
