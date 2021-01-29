package transmission;

/**
 * Transmission
 */
public interface Transmission {
  /**
   *
   * @return a Transmission object with speed increased by 2 and the appropriate gear.
   */
  Transmission increaseSpeed();

  /**
   *
   * @return a Transmission object with speed decreased by 2 and the appropriate gear
   */
  Transmission decreaseSpeed();

}
