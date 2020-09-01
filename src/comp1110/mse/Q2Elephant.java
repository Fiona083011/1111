package comp1110.mse;

public class Q2Elephant {
  public String name;  // elephant's name
  public int age;      // elephant's age

  /**
   * Constructor
   *
   * @param name The elephant's name
   * @param age The elephant's age
   */
  public Q2Elephant(String name, int age) {
    // FIXME 2a  complete this constructor
  }

  /** Return the elephant's age */
  public int getAge() {
    return 0; // FIXME 2b: complete this method
  }

  /**
   * Set the elephant's age
   * @param age The elephant's age
   */
  public void setAge(int age) {
    // FIXME 2c: complete this method
  }

  /**
   * Calculate how many years the elephant is likely to live
   * @param lifeExpectency The life expectancy of this elephant (in years)
   * @return The remaining number of years the elephant is likely to live
   */
  public int remainingYears(int lifeExpectency) {
    return 0; // FIXME 2d: complete this method
  }

  /**
   * Return an array of elephants using the provided names and ages,
   * or null if the length of the provided arrays do not match
   * or if they are null or have no elements.
   *
   * @param names An array of names
   * @param ages An array of ages
   * @return an array of elephants using the provided names and ages,
   * or null if the length of the provided arrays are different length or if they
   * are null or have no elements.
   */
  public static Q2Elephant[] makeElephants(String[] names, int[] ages) {
    return null;  // FIXME 2e: complete this method
  }

  /**
   * Return a string describing the elephant in the format
   *    "Elephant NAME is AGE years old"
   * where NAME is replaced by the elephant's name, and AGE is replaced by
   * the elephant's age.
   *
   * @return A string describing the elephant
   */
  @Override
  public String toString() {
    return "";  // FIXME 2f: complete this method
  }
}
