package transmission;

/**
 * gear 0-5
 */
public class AutomaticTransmission implements Transmission {
  private final int speed;
  private final int gear;
  private final int threshold1;
  private final int threshold2;
  private final int threshold3;
  private final int threshold4;
  private final int threshold5;

  /**
   * Constructs a AutomaticTransmission
   * @param t1
   * @param t2
   * @param t3
   * @param t4
   * @param t5
   */
  public AutomaticTransmission(int t1, int t2, int t3, int t4, int t5) {
    if (t1 <= 0 || t2 <= t1 || t3 <= t2 || t4 <= t3 || t5 <= t4) {
      throw new IllegalArgumentException();
    }
    this.threshold1 = t1;
    this.threshold2 = t2;
    this.threshold3 = t3;
    this.threshold4 = t4;
    this.threshold5 = t5;

    this.speed = 0;
    this.gear = 0;
  }

  private AutomaticTransmission(int speed, int gear, AutomaticTransmission transmission) {
    this.threshold1 = transmission.threshold1;
    this.threshold2 = transmission.threshold2;
    this.threshold3 = transmission.threshold3;
    this.threshold4 = transmission.threshold4;
    this.threshold5 = transmission.threshold5;

    this.speed = speed;
    this.gear = gear;
  }

  public int getSpeed() {
    return this.speed;
  }

  public int getGear() {
    return this.gear;
  }

  private int determineGear(int speed) {
    if (speed < 0) {
      throw new IllegalStateException();
    } else if (speed == 0) {
      return 0;
    } else if (speed <= threshold1) {
      return 1;
    } else if (speed <= threshold2) {
      return 2;
    } else if (speed <= threshold3) {
      return 3;
    } else if (speed <= threshold4) {
      return 4;
    } else if (speed <= threshold5) {
      return 5;
    } else {
      return 6;
    }
  }

  public Transmission increaseSpeed() {
    int newSpeed = this.speed + 2;
    int newGear = this.determineGear(newSpeed);
    return new AutomaticTransmission(newSpeed, newGear, this);
  }

  public Transmission decreaseSpeed() {
    int newSpeed = this.speed - 2;
    int newGear = this.determineGear(newSpeed);
    return new AutomaticTransmission(newSpeed, newGear, this);
  }

  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);
  }
}
