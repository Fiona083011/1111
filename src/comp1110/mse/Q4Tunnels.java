package comp1110.mse;

public class Q4Tunnels {

  /*
   * This question is concerned with a game played on an NxN square grid (for
   * any value of N) where each position is occupied with one of four tiles,
   * each of which has two 'tunnels' which serve as exits.
   *
   * One of the two tunnels goes in the vertical direction (up or down the
   * board), while the other bridge goes in the horizontal direction (left or
   * right across the board).
   *
   * Tunnels are one-directional, allowing movement from the starting tile to
   * some other (but not the reverse direction).
   *
   * Each of the four tile types has a different arrangements of bridges:
   *
   *      vertical          horizontal
   * 'W'  1 square up     1 square left
   * 'X'  2 squares down  3 squares right
   * 'Y'  3 squares down  3 squares left
   * 'Z'  2 squares up    1 square right
   *
   * 3x3
   *  0  1  2
   *  3  4  5
   *  6  7  8
   *
   * 4x4
   *  0  1  2  3
   *  4  5  6  7
   *  8  9 10 11
   * 12 13 14 15
   *
   * Thus if an 'W' tile was in position 5 in the 4x4 board it could reach
   * position 1 (marked 'v') via its vertical exit and position 4 (marked 'h')
   * via its horizontal exit:
   *
   *  1  v  2  3
   *  h  W  6  7
   *  8  9 10 11
   * 12 13 14 15
   *
   */

  /**
   * Given a board, a starting position and a boolean stating whether
   * the movement is vertical or horizontal, return the position directly
   * reached by the specified starting point and exit choice, or -1 if the
   * result is off the board.
   *
   * @param board A string composed of M = NxN tiles (a square number), where each
   *              tile is one described above (i.e. the side of the board is
   *              equal to the square root of the length of the string).
   * @param from A position on the NxN board using the numbering scheme above
   * @param vertical If true, then use the tile's vertical exit, otherwise
   *                 use its horizontal exit.
   * @return the position directly reached by the specified starting point and
   * exit choice, or -1 if the result is off the board.
   */
  public static int directlyReaches(String board, int from, boolean vertical) {
    return -1; // FIXME Q4a
  }


  /**
   * Given a board and a starting position, return the length of the shortest
   * path from the starting point to the end point of the board, following one
   * of the available tunnels at each point.  Return 0 if there is no path to
   * the end point or the start and end are equal.
   *
   * @param board A string composed of M = NxN tiles (a square number), where each
   *              tile is one described above (i.e. the side of the board is
   *              equal to the square root of the length of the string).
   * @param start A position on the NxN board using the numbering scheme above
   * @return the length of the shortest path from the starting point to the end
   * point of the board, following one of the available tunnels at each point.
   * Return 0 if there is no path to the end point or the start and end
   * are equal.
   */
  public static int shortest(String board, int start, int end) {
     return -1;
  }
}
