import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import transmission.AutomaticTransmission;
import transmission.Transmission;


public class AutomaticTransmissionTest {
  private Transmission increaseSpeed (Transmission transmission, int times ){
    for (int i = 0; i < times; i++){
      transmission = transmission.increaseSpeed();
    }
    return transmission;
  }

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

  @Test
  public void testGetSpeed(){
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 15, 20, 25);
    assertEquals(0, at.getSpeed());
  }

  @Test
  public void testGetGear(){
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 15, 20, 25);
    assertEquals(0, at.getGear());
  }

  @Test
  public void testIncreaseSpeedReturnsGearOne(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,1);
    assertEquals(2, transmission.getSpeed());
    assertEquals(1, transmission.getGear());
  }

  @Test
  public void testIncreaseSpeedReturnsGearTwo(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,3);

    assertEquals(6, transmission.getSpeed());
    assertEquals(2, transmission.getGear());
  }

  @Test
  public void testIncreaseSpeedReturnsGearThree(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,6);

    assertEquals(12, transmission.getSpeed());
    assertEquals(3, transmission.getGear());

  }

  @Test
  public void testIncreaseSpeedReturnsGearFour(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,8);

    assertEquals(16, transmission.getSpeed());
    assertEquals(4, transmission.getGear());

  }

  @Test
  public void testIncreaseSpeedReturnsGearFive(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,11);

    assertEquals(22, transmission.getSpeed());
    assertEquals(5, transmission.getGear());

  }

  @Test
  public void testIncreaseSpeedReturnsGearSix(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,13);

    assertEquals(26, transmission.getSpeed());
    assertEquals(6, transmission.getGear());

  }

  @Test(expected =IllegalStateException.class)
  public void testDecreaseSpeedThrowsIllegalStateExceptionIfspeedLessThanZero(){
    AutomaticTransmission at = new AutomaticTransmission(5, 10, 15, 20, 25);
    Transmission transmission = at.decreaseSpeed();
  }

  @Test
  public void testDecreaseSpeedReturnsGearFive(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,13);
    transmission = transmission.decreaseSpeed();

    assertEquals(24, transmission.getSpeed());
    assertEquals(5, transmission.getGear());
  }

  @Test
  public void testToString(){
    Transmission transmission = new AutomaticTransmission(5, 10, 15, 20, 25);
    transmission = this.increaseSpeed(transmission,13);
    transmission = transmission.decreaseSpeed();

    assertTrue("Transmission (speed = 24, gear = 5)".equals(transmission.toString()));
  }
}