package interfaces;

/**
 * This gear interface includes general behaviors for a gear object.
 */
public interface Gear {

  String getGearName();

  int getDefense();

  int getAttack();

  /**
   * @param p
   * @return
   */
  boolean isPickedUpBy(Player p);

  /**
   * Returns a records indicating how many times this gear has been worn.
   *
   * @return the times that this gear has been worn.
   */
  int getTimesOfWearingLeft();

  /**
   * Reduce the timesOfWearing of this gear.
   */
  void wornOut();


}
