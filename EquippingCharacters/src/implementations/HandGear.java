package implementations;

import enumarations.Status;
import interfaces.Player;

public class HandGear extends AbstractGear {

  public HandGear(String name, Status statusType, int value) {
    super(name, statusType, value);
  }

  @Override
  public boolean isPickedUpBy(Player p) {
    return p.picksUpHandGear();
  }
}
