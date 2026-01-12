package firsttaskoop;

import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Bạn muốn có bao nhiêu đại lý?");
    int T = sc.nextInt();
    sc.nextLine();

    ArrayList<Dealership> dealer = new ArrayList<>();

    while (T-- > 0) {
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
      dealer.add(dealership);
    }

    ArrayList<Customer> customers = new ArrayList<>();
    System.out.println("PHẦN KHAI THÔNG TIN KHÁCH HÀNG");
    System.out.println("Nhập số lượng khách hàng:");
    int soLuongKhachHang = sc.nextInt();
    sc.nextLine();

    while (soLuongKhachHang-- > 0) {
      System.out.println("Xin Chào! Vui lòng nhập thông tin cá nhân của bạn!");
      System.out.println("Bạn tên là ?");
      String name = sc.nextLine();
      System.out.println("Cho mình xin số điện thoại nha!!");
      String phone = sc.nextLine();
      System.out.println("Mình xin địa chỉ để dễ dàng liên hệ với bạn hơn nè!!");
      String address = sc.nextLine();
      System.out.println(
          "Bạn có muốn sử dụng dịch vụ mua xe của chúng mình khong ?! (1. Có | 2. Không)");
      int choice = sc.nextInt();
      sc.nextLine();
      switch (choice) {
        case 1:
          System.out.println("Để sử dụng dịch vụ bạn hãy nạp một chút nhé!!");
          BigDecimal amount = new BigDecimal(sc.nextLine());
          customers.add(new Customer(name, phone, address, amount));
          break;
        case 2:
          System.out.println("Vậy bạn hãy cứ trải nghiệm nha");
          customers.add(new Customer(name, phone, address));
          break;
      }
    }

    System.out.println("===> PHẦN INPUT TASK 3 <===");

    boolean continueShopping = true;
    while (continueShopping) {
      System.out.println("\n>>> DANH SÁCH KHÁCH HÀNG:");
      for (int i = 0; i < customers.size(); i++) {
        System.out.printf("%d. %s (Số dư: %.2f VNĐ)\n",
            (i + 1),
            customers.get(i).getName(),
            customers.get(i).getAccountBalance());
      }
      System.out.print("Chọn khách hàng (nhập số): ");
      int choiceCustomer = sc.nextInt();
      sc.nextLine();
      Customer selectedCustomer = customers.get(choiceCustomer - 1);

      System.out.println("DANH SÁCH ĐẠI LÝ:");
      for (int i = 0; i < dealer.size(); i++) {
        System.out.println((i + 1) + ". " + dealer.get(i).getName());
      }
      System.out.print("Chọn đại lý mua xe (nhập số): ");
      int choiceDealer = sc.nextInt();
      sc.nextLine();
      Dealership selectedDealer = dealer.get(choiceDealer - 1);

      System.out.println("------------------------------------------------------------");

      if (!selectedDealer.checkingExistCustomer(selectedCustomer)) {
        selectedDealer.addCustomer(selectedCustomer);
      }

      System.out.println("------------------------------------------------------------");

      System.out.println("KHO XE CỦA " + selectedDealer.getName().toUpperCase() + "HIỆN CÓ:");
      selectedDealer.showVehicles();

      System.out.println();

      System.out.print("Nhập chính xác TÊN MODEL xe bạn muốn mua: ");
      String nameVehicle = sc.nextLine();

      selectedDealer.sellVehicle(nameVehicle, selectedCustomer);

      System.out.println("---------------------------------------");
      System.out.print("Bạn có muốn thực hiện giao dịch khác không? (1. Có / 0. Không): ");
      int selected = sc.nextInt();
      sc.nextLine();
      if (selected == 0) {
        continueShopping = false;
        System.out.println("Cảm ơn quý khách. Hẹn gặp lại!!!!");
      }
    }
  }
}
