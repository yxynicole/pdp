import org.junit.Test;

import transmission.AutomaticTransmission;


public class AutomaticTransmissionTest {

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThreshold1LessThanZero() {
    AutomaticTransmission at = new AutomaticTransmission(-1, 10, 15, 20, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThrehold1EqualsZero() {
    AutomaticTransmission at = new AutomaticTransmission(0, 10, 15, 20, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThreshold2LessThanThreshold1() {
    AutomaticTransmission at = new AutomaticTransmission(5, 0, 15, 20, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThreshold3LessThanThreshold2() {
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 5, 20, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThreshold4LessThanThreshold3() {
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 15, 10, 25);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorThrowsIllegalArgumentExceptionIfThreshold5LessThanThreshold4() {
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 15, 20, 15);
  }
}