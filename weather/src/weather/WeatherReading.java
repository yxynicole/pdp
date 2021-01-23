package weather;

/**
 * This class represents a single reading of a weather station in a Stevenson Station. A reading
 * has
 */
public class WeatherReading {
  private int temp;
  private int dewPoint;
  private int windSpeed;
  private int rainReceived;

  /**
   * Construct a WeatherReading object that has the provided air temperature, the dew point
   * temperature, the non-negative wind speed, and the non-negative total rain received. The dew
   * point temperature cannot be greater than the air temperature. 1
   *
   * @param temp         the air temperature to be given to this weatherReading
   * @param dewPoint     the dew point temperature to be given to this weatherReading
   * @param windSpeed    the wind speed to be given to this weatherReading
   * @param rainReceived the rain received to be given to this weatherReading
   */
  public WeatherReading(int temp, int dewPoint, int windSpeed, int rainReceived) {
    this.temp = temp;
    if (dewPoint > temp || windSpeed < 0 || rainReceived < 0) {
      throw new IllegalArgumentException();
    }
    this.dewPoint = dewPoint;
    this.windSpeed = windSpeed;
    this.rainReceived = rainReceived;
  }

  /**
   * Return the temperature of this weatherReading in Celsius.
   *
   * @return the temperature of this weatherReading
   */

  public int getTemperature() {
    return this.temp;
  }

  /**
   * Return the dew point temperature of this weatherReading in Celsius.
   *
   * @return the dew point temperature of this weatherReading
   */

  public int getDewPoint() {
    return this.dewPoint;
  }

  /**
   * Return the non-negative wind speed of this weatherReading in miles per hour.
   *
   * @return the wind speed of this weatherReading
   */

  public int getWindSpeed() {
    return this.windSpeed;
  }

  /**
   * Return the non-negative total rain received of this weatherReading in the last 24 hours in
   * millimeters.
   *
   * @return the rain received of this weatherReading
   */

  public int getTotalRain() {
    return this.rainReceived;
  }

  /**
   * Return the relative humidity in percentage between 0 and 100 of this weatherReading.
   *
   * @return the relative humidity of this weatherReading
   */
  public int getRelativeHumidity() {
    return 100 - (this.getTemperature() - this.getDewPoint()) * 5;
  }

  /**
   * Return the heat index of this weatherReading.
   *
   * @return the heat index of this weatherReading
   */

  public int getHeatIndex() {
    double c1 = -8.78469475556;
    double c2 = 1.61139411;
    double c3 = 2.33854883889;
    double c4 = -0.14611605;
    double c5 = -0.012308094;
    double c6 = -0.0164248277778;
    double c7 = 0.002211732;
    double c8 = 0.00072546;
    double c9 = -0.000003582;

    double r = this.getRelativeHumidity();
    double t = this.getTemperature();
    return (int) (c1 + c2 * t + c3 * r + c4 * t * r +
            c5 * t * t + c6 * r * r + c7 * t * t * r
            + c8 * t * r * r + c9 * t * t * r * r);
  }

  /**
   * Return the wind chill of this weatherReading.
   *
   * @return
   */
  public int getWindChill() {
    int t = this.getTemperature();
    t = (t * 9 / 5) + 32;               //convert the temperature in Celsius to Fahrenheit
    int v = this.getWindSpeed();

    return (int) (35.74 + 0.6215 * t - 35.75 * Math.pow(v, 0.16) + 0.4275 * t * Math.pow(v, 0.16));
  }

  /**
   * Return a customized string by overriding toString method.
   *
   * @return a customized string
   */
  public String toString() {
    return "Reading: T = " + this.getTemperature() + ", D = " + this.getDewPoint() + ", v = "
            + this.getWindSpeed() + ", rain = " + this.getTotalRain();

  }

}
