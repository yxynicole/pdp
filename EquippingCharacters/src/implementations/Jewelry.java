package implementations;

import enumarations.Status;
import interfaces.Player;

public class Jewelry extends AbstractGear {
  public Jewelry(String name, Status statusType, int value) {
    super(name, statusType, value);
  }

  @Override
  public boolean isPickedUpBy(Player p) {
    return true;
  }
}
