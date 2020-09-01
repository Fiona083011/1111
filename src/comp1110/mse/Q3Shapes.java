package comp1110.mse;

public class Q3Shapes {
  /*
   * This problem is concerned with the placement of pieces in a simple puzzle
   * played on a 4 x 4 board.
   *
   * - Their are five piece types ('A' .. 'D')
   * - There are four columns ('0' - '3')
   * - There are four rows ('0' - '3')
   * - There are four orientations ('N', 'E', 'S', 'W')
   *
   * You are advised to implement the missing code in the order given.
   *
   * Be sure to take into account piece orientation.
   */

  /**
   * Return true if the piece string represents a well-formed piece placement.
   *
   * To be well-formed, the piece must contain exactly four characters:
   * - A letter describing the piece type ('A', 'B', 'C', 'D').
   * - A digit describing the column it is placed in ('0' - '3')
   * - A digit describing the row it is placed in ('0' - '3')
   * - A letter describing its orientation ('N', 'E', 'W', 'S')
   *
   * @param piece A string describing a piece placement.
   * @return true if the string represents a well-formed piece placement.
   */
  public static boolean wellFormedPiecePlacement(String piece) {
    return false; // FIXME Q3a Complete this method
  }

  /**
   * Return true if the puzzle string represents a well-formed puzzle string.
   *
   * To be well-formed, the puzzle string must:
   * - Be comprised of up to sixteen well-formed piece placements
   * - Have no more than four pieces of each kind
   * - Have no overlapping pieces.
   *
   * @param puzzle A string of piece placements.
   * @return true if the string is a well-formed puzzle string.
   */
  public static boolean wellFormedPuzzleString(String puzzle) {
    return false; // FIXME Q3b Complete this method
  }

  /**
   * Return the position that neighbours a given 'side' of the piece
   * when the piece is in a particular orientation.
   *
   *  0  1  2  3
   *  4  5  6  7
   *  8  9 10 11
   * 12 13 14 15
   *
   * Assume a 4x4 board with positions numbered 0 - `15` as above.
   *
   * Assume the sides of a piece are encoded as a value 0 - 3:
   *  0 top
   *  1 right
   *  2 bottom
   *  3 left
   *
   * Assume the piece orientation is encoded as a value 0 - 3:
   *  0 upright
   *  1 rotated 90 degrees clockwise
   *  2 upside down
   *  3 rotated 270 degrees clockwise
   *
   * When a piece is 'upright', the 'top' side will be at the top,
   * but as the piece is rotated, each of the sides will rotate too,
   * so when rotated 90 degrees, the 'top' side will point to the
   * right, and when rotated 180 degrees, the 'top' side will point
   * down, etc.
   *
   * @param position a position on a 4x4 board
   * @param side the side of the piece being explored
   * @param orientation the orientation of the piece
   * @return the adjacent position in the given direction, or -1 if the
   * adjacent position is off the board.
   */
  public static int getNeighbour(int position, int side, int orientation) {
    return -1; // FIXME Q3c Complete this method
  }
}
