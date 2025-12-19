package firsttaskoop;

public class MotorBike extends Vehicles {

  private int dungTich;
  private String loaiXe;
  private int congSuat;

  public MotorBike(String modelTen, String hangSanXuat, int namSanXuat, double giaGoc,
      String xuatXu, int dungTich, int congSuat, String loaiXe) {
    super(modelTen, hangSanXuat, namSanXuat, giaGoc, xuatXu, 0.3);
    this.dungTich = dungTich;
    this.loaiXe = loaiXe;
    this.congSuat = congSuat;
  }

  @Override
  public double getThueTTDB() {
    double giaCoSo = giaGoc + super.getThueNhapKhau();
    if (dungTich < 150) {
      return 0;
    } else {
      return giaCoSo * 0.2;
    }
  }

  @Override
  public void showThueApDung() {
    System.out.printf("Thuế nhập khẩu: %.2f || Thuế tiêu thụ đặc biệt: %.2f",
        super.getThueNhapKhau(), getThueTTDB());
  }

  @Override
  public void showThongTinCoBan() {
    super.showThongTinCoBan();
    System.out.printf("Dung tích xi-lanh: %d", dungTich);
    System.out.printf("Loại xe: %s\n", loaiXe);
    System.out.printf("Công suất: %d\n", congSuat);
  }
}
