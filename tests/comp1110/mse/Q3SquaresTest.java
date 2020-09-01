package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Q3SquaresTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);


    private void pieceTest(String in, boolean expected) {
        boolean out = Q3Squares.wellFormedPiecePlacement(in);
        assertEquals("Expected " + expected + " but got " + out + " for piece placement '" + in + "'", expected, out);
    }

    private void stringTest(String in, boolean expected) {
        boolean out = Q3Squares.wellFormedBoardString(in);
        assertEquals("Expected " + expected + " but got " + out + " for board string '" + in + "'", expected, out);
    }

    private void adjacentTest(int p, int s, int o, int expected) {
        int out = Q3Squares.getAdjacent(p, s, o);
        assertEquals("Expected "+expected+" but got "+ out+" for getNext("+p+", "+s+", "+o+")", expected, out);
    }

    static String[] p = { "R", "G", "B"};
    static String[] pos;
    {
        pos = new String[25];
        for (int i = 0; i < 25; i++) {
            pos[i] = String.format("%d", i%5)+String.format("%d", i/5);
        }
    }
    static String[] o = { "N", "S", "E", "W"};


    @Test
    public void testSimplePP() {
        pieceTest(null, false);
        pieceTest("", false);
        pieceTest("XXXX", false);

        pieceTest("R11N", true);
        pieceTest("G00S", true);
        pieceTest("B13E", true);
        pieceTest("R33W", true);

        pieceTest("504N", false);
        pieceTest("R113", false);
    }

    private String genPP(boolean good) {
        String s = "";
        Random r = new Random();
        if (good) {
            s += p[r.nextInt(p.length)];
            s += pos[r.nextInt(pos.length)];
            s += o[r.nextInt(o.length)];
        } else {
            int x = r.nextInt(3);
            s += x == 0 ? "X" : p[r.nextInt(p.length)];
            s += pos[r.nextInt(pos.length)];
            s += x == 1 ? "3" : o[r.nextInt(o.length)];
            if (x == 2) s+= "7";
        }
        return s;
    }

    @Test
    public void testPP() {
        for (int i = 0; i < 20; i++) {
            pieceTest(genPP(true), true);
        }
        for (int i = 0; i < 20; i++) {
            pieceTest(genPP(false), false);
        }
    }

    private String getPS(boolean good) {
        List<String> pieces = new LinkedList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < p.length; j++)
                pieces.add(p[j]);
        }
        List<String> positions = new LinkedList<>();
        for (int i = 0; i < pos.length; i++)
            positions.add(pos[i]);

        Random r = new Random();
        String s = "";

        if (good) {
            for (int i = 0; i < 24; i++) {
                s += pieces.remove(r.nextInt(pieces.size()));
                s += positions.remove(r.nextInt(positions.size()));
                s += o[r.nextInt(o.length)];
            }
            return s;
        } else {
            int t = r.nextInt(3);
            if (t == 0) {
                for (int i = 0; i < 24; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                s += genPP(true);
                return s;
            } else if (t == 1) {
                pieces.set(0, p[1]);
                positions.set(2, pos[0]);
                for (int i = 0; i < 23; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                return s;
            } else {
                pieces.set(0, p[1]);
                positions.set(2, pos[0]);
                for (int i = 0; i < 24; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                return s;
            }
        }
    }

    @Test
    public void testPS() {
        stringTest(null, false);
        stringTest("", false);
        stringTest("B21SB12NB13NB14WR40NR01NG03WG10SR32NG20EG02SB22WR42NB41ER33EG30SG24NR23EG04SB00NG34WB44SR11WR43S", true);
        for (int i = 0; i < 20; i++)
            stringTest(getPS(true), true);
        for (int i = 0; i < 20; i++)
            stringTest(getPS(false), false);
    }

    @Test
    public void testAdjacentSimple() {
        adjacentTest(0, 0, 0, -1);
        adjacentTest(0, 2, 2, -1);
        adjacentTest(0, 2, 1, -1);
        adjacentTest(0, 2, 0, 5);
        adjacentTest(3, 2, 0, 8);
        adjacentTest(24, 0, 0, 19);
        adjacentTest(24, 2, 0, -1);
        adjacentTest(24, 2, 3, -1);
        adjacentTest(24, 2, 1, 23);
    }
    @Test
    public void testAdjacent() {
        adjacentTest(20, 1, 0, 21);
        adjacentTest(5, 1, 1, 10);
        adjacentTest(19, 1, 3, 14);
        adjacentTest(24, 2, 1, 23);
        adjacentTest(21, 2, 3, 22);
        adjacentTest(22, 3, 1, 17);
        adjacentTest(14, 2, 1, 13);
        adjacentTest(19, 0, 2, 24);
        adjacentTest(4, 2, 3, -1);
        adjacentTest(7, 3, 1, 2);
        adjacentTest(24, 3, 0, 23);
        adjacentTest(22, 1, 1, -1);
        adjacentTest(8, 0, 1, 9);
        adjacentTest(18, 3, 2, 19);
        adjacentTest(11, 3, 0, 10);
        adjacentTest(11, 1, 0, 12);
        adjacentTest(2, 0, 1, 3);
        adjacentTest(7, 3, 1, 2);
        adjacentTest(24, 0, 3, 23);
        adjacentTest(4, 3, 1, -1);
        adjacentTest(11, 2, 3, 12);
        adjacentTest(21, 2, 2, 16);
        adjacentTest(19, 3, 3, 24);
        adjacentTest(19, 3, 2, -1);
        adjacentTest(9, 0, 1, -1);
        adjacentTest(22, 1, 3, 17);
        adjacentTest(17, 2, 1, 16);
        adjacentTest(11, 3, 1, 6);
        adjacentTest(13, 2, 3, 14);
        adjacentTest(23, 2, 3, 24);
        adjacentTest(0, 1, 0, 1);
        adjacentTest(6, 0, 3, 5);
        adjacentTest(22, 0, 2, -1);
        adjacentTest(14, 3, 0, 13);
        adjacentTest(18, 1, 3, 13);
        adjacentTest(2, 0, 1, 3);
        adjacentTest(2, 3, 2, 3);
        adjacentTest(22, 2, 2, 17);
        adjacentTest(17, 0, 3, 16);
        adjacentTest(18, 2, 2, 13);
    }


}