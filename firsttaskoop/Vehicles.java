package firsttaskoop;

public abstract class Vehicles {

  protected String modelTen;
  protected String hangSanXuat;
  protected int namSanXuat;
  protected double giaGoc;
  protected String xuatXu;

  protected double thueNhapKhau;

  public Vehicles(String modelTen, String hangSanXuat, int namSanXuat, double giaGoc, String xuatXu,
      double thueNhapKhau) {
    this.modelTen = modelTen;
    this.hangSanXuat = hangSanXuat;
    this.namSanXuat = namSanXuat;
    this.giaGoc = giaGoc;
    this.xuatXu = xuatXu;
    this.thueNhapKhau = thueNhapKhau;
  }

  public double getThueNhapKhau() {
    if (xuatXu.equals("Trong nuoc")) {
      return 0;
    } else {
      return giaGoc * thueNhapKhau;
    }
  }

  public abstract double getThueTTDB();

  public double tinhGiaLanBanh() {
    double thueNhapKhau = getThueNhapKhau();
    double thueTTDB = getThueTTDB();
    double thueVAT = 0.1 * (giaGoc + thueNhapKhau + thueTTDB);
    return giaGoc + thueVAT + thueTTDB + thueNhapKhau;
  }

  public void showThongTinCoBan() {
    System.out.printf("Tên: %s\n", modelTen);
    System.out.printf("Hãng %s\n", hangSanXuat);
    System.out.printf("Năm sản xuất %d\n", namSanXuat);
    System.out.printf("Xuất xứ: %s\n", xuatXu);
  }

  abstract void showThueApDung();
}