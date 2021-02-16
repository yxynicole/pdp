package implementations;

import interfaces.Gear;
import interfaces.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * This playerImpl class represents a player in the game.
 */
public class PlayerImpl implements Player {
  final int basicAttack;
  final int basicDefense;

  int hitPoints;
  List<Gear> gearList;

  int countHandGear;
  int countFootGear;
  int countHeadGear;

  public PlayerImpl() {
    this.hitPoints = 200;
    this.basicAttack = 20; //the initial attack power of this player
    this.basicDefense = 10; //the initial attack power of this player
    this.countHandGear = 0;
    this.countFootGear = 0;
    this.countHeadGear = 0;
    this.gearList = new ArrayList<>();
  }

  @Override
  public boolean picksUpGear(Gear gear) {
    if (gear.isPickedUpBy(this)) {
      this.gearList.add(gear);
      return true;
    } else {
      return false;
    }
  }

  public boolean picksUpHeadGear() {
    if (this.countHeadGear >= this.maxHeadGear) {
      return false;
    } else {
      this.countHeadGear++;
      return true;
    }
  }

  public boolean picksUpHandGear() {
    if (this.countHandGear >= this.maxHandGear) {
      return false;
    } else {
      this.countHandGear++;
      return true;
    }
  }

  public boolean picksUpFootGear() {
    if (this.countFootGear >= this.maxFootGear) {
      return false;
    } else {
      this.countFootGear++;
      return true;
    }
  }

  @Override
  public void attacks(Player defender) {
    int damageToDefender = this.getTotalAttack() - defender.getTotalDefense();
    defender.isAttacked(damageToDefender);
    for (Gear gear : gearList) {
      if (gear.getAttack() > 0) {
        gear.wornOut();
      }
    }
  }

  @Override
  public void isAttacked(int damage) {
    if (this.hitPoints < damage) {
      // make sure player will not have negative hit points
      damage = this.hitPoints;
    }
    this.hitPoints -= damage;

    for (Gear gear : gearList) {
      if (gear.getDefense() > 0) {
        gear.wornOut();
      }
    }
  }

  @Override
  public int getHitPoints() {
    return this.hitPoints;
  }

  @Override
  public int getTotalAttack() {
    int totalAttack = this.basicAttack;
    for (Gear gear : gearList) {
      totalAttack += gear.getAttack();
    }
    return totalAttack;
  }

  @Override
  public int getTotalDefense() {
    int totalDefense = this.basicDefense;
    for (Gear gear : gearList) {
      totalDefense += gear.getDefense();
    }
    return totalDefense;
  }

  @Override
  public String describeGears() {
    List<String> headList = new ArrayList<>();
    List<String> handList = new ArrayList<>();
    List<String> footList = new ArrayList<>();
    List<String> jewelryList = new ArrayList<>();

    for (Gear gear : gearList) {
      String name = gear.getGearName();
      if (gear instanceof HeadGear) {
        headList.add(name);
      } else if (gear instanceof HandGear) {
        handList.add(name);
      } else if (gear instanceof FootGear) {
        footList.add(name);
      } else if (gear instanceof Jewelry) {
        jewelryList.add(name);
      }
    }

    String headNamesCombined = concatNames((String[]) headList.toArray());
    String handNamesCombined = concatNames((String[]) handList.toArray());
    String footNamesCombined = concatNames((String[]) footList.toArray());
    String jewelryNamesCombined = concatNames((String[]) jewelryList.toArray());

    return concatNames(new String[]{
            headNamesCombined,
            handNamesCombined,
            footNamesCombined,
            jewelryNamesCombined
    });
  }

  private String concatNames(String[] names) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < names.length; i++) {
      if (i == 0) {
        sb.append(names[i]);
      } else if (i == names.length - 1) {
        sb.append(", and ");
        sb.append(names[i]);
      } else {
        sb.append(", ");
        sb.append(names[i]);
      }
    }
    return sb.toString();
  }

}
