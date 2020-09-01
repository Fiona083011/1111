package comp1110.mse;

public class Q2Fruit {
  public String name;  // fruit name
  public int price;    // price in cents/100g

  /**
   * Constructor
   *
   * @param name The fruit name
   * @param price Theprice in cents/100g
   */
  public Q2Fruit(String name, int price) {
    // FIXME 2a  complete this constructor
  }

  /** Return the fruit's price */
  public int getPrice() {
    return 0; // FIXME 2b: complete this method
  }

  /**
   * Set the fruit's price
   * @param price The price of the fruit in cents/100g
   */
  public void setPrice(int price) {
    // FIXME 2c: complete this method
  }

  /**
   * Calculate cost of the given amount of the fruit
   * @param grams The amount of fruit in grams
   * @return The cost of the fruit, in cents
   */
  public int cost(int grams) {
    return 0; // FIXME 2d: complete this method
  }

  /**
   * Return an array of fruit using the provided names and costs,
   * or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   *
   * @param names An array of names
   * @param costs An array of costs
   * @return an array of fruit using the provided names and costs,
   * or null if the numbers and speed arrays are different length or if they
   * are null or have no elements.
   */
  public static Q2Fruit[] makeFruit(String[] names, int[] costs) {
    return null;  // FIXME 2e: complete this method
  }

  /**
   * Return a string describing the fruit, in the format
   *    "Fruit NAME costs COST cents per 100g"
   * where NAME is replaced by the fruit name, and COST is replaced by
   * the fruit cost
   *
   * @return A string describing the fruit
   */
  @Override
  public String toString() {
    return "";  // FIXME 2f: complete this method
  }
}
