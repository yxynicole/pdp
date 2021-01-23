import static org.junit.Assert.assertEquals;

import org.junit.Test;

import weather.WeatherReading;

/**
 * A Junit test class for the WeatherReading class.
 */
public class WeatherReadingTest {
  private WeatherReading weatherReading;

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorDewPointLessThanTemperature() {
    weatherReading = new WeatherReading(5, 10, 10, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorWindSpeedIsNegative() {
    weatherReading = new WeatherReading(10, 5, -1, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorRainReceivedIsNegative() {
    weatherReading = new WeatherReading(10, 5, 10, -1);
  }

  @Test
  public void testTemperature() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(23, weatherReading.getTemperature(), 0);
  }

  @Test
  public void testDewPoint() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(12, weatherReading.getDewPoint(), 0);
  }

  @Test
  public void testWindSpeed() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(3, weatherReading.getWindSpeed(), 0);
  }

  @Test
  public void testTotalRain() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(12, weatherReading.getTotalRain(), 0);
  }

  @Test
  public void testRelativeHumidity() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(45, weatherReading.getRelativeHumidity(), 0);

  }

  @Test
  public void testHeatIndex() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(25, weatherReading.getHeatIndex(), 0);
  }

  @Test
  public void testWindChill() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals(75, weatherReading.getWindChill(), 0);
  }

  @Test
  public void testToString() {
    weatherReading = new WeatherReading(23, 12, 3, 12);
    assertEquals("Reading: T = 23, D = 12, v = 3, rain = 12", weatherReading.toString());
  }
}