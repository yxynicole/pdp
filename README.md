## Weather

1. should write `final` to all fields 
2. local variable name should be descriptive and shouldn't use abbreviation 
3. test name is not clear enough. E.g. testGetTemperature not testTemperature
4. Within the `getHeatIndex`method, coefficients should be declared as local constant to the method where the calculation is done
5. the implementation of `toString` should use the more efficient `String.format` mothod or `StringBuffer` class
```java
@Override public String toString() {
    return String.format("Temperature in Celsius: %s", temperatureInCelsius);
  }
```

```java
@Override public String toString() {
    return String
        .format("Reading: T = %s, D = %s, v = %s, rain = %s", temperature, dewPoint, windSpeed,
            totalRain);
  }
```
