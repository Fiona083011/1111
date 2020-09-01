package comp1110.mse;

public class Q3Jigsaw {
  /*
   * This problem is concerned with the placement of pieces in a simple jigsaw
   * puzzle played on a 5 x 5 board.
   *
   * - Their are five piece types ('0' .. '4')
   * - There are twenty five piece positions ('00' - '24')
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
   * - A digit describing the piece type ('0' - '4').
   * - Two digits forming an integer for the piece location ('00' - '24')
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
   * - Be comprised of up to twenty-five well-formed piece placements
   * - Have no more than five of any piece kind
   * - Have no overlapping pieces.
   *
   * @param puzzle A string of piece placements.
   * @return true if the string is a well-formed puzzle string.
   */
  public static boolean wellFormedPuzzleString(String puzzle) {
    return false; // FIXME Q3b Complete this method
  }

  /**
   * Return the position that is next to a given 'side' of the piece
   * when the piece is in a particular orientation.
   *
   *  0  1  2  3  4
   *  5  6  7  8  9
   * 10 11 12 13 14
   * 15 16 17 18 19
   * 20 21 22 23 24
   *
   * Assume a 5x5 board with positions numbered 0 - 24 as above.
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
   * @param position a position on a 5x5 board
   * @param side the side of the piece being explored
   * @param orientation the orientation of the piece
   * @return the adjacent position in the given direction, or -1 if the
   * adjacent position is off the board.
   */
  public static int getNext(int position, int side, int orientation) {
    return -1; // FIXME Q3c Complete this method
  }
}
