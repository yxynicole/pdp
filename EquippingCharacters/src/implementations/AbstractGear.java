package implementations;

import enumarations.Status;
import interfaces.Gear;

abstract class AbstractGear implements Gear {

  private final String gearName;
  private final Status statusType;
  private int statusValue;
  private int timesOfWearingLeft;

  /**
   * Constructs a gear with its type, value and name.
   *
   * @param type  the type of this gear, either for attacking or for defense
   * @param value the value of this gear
   * @param name  the name of this gear
   */
  public AbstractGear(String name, Status type, int value) {
    this.statusType = type;
    this.statusValue = value;
    this.timesOfWearingLeft = value;
    this.gearName = name;
  }

  @Override
  public String getGearName() {
    return this.gearName;
  }

  @Override
  public int getAttack() {
    if (Status.ATTACK == this.statusType) {
      return this.statusValue;
    } else {
      return 0;
    }
  }

  @Override
  public int getDefense() {
    if (Status.DEFENCE == this.statusType) {
      return this.statusValue;
    } else {
      return 0;
    }
  }


  @Override
  public int getTimesOfWearingLeft() {
    return this.timesOfWearingLeft;
  }

  @Override
  public void wornOut() {
    this.timesOfWearingLeft -= 1;
    this.statusValue -= 1;
  }
}
