package implementations;

import enumarations.Status;
import interfaces.Player;

public class FootGear extends AbstractGear {

  public FootGear(String name, int attackValue) {
    super(name, Status.ATTACK, attackValue);
  }

  @Override
  public boolean isPickedUpBy(Player p) {
    return p.picksUpFootGear();
  }
}
