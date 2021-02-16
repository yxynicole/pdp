package implementations;

import enumarations.Status;
import interfaces.Player;

public class HeadGear extends AbstractGear {
  public HeadGear(String name, int defenseValue) {
    super(name, Status.DEFENCE, defenseValue);
  }

  @Override
  public boolean isPickedUpBy(Player p) {
    return p.picksUpHeadGear();
  }
}
