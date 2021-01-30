package transmission;

/**
 * Transmission contains getter methods and methods that used to adjust speed and gear.
 */
public interface Transmission {
  /**
   * increaseSpeed() returns a Transmission with speed increased by 2 and the appropriate gear.
   *
   * @return a Transmission object with speed increased by 2 and the appropriate gear.
   */
  Transmission increaseSpeed();

  /**
   * DecreaseSpeed() returns a Transmission with speed decreased by 2 and the appropriate gear.
   *
   * @return a Transmission object with speed decreased by 2 and the appropriate gear
   */
  Transmission decreaseSpeed();

  /**
   * getSpeed() returns the value of speed of this calling object.
   *
   * @return the value of speed
   */
  int getSpeed();

  /**
   * getGear returns the value of gear of this calling object.
   *
   * @return the value of gear
   */
  int getGear();

}
