package firsttaskoop;

public class Bike extends Vehicles {

  private String loaiXe;
  private String chatLieuKhung;

  public Bike(String modelTen, String hangSanXuat, int namSanXuat, double giaGoc, String xuatXu,
      String loaiXe, String chatLieuKhung) {
    super(modelTen, hangSanXuat, namSanXuat, giaGoc, xuatXu, 0.1);
    this.loaiXe = loaiXe;
    this.chatLieuKhung = chatLieuKhung;
  }

  @Override
  public double getThueTTDB() {
    return 0;
  }

  @Override
  public void showThueApDung() {
    System.out.printf("Thuế nhập khẩu: %.2f || Thuế tiêu thụ đặc biệt: %.2f",
        super.getThueNhapKhau(), getThueTTDB());
  }

  @Override
  public void showThongTinCoBan() {
    super.showThongTinCoBan();
    System.out.printf("Loại xe: %s\n", loaiXe);
    System.out.printf("Chất liệu khung: %s\n", chatLieuKhung);
  }
}
