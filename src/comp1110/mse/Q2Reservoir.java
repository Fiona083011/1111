package comp1110.mse;

public class Q2Reservoir {
  public String name;      // reservoir name
  public int consumption;  // ML/day

  /**
   * Constructor
   *
   * @param name The reservoir name
   * @param consumption The daily consumption of water from this reservoir (ML/day)
   */
  public Q2Reservoir(String name, int consumption) {
    // FIXME 2a  complete this constructor
  }

  /** Return the consumption rate for this reservoir in ML/day */
  public int getConsumption() {
    return 0; // FIXME 2b: complete this method
  }

  /**
   * Set the consumption rate for this reservoir in ML/day
   * @param consumption The new consumption rate
   */
  public void setConsumption(int consumption) {
    // FIXME 2c: complete this method
  }

  /**
   * Calculate how many whole days of water is left in this reservoir.
   *
   * Given the current capacity (ML) and the average daily consumption (consumption).
   *
   * @return The number of full days remaining before water runs out (assuming
   * no new water comes in).
   */
  public int wholeDaysLeft(int capacity) {
    return 0; // FIXME 2f: complete this method
  }

  /**
   * Return an array of reservoirs using the provided names, and consumptions,
   * or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   *
   * @param names An array of names
   * @param consumptions An array of consumptions
   * @return an array of reservoirs using the provided names, and consumptions,
   * or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   */
  public static Q2Reservoir[] makeReservoirs(String[] names, int[] consumptions) {
    return null;  // FIXME 2g: complete this method
  }

  /**
   * Return a string describing the reservoir, its consumption and its level
   * in the format:
   *    "Reservoir NAME uses CONSUMPTION ML per day"
   * where NAME is replaced by the reservoir's name, and CONSUMPTION is replaced
   * by the reservoir's consumption.
   *
   * @return A string describing the reservoir
   */
  @Override
  public String toString() {
    return "";  // FIXME 2h: complete this method
  }
  
}
