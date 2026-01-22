package firsttaskoop.view;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.List;
import firsttaskoop.enums.*;
import firsttaskoop.model.*;

public class DealershipView {

  private Scanner sc = new Scanner(System.in);

  public int showMainMenu() {
    System.out.println("\n===== HỆ THỐNG QUẢN LÝ ĐẠI LÝ =====");
    System.out.println("1. Thêm xe vào kho");
    System.out.println("2. Đăng ký khách hàng");
    System.out.println("3. Thực hiện giao dịch bán xe");
    System.out.println("4. Kiểm tra kho hàng");
    System.out.println("0. Thoát");
    System.out.print("Chọn chức năng: ");
    try {
      return Integer.parseInt(sc.nextLine());
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  public int askInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt + ": ");
        return Integer.parseInt(sc.nextLine());
      } catch (Exception e) {
        System.out.println(">> Lỗi: Vui lòng nhập số nguyên dương hợp lệ!!");
      }
    }
  }

  public BigDecimal askBigDecimal(String prompt) {
    while (true) {
      try {
        System.out.print(prompt + ": ");
        String input = sc.nextLine();
        BigDecimal value = new BigDecimal(input);
        if (value.compareTo(BigDecimal.ZERO) < 0) {
          System.out.println(">> Lỗi: giá trị không được âm!!!");
          continue;
        }
        return value;
      } catch (Exception e) {
        System.out.println(">> Lỗi: Vui lòng nhập số tiền hợp lệ!!");
      }
    }
  }

  public String askNotEmpty(String prompt) {
    while (true) {
      System.out.print(prompt + ": ");
      String input = sc.nextLine();
      if (input.isEmpty()) {
        System.out.println(">> Lỗi: Thông tin này không được để trống!!!");
      } else {
        return input;
      }
    }
  }

  public Origin askOrigin() {
    System.out.println("Chọn nguồn gốc xe:");
    System.out.println("1. Trong nước");
    System.out.println("2. Nước ngoài");
    System.out.print("Lựa chọn (1-2): ");
    try {
      int choice = Integer.parseInt(sc.nextLine());
      return (choice == 1) ? Origin.DOMESTIC : Origin.IMPORTED;
    } catch (Exception e) {
      return Origin.DOMESTIC;
    }
  }

  public void showMessage(String msg) {
    System.out.println(">> " + msg);
  }

  public void listVehicles(List<Vehicle> list) {
    System.out.println("\n--- DANH SÁCH XE TRONG KHO ---");
    if (list.isEmpty()) {
      System.out.println("Kho hàng hiện đang trống.");
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      Vehicle v = list.get(i);
      System.out.printf("%d. %s | Số lượng: %d | Giá lăn bánh: %.2f VNĐ\n",
          i + 1, v.getNameModel(), v.getQuantity(), v.calculatePrice());
    }
  }

  public void showSuggestions(List<Vehicle> suggestions) {
    if (suggestions.isEmpty()) {
      System.out.println(">> Rất tiếc, không có mẫu xe cùng loại nào khác để gợi ý.");
      return;
    }
    System.out.println("\n--- GỢI Ý CÁC MẪU XE CÙNG LOẠI ĐANG CÓ SẴN ---");
    for (Vehicle v : suggestions) {
      System.out.printf("- %s || Giá: %.2f VNĐ || SL: %d\n",
          v.getNameModel(), v.calculatePrice(), v.getQuantity());
    }
  }

  public Dealership selectDealership(List<Dealership> list) {
    if (list.isEmpty()) {
      System.out.println(">> Hiện không có đại lý nào!!!");
      return null;
    }
    System.out.println("\n--- Danh sách đại lý ---");
    for (int i = 0; i < list.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, list.get(i).getName());
    }
    int choice = askInt("Chọn đại lý (Nhập số thứ tự)");
    if (choice > 0 && choice <= list.size()) {
      return list.get(choice - 1);
    }
    return null;
  }

  public Customer selectCustomer(List<Customer> list) {
    if (list.isEmpty()) {
      System.out.println(">> Hiện không có khách hàng nào!!");
      return null;
    }
    System.out.println("\n--- Danh sách khách hàng ---");
    for (int i = 0; i < list.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, list.get(i).getName());
    }

    int choiceCustomer = askInt("Chọn khách hàng (Nhập số thứ tự)");
    if (choiceCustomer > 0 && choiceCustomer <= list.size()) {
      return list.get(choiceCustomer - 1);
    }
    return null;
  }
}