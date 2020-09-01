package comp1110.mse;

public class Q4Bridges {

  /*
   * This question is concerned with a game played on an NxN square grid (for
   * any value of N) where each position is occupied with one of four tiles,
   * each of which has two 'bridges' which serve as exits.
   *
   * One of the two bridges goes in the vertical direction (up or down the
   * board), while the other bridge goes in the horizontal direction (left or
   * right across the board).
   *
   * Bridges are one-directional, allowing movement from the starting tile to
   * some other (but not the reverse direction).
   *
   * Each of the four tile types has a different arrangements of bridges:
   *
   *      vertical          horizontal
   * 'A'  1 square up     2 squares right
   * 'B'  1 square down   2 squares left
   * 'C'  2 squares up    1 square right
   * 'D'  2 squares down  1 square left
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
   * Thus if an 'A' tile was in position 4 in the 4x4 board it could reach
   * position 0 (marked 'v') via its vertical exit and position 6 (marked 'h')
   * via its horizontal exit:
   *
   *  v  1  2  3
   *  A  5  h  7
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
   * Given a board and a starting position, return the length of the longest
   * path from the starting point to edge of the board, following one of the
   * available bridges at each point.  Return 0 if there is no path to the edge.
   *
   * @param board A string composed of M = NxN tiles (a square number), where each
   *              tile is one described above (i.e. the side of the board is
   *              equal to the square root of the length of the string).
   * @param start A position on the NxN board using the numbering scheme above
   * @return the length of the longest path from start to edge of the board,
   * or 0 if there is no path to the edge.
   */
  public static int longest(String board, int start) {
    return -1;
  }
}
