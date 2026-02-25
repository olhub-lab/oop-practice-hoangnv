package firsttaskoop.model;

import firsttaskoop.enums.Origin;
import java.math.BigDecimal;

public class Car extends Vehicle {

  private int seatNumber;
  private String fuelType;
  private int capacity;
  private String bodyType;

  public Car(String name, String manu, int year, BigDecimal price, Origin origin, int seats,
      String fuel, int cap, String body, int qty) {
    super(name, manu, year, price, origin, new BigDecimal("0.5"), qty);
    this.seatNumber = seats;
    this.fuelType = fuel;
    this.capacity = cap;
    this.bodyType = body;
  }

  public int getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(int seatNumber) {
    this.seatNumber = seatNumber;
  }

  public String getFuelType() {
    return fuelType;
  }

  public void setFuelType(String fuelType) {
    this.fuelType = fuelType;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public String getBodyType() {
    return bodyType;
  }

  public void setBodyType(String bodyType) {
    this.bodyType = bodyType;
  }

  @Override
  public BigDecimal getExciseTax() {
    BigDecimal base = originalPrice.add(getImportTax());
    return capacity < 3000 ? base.multiply(new BigDecimal("0.5")) : base.multiply(BigDecimal.ONE);
  }
}