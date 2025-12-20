package firsttaskoop;

import java.util.Scanner;
import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Bạn muốn khai báo bao nhiêu loại phương tiện?");

    int n = sc.nextInt();
    sc.nextLine();

    Vehicles[] carList = new Vehicles[n];
    for (int i = 0; i < n; i++) {
      System.out.println("Nhập thông tin xe thứ " + (i + 1));
      System.out.println("Chọn loại xe:");
      System.out.println("1. Ô tô");
      System.out.println("2. Xe máy");
      System.out.println("3. Xe đạp/Xe đạp điện");

      int choice = sc.nextInt();
      sc.nextLine();

      System.out.print("Tên Model: ");
      String birthYeare = sc.nextLine();
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
          carList[i] = new Car(birthYeare, manufacturer, birthYear, originalPrice, origin, seatNumber, typeOfField, capacity,
              bodyType);
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
          carList[i] = new MotorBike(birthYeare, manufacturer, birthYear, originalPrice, origin, cylinderCapacity, power,
              typeOfMotorBike);
          break;
        case 3:
          System.out.print("Loại xe (Xe đạp thường/trợ lực điện): ");
          String bikeType = sc.nextLine();
          System.out.print("Chất liệu khung: ");
          String frameMaterial = sc.nextLine();
          carList[i] = new Bike(birthYeare, manufacturer, birthYear, originalPrice, origin, frameMaterial, bikeType);
          break;
        default:
          System.out.println("Nhập sai loại xe!!");
          break;
      }
    }
    System.out.println("--------Danh Sách Phương Tiện--------");
    for (int j = 0; j < n; j++) {
      carList[j].giveBasicInformation();
      System.out.println("--------Thuế áp dụng--------");
      carList[j].giveApplicableTax();
      System.out.println();
      System.out.println("--------Tổng giá lăn bánh--------");
      System.out.printf("Tổng giá lăn bánh %.2f", carList[j].calculatePrice());
    }
    sc.close();
  }
}
