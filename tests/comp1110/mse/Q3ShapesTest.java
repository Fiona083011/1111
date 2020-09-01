package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Q3ShapesTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);


    private void pieceTest(String in, boolean expected) {
        boolean out = Q3Shapes.wellFormedPiecePlacement(in);
        assertEquals("Expected " + expected + " but got " + out + " for piece placement '" + in + "'", expected, out);
    }

    private void stringTest(String in, boolean expected) {
        boolean out = Q3Shapes.wellFormedPuzzleString(in);
        assertEquals("Expected " + expected + " but got " + out + " for puzzle string '" + in + "'", expected, out);
    }

    private void neightbourTest(int p, int s, int o, int expected) {
        int out = Q3Shapes.getNeighbour(p, s, o);
        assertEquals("Expected "+expected+" but got "+ out+" for getNext("+p+", "+s+", "+o+")", expected, out);
    }

    static String[] p = { "A", "B", "C", "D"};
    static String[] pos;
    {
        pos = new String[16];
        for (int i = 0; i < 16; i++) {
            pos[i] = String.format("%d", i%4)+String.format("%d", i/4);
        }
    }
    static String[] o = { "N", "S", "E", "W"};


    @Test
    public void testSimplePP() {
        pieceTest(null, false);
        pieceTest("", false);
        pieceTest("XXXX", false);

        pieceTest("A11N", true);
        pieceTest("B00S", true);
        pieceTest("C13E", true);
        pieceTest("D33W", true);

        pieceTest("504N", false);
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
            for (int i = 0; i < r.nextInt(16); i++) {
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
        stringTest("", true);
        for (int i = 0; i < 20; i++)
            stringTest(getPS(true), true);
        for (int i = 0; i < 20; i++)
            stringTest(getPS(false), false);
    }

    @Test
    public void testNeighbourSimple() {
        neightbourTest(0, 0, 0, -1);
        neightbourTest(0, 2, 2, -1);
        neightbourTest(0, 2, 1, -1);
        neightbourTest(0, 2, 0, 4);
        neightbourTest(3, 2, 0, 7);
        neightbourTest(15, 0, 0, 11);
        neightbourTest(15, 2, 0, -1);
        neightbourTest(15, 2, 3, -1);
        neightbourTest(15, 2, 1, 14);
    }
    @Test
    public void testNeighbour() {
        neightbourTest(15, 1, 1, -1);
        neightbourTest(10, 2, 0, 14);
        neightbourTest(5, 0, 2, 9);
        neightbourTest(1, 2, 0, 5);
        neightbourTest(5, 1, 0, 6);
        neightbourTest(10, 1, 3, 6);
        neightbourTest(4, 0, 3, -1);
        neightbourTest(13, 3, 3, -1);
        neightbourTest(7, 3, 1, 3);
        neightbourTest(8, 1, 0, 9);
        neightbourTest(0, 3, 0, -1);
        neightbourTest(12, 0, 0, 8);
        neightbourTest(8, 0, 0, 4);
        neightbourTest(2, 2, 0, 6);
        neightbourTest(14, 2, 0, -1);
        neightbourTest(5, 0, 2, 9);
        neightbourTest(3, 0, 1, -1);
        neightbourTest(3, 1, 2, 2);
        neightbourTest(1, 1, 3, -1);
        neightbourTest(4, 3, 0, -1);
        neightbourTest(8, 1, 3, 4);
        neightbourTest(11, 1, 2, 10);
        neightbourTest(6, 0, 0, 2);
        neightbourTest(14, 3, 2, 15);
        neightbourTest(2, 1, 3, -1);
        neightbourTest(6, 2, 0, 10);
        neightbourTest(6, 3, 2, 7);
        neightbourTest(0, 1, 0, 1);
        neightbourTest(6, 3, 2, 7);
        neightbourTest(12, 0, 0, 8);
        neightbourTest(12, 0, 2, -1);
        neightbourTest(5, 0, 3, 4);
        neightbourTest(6, 3, 1, 2);
        neightbourTest(11, 1, 3, 7);
        neightbourTest(8, 2, 3, 9);
        neightbourTest(15, 0, 3, 14);
        neightbourTest(6, 1, 3, 2);
        neightbourTest(15, 2, 1, 14);
        neightbourTest(15, 1, 2, 14);
        neightbourTest(12, 1, 1, -1);
    }


}