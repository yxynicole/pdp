package transmission;

/**
 * Automatic transmission has five thresholds corresponding to six gears that varies from 0 to 5.
 * The current speed of the Automatic Transmission determines which gear it should use.
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
   * AutomaticTransmission() constructs an AutomaticTransmission instance in terms of five ranked
   * thresholds (from smallest to largest), speed, and gear.
   *
   * @param t1 threshold1
   * @param t2 threshold2
   * @param t3 threshold3
   * @param t4 threshold4
   * @param t5 threshold5
   * @throws IllegalArgumentException if any argument is negative or equals to zero
   * @throws IllegalArgumentException if an argument is less than the argument ahead of it
   */
  public AutomaticTransmission(int t1, int t2, int t3, int t4, int t5) {
    if (t1 <= 0 || t2 < 0 || t3 < 0 || t4 < 0 || t5 < 0) {
      throw new IllegalArgumentException();
    }
    if (t2 <= t1 || t3 <= t2 || t4 <= t3 || t5 <= t4) {
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

  /**
   * AutomaticTransmission constructor constructs a new automatic transmission based on the updated
   * speed and gear.
   *
   * @param updatedSpeed    a speed either increased by 2 or decreased by 2
   * @param updatedGear     a gear matched with updated speed
   * @param oldTransmission an automatic transmission carrying five thresholds, current speed, and
   *                        gear
   */

  private AutomaticTransmission(int updatedSpeed, int updatedGear,
                                AutomaticTransmission oldTransmission) {
    this.threshold1 = oldTransmission.threshold1;
    this.threshold2 = oldTransmission.threshold2;
    this.threshold3 = oldTransmission.threshold3;
    this.threshold4 = oldTransmission.threshold4;
    this.threshold5 = oldTransmission.threshold5;

    this.speed = updatedSpeed;
    this.gear = updatedGear;
  }

  /**
   * getSpeed() returns the speed of this automaticTransmission.
   *
   * @return the speed of this automaticTransmission
   */

  public int getSpeed() {
    return this.speed;
  }

  /**
   * getGear() returns the gear of this automaticTransmission.
   *
   * @return the gear of this automaticTransmission
   */

  public int getGear() {
    return this.gear;
  }

  /**
   * determineGear() determines the gear of the automatic transmission by comparing the current
   * speed with thresholds.
   *
   * @param speed the current speed of the automatic transmission
   * @return the appropriate gear
   */

  private int determineGear(int speed) {
    if (speed < 0) {
      throw new IllegalStateException();
    } else if (speed == 0) {
      return 0;
    } else if (speed < threshold1) {
      return 1;
    } else if (speed < threshold2) {
      return 2;
    } else if (speed < threshold3) {
      return 3;
    } else if (speed < threshold4) {
      return 4;
    } else if (speed < threshold5) {
      return 5;
    } else {
      return 6;
    }
  }

  /**
   * IncreaseSpeed() returns an automatic transmission whose speed and gear has been updated.
   *
   * @return an automatic transmission with speed increased by 2 and the appropriate gear.
   */

  public Transmission increaseSpeed() {
    int updatedSpeed = this.speed + 2;
    int updatedGear = this.determineGear(updatedSpeed);
    return new AutomaticTransmission(updatedSpeed, updatedGear, this);
  }

  /**
   * DecreaseSpeed() returns an automatic transmission whose speed and gear has been updated.
   *
   * @return an automatic transmission with speed decreased by 2 and the appropriate gear.
   */

  public Transmission decreaseSpeed() {
    int newSpeed = this.speed - 2;
    int newGear = this.determineGear(newSpeed);
    return new AutomaticTransmission(newSpeed, newGear, this);
  }

  /**
   * toString() returns a String representation of the speed and gear of this transmission.
   *
   * @return a String representation of this transmission
   */
  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);
  }
}
