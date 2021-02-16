package interfaces;

import enumarations.Status;

/**
 * This player interface includes all the behaviors that a player can perform during the game.
 */
public interface Player {

  static final int maxHeadGear = 1;
  static final int maxFootGear = 2;
  static final int maxHandGear = 10;

  /**
   * Confirms whether this player successfully equips a gear.
   *
   * @param gear the gear picked up by a player
   * @return true if the gear has been equipped successfully otherwise return false
   */
  boolean picksUpGear(Gear gear);

  boolean picksUpHeadGear();

  boolean picksUpHandGear();

  boolean picksUpFootGear();

  /**
   * Decreases a player's hit points by attacking the player.
   *
   * @param p the player is attacked by this player
   */
  void attacks(Player p);

  /**
   * Decreases this player's hit points by damage.
   *
   * @param damage the value of damage to be decreased
   */
  void isAttacked(int damage);


  /**
   * Returns the hit points of this player.
   *
   * @return the hit points
   */
  int getHitPoints();

  /**
   * Returns this player's temporary attack power.
   *
   * @return temporary attack power of this player
   */
  int getTotalAttack();

  /**
   * Returns this player's temporary defensive strength.
   *
   * @return temporary defensive strength of this player
   */
  int getTotalDefense();


  /**
   * Describes what this player is wearing.
   *
   * @return the information about what this player is wearing
   */
  String describeGears();

}
