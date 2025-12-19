package firsttaskoop;

public class Car extends Vehicles {

  private int soChoNgoi;
  private String loaiNhienLieu;
  private int dungTich;
  private String loaiThanXe;

  public Car(String modelTen, String hangSanXuat, int namSanXuat, double giaGoc, String xuatXu,
      int soChoNgoi, String loaiNhienLieu, int dungTich, String loaiThanXe) {
    super(modelTen, hangSanXuat, namSanXuat, giaGoc, xuatXu, 0.5);
    this.soChoNgoi = soChoNgoi;
    this.loaiNhienLieu = loaiNhienLieu;
    this.dungTich = dungTich;
    this.loaiThanXe = loaiThanXe;
  }

  @Override
  public double getThueTTDB() {
    double giaCoSo = giaGoc + super.getThueNhapKhau();
    if (dungTich < 3000) {
      return giaCoSo * 0.5;
    } else {
      return giaCoSo * 1;
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
    System.out.printf("Số chỗ ngồi: %d\n", soChoNgoi);
    System.out.printf("Loại nhiên liệu: %s\n", loaiNhienLieu);
    System.out.printf("Dung tích động cơ: %d\n", dungTich);
    System.out.printf("Loại thân xe: %s\n", loaiThanXe);
  }
}
