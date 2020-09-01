package comp1110.mse;

public class Q2Bus {
  public int number;  // route number
  public int speed;   // km/h

  /**
   * Constructor
   *
   * @param number The number of the bus route
   * @param speed The speed of the bus (in km/h),
   */
  public Q2Bus(int number, int speed) {
    // FIXME 2a  complete this constructor
  }

  /** Return the speed of the bus */
  public int getSpeed() {
    return 0; // FIXME 2b: complete this method
  }

  /**
   * Set the speed of the bus
   * @param speed The new speed of the bus
   */
  public void setSpeed(int speed) {
    // FIXME 2c: complete this method
  }

  /**
   * Calculate how many minutes it will take to travel the remaining distance,
   * assuming the bus maintains this speed.
   * @param distance The distance (in km)
   * @return The time to travel the distance (in minutes)
   */
  public int minToGo(int distance) {
    return 0; // FIXME 2d: complete this method
  }

  /**
   * Return an array of buses using the provided numbers and speed,
   * or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   *
   * @param numbers An array of route numbers
   * @param speed An array of bus speeds
   * @return an array of buses using the provided numbers and speed,
   * or null if the numbers and speed arrays are different length or if they
   * are null or have no elements.
   */
  public static Q2Bus[] makeBuses(int[] numbers, int[] speed) {
    return null;  // FIXME 2e: complete this method
  }

  /**
   * Return a string describing the bus and its speed, in the format
   *    "Bus NUMBER is travelling at SPEED km/h"
   * where NUMBER is replaced by the bus's route number, and SPEED is replaced
   * by the bus's speed.
   *
   * @return A string describing the bus and its speed
   */
  @Override
  public String toString() {
    return "";  // FIXME 2f: complete this method
  }
}
