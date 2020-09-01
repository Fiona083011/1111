package comp1110.mse;

public class Q2Vending {
  public String id;     // machine ID
  public int vendRate;  // units/day

  /**
   * Constructor
   *
   * @param id The machine ID
   * @param vendRate The number of drinks sold per day from this machine
   */
  public Q2Vending(String id, int vendRate) {
    // FIXME 2a  complete this constructor
  }

  /** Return the vend rate of this machine */
  public int getVendRate() {
    return 0; // FIXME 2b: complete this method
  }

  /**
   * Set the vend rate of this machine
   * @param vendRate The new vend rate
   */
  public void setVendRate(int vendRate) {
    // FIXME 2c: complete this method
  }

  /**
   * Calculate how many whole days of stock is left in this machine.
   *
   * Given the current number of drinks (stock) and the current rate of
   * daily consumption (vendRate).
   *
   * @param stock The number of units in this machines
   *
   * @return The number of full days remaining before stock becomes zero
   */
  public int wholeDaysLeft(int stock) {
    return 0; // FIXME 2d: complete this method
  }

  /**
   * Return an array of vending machines using the provided ids and vend
   * rates, or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   *
   * @param ids An array of ids
   * @param vendRates An array of vend rates
   * @return an array of vending machines using the provided ids and vend
   * rates, or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   */
  public static Q2Vending[] makeVending(String[] ids, int[] vendRates) {
    return null;  // FIXME 2e: complete this method
  }

  /**
   * Return a string describing the vending machine, its stock and its
   * vend rate in the format
   *    "Machine ID vends VENDRATE drinks per day"
   * where ID is replaced by the machine's id and VENDRATE is replaced by the
   * machines current vend rate.
   *
   * @return A string describing the vending machine
   */
  @Override
  public String toString() {
    return "";  // FIXME 2f: complete this method
  }

}
