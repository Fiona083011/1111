package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Q3MagnetsTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);


    private void pieceTest(String in, boolean expected) {
        boolean out = Q3Magnets.wellFormedPiecePlacement(in);
        assertEquals("Expected " + expected + " but got " + out + " for piece placement '" + in + "'", expected, out);
    }

    private void stringTest(String in, boolean expected) {
        boolean out = Q3Magnets.wellFormedPuzzleString(in);
        assertEquals("Expected " + expected + " but got " + out + " for puzzle string '" + in + "'", expected, out);
    }

    private void adjacentTest(int p, int s, int o, int expected) {
        int out = Q3Magnets.getAdjacent(p, s, o);
        assertEquals("Expected "+expected+" but got "+ out+" for getNext("+p+", "+s+", "+o+")", expected, out);
    }

    static String[] p = { "W", "B", "O", "P"};
    static String[] pos;
    {
        pos = new String[16];
        for (int i = 0; i < 16; i++) {
            pos[i] = String.format("%02d", i);
        }
    }
    static String[] o = { "N", "S", "E", "W"};


    @Test
    public void testSimplePP() {
        pieceTest(null, false);
        pieceTest("", false);
        pieceTest("XXXX", false);

        pieceTest("W11N", true);
        pieceTest("B00S", true);
        pieceTest("O15E", true);
        pieceTest("P08W", true);

        pieceTest("511N", false);
        pieceTest("W113", false);
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
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < p.length; j++)
                pieces.add(p[j]);
        }
        List<String> positions = new LinkedList<>();
        for (int i = 0; i < pos.length; i++)
            positions.add(pos[i]);

        Random r = new Random();
        String s = "";

        if (good) {
            for (int i = 0; i < 16; i++) {
                s += pieces.remove(r.nextInt(pieces.size()));
                s += positions.remove(r.nextInt(positions.size()));
                s += o[r.nextInt(o.length)];
            }
            return s;
        } else {
            int t = r.nextInt(3);
            if (t == 0) {
                for (int i = 0; i < 16; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                s += genPP(true);
                return s;
            } else if (t == 1) {
                pieces.set(0, p[1]);
                positions.set(2, pos[0]);
                for (int i = 0; i < 15; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                return s;
            } else {
                pieces.set(0, p[1]);
                positions.set(2, pos[0]);
                for (int i = 0; i < 16; i++) {
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
        adjacentTest(0, 2, 0, 4);
        adjacentTest(3, 2, 0, 7);
        adjacentTest(15, 0, 0, 11);
        adjacentTest(15, 2, 0, -1);
        adjacentTest(15, 2, 3, -1);
        adjacentTest(15, 2, 1, 14);
    }
    @Test
    public void testAdjacent() {
        adjacentTest(15, 1, 1, -1);
        adjacentTest(10, 2, 0, 14);
        adjacentTest(5, 0, 2, 9);
        adjacentTest(1, 2, 0, 5);
        adjacentTest(5, 1, 0, 6);
        adjacentTest(10, 1, 3, 6);
        adjacentTest(4, 0, 3, -1);
        adjacentTest(13, 3, 3, -1);
        adjacentTest(7, 3, 1, 3);
        adjacentTest(8, 1, 0, 9);
        adjacentTest(0, 3, 0, -1);
        adjacentTest(12, 0, 0, 8);
        adjacentTest(8, 0, 0, 4);
        adjacentTest(2, 2, 0, 6);
        adjacentTest(14, 2, 0, -1);
        adjacentTest(5, 0, 2, 9);
        adjacentTest(3, 0, 1, -1);
        adjacentTest(3, 1, 2, 2);
        adjacentTest(1, 1, 3, -1);
        adjacentTest(4, 3, 0, -1);
        adjacentTest(8, 1, 3, 4);
        adjacentTest(11, 1, 2, 10);
        adjacentTest(6, 0, 0, 2);
        adjacentTest(14, 3, 2, 15);
        adjacentTest(2, 1, 3, -1);
        adjacentTest(6, 2, 0, 10);
        adjacentTest(6, 3, 2, 7);
        adjacentTest(0, 1, 0, 1);
        adjacentTest(6, 3, 2, 7);
        adjacentTest(12, 0, 0, 8);
        adjacentTest(12, 0, 2, -1);
        adjacentTest(5, 0, 3, 4);
        adjacentTest(6, 3, 1, 2);
        adjacentTest(11, 1, 3, 7);
        adjacentTest(8, 2, 3, 9);
        adjacentTest(15, 0, 3, 14);
        adjacentTest(6, 1, 3, 2);
        adjacentTest(15, 2, 1, 14);
        adjacentTest(15, 1, 2, 14);
        adjacentTest(12, 1, 1, -1);
    }


}