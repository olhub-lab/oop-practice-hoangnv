package firsttaskoop;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Bạn muốn khai báo bao nhiêu loại phương tiện?");

    int n = sc.nextInt();
    sc.nextLine();

    Vehicles[] danhSachXe = new Vehicles[n];
    for (int i = 0; i < n; i++) {
      System.out.println("Nhập thông tin xe thứ " + (i + 1));
      System.out.println("Chọn loại xe:");
      System.out.println("1. Ô tô");
      System.out.println("2. Xe máy");
      System.out.println("3. Xe đạp/Xe đạp điện");

      int choice = sc.nextInt();
      sc.nextLine();

      System.out.print("Tên Model: ");
      String ten = sc.nextLine();
      System.out.print("Hãng sản xuất: ");
      String hang = sc.nextLine();
      System.out.print("Năm sản xuất: ");
      int nam = sc.nextInt();
      sc.nextLine();
      System.out.print("Giá gốc: ");
      double giaGoc = sc.nextDouble();
      sc.nextLine();
      System.out.print("Xuất xứ (Trong nuoc/ Ngoai nuoc): ");
      String xuatXu = sc.nextLine();

      switch (choice) {
        case 1:
          System.out.print("Số chỗ ngồi: ");
          int choNgoi = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại nhiên liệu (xăng/dầu/điện): ");
          String loaiNhienLieu = sc.nextLine();
          System.out.print("Dung tích động cơ: ");
          int dungTich = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại thân xe: ");
          String loaiThanXe = sc.nextLine();
          danhSachXe[i] = new Car(ten, hang, nam, giaGoc, xuatXu, choNgoi, loaiNhienLieu, dungTich,
              loaiThanXe);
          break;
        case 2:
          System.out.print("Dung tích xi-lanh: ");
          int dungTichXiLanh = sc.nextInt();
          sc.nextLine();
          System.out.print("Loại xe (xe số/xe ga): ");
          String loaiXe = sc.nextLine();
          System.out.print("Công suất: ");
          int congSuat = sc.nextInt();
          sc.nextLine();
          danhSachXe[i] = new MotorBike(ten, hang, nam, giaGoc, xuatXu, dungTichXiLanh, congSuat,
              loaiXe);
          break;
        case 3:
          System.out.print("Loại xe (Xe đạp thường/trợ lực điện): ");
          String loaiXeDap = sc.nextLine();
          System.out.print("Chất liệu khung: ");
          String chatLieu = sc.nextLine();
          danhSachXe[i] = new Bike(ten, hang, nam, giaGoc, xuatXu, chatLieu, loaiXeDap);
          break;
        default:
          System.out.println("Nhập sai loại xe!!");
          break;
      }
    }
    System.out.println("--------Danh Sách Phương Tiện--------");
    for (int j = 0; j < n; j++) {
      danhSachXe[j].showThongTinCoBan();
      System.out.println("--------Thuế áp dụng--------");
      danhSachXe[j].showThueApDung();
      System.out.println();
      System.out.println("--------Tổng giá lăn bánh--------");
      System.out.printf("Tổng giá lăn bánh %.2f", danhSachXe[j].tinhGiaLanBanh());
    }
    sc.close();
  }
}
