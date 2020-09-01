package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Q3JigsawTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);


    private void pieceTest(String in, boolean expected) {
        boolean out = Q3Jigsaw.wellFormedPiecePlacement(in);
        assertEquals("Expected " + expected + " but got " + out + " for piece placement '" + in + "'", expected, out);
    }

    private void stringTest(String in, boolean expected) {
        boolean out = Q3Jigsaw.wellFormedPuzzleString(in);
        assertEquals("Expected " + expected + " but got " + out + " for puzzle string '" + in + "'", expected, out);
    }

    private void nextTest(int p, int s, int o, int expected) {
        int out = Q3Jigsaw.getNext(p, s, o);
        assertEquals("Expected "+expected+" but got "+ out+" for getNext("+p+", "+s+", "+o+")", expected, out);
    }

    static String[] p = { "0", "1", "2", "3", "4"};
    static String[] pos;
    {
        pos = new String[25];
        for (int i = 0; i < 25; i++) {
            pos[i] = String.format("%02d", i);
        }
    }
    static String[] o = { "N", "S", "E", "W"};


    @Test
    public void testSimplePP() {
        pieceTest(null, false);
        pieceTest("", false);
        pieceTest("XXXX", false);

        pieceTest("011N", true);
        pieceTest("100S", true);
        pieceTest("315E", true);
        pieceTest("408W", true);

        pieceTest("511N", false);
        pieceTest("0113", false);
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < p.length; j++)
                pieces.add(p[j]);
        }
        List<String> positions = new LinkedList<>();
        for (int i = 0; i < pos.length; i++)
            positions.add(pos[i]);

        Random r = new Random();
        String s = "";

        if (good) {
            for (int i = 0; i < r.nextInt(25); i++) {
                s += pieces.remove(r.nextInt(pieces.size()));
                s += positions.remove(r.nextInt(positions.size()));
                s += o[r.nextInt(o.length)];
            }
            return s;
        } else {
            int t = r.nextInt(3);
            if (t == 0) {
                for (int i = 0; i < 25; i++) {
                    s += pieces.remove(r.nextInt(pieces.size()));
                    s += positions.remove(r.nextInt(positions.size()));
                    s += o[r.nextInt(o.length)];
                }
                s += genPP(true);
                return s;
            } else {
                pieces.set(0, p[1]);
                positions.set(2, pos[0]);
                for (int i = 0; i < 25; i++) {
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
    public void testNextSimple() {
        nextTest(0, 0, 0, -1);
        nextTest(0, 2, 2, -1);
        nextTest(0, 2, 1, -1);
        nextTest(0, 2, 0, 5);
        nextTest(3, 2, 0, 8);
        nextTest(24, 0, 0, 19);
        nextTest(24, 2, 0, -1);
        nextTest(24, 2, 3, -1);
        nextTest(24, 2, 1, 23);
    }
    @Test
    public void testNext() {
        nextTest(20, 1, 0, 21);
        nextTest(5, 1, 1, 10);
        nextTest(19, 1, 3, 14);
        nextTest(24, 2, 1, 23);
        nextTest(21, 2, 3, 22);
        nextTest(22, 3, 1, 17);
        nextTest(14, 2, 1, 13);
        nextTest(19, 0, 2, 24);
        nextTest(4, 2, 3, -1);
        nextTest(7, 3, 1, 2);
        nextTest(24, 3, 0, 23);
        nextTest(22, 1, 1, -1);
        nextTest(8, 0, 1, 9);
        nextTest(18, 3, 2, 19);
        nextTest(11, 3, 0, 10);
        nextTest(11, 1, 0, 12);
        nextTest(2, 0, 1, 3);
        nextTest(7, 3, 1, 2);
        nextTest(24, 0, 3, 23);
        nextTest(4, 3, 1, -1);
        nextTest(11, 2, 3, 12);
        nextTest(21, 2, 2, 16);
        nextTest(19, 3, 3, 24);
        nextTest(19, 3, 2, -1);
        nextTest(9, 0, 1, -1);
        nextTest(22, 1, 3, 17);
        nextTest(17, 2, 1, 16);
        nextTest(11, 3, 1, 6);
        nextTest(13, 2, 3, 14);
        nextTest(23, 2, 3, 24);
        nextTest(0, 1, 0, 1);
        nextTest(6, 0, 3, 5);
        nextTest(22, 0, 2, -1);
        nextTest(14, 3, 0, 13);
        nextTest(18, 1, 3, 13);
        nextTest(2, 0, 1, 3);
        nextTest(2, 3, 2, 3);
        nextTest(22, 2, 2, 17);
        nextTest(17, 0, 3, 16);
        nextTest(18, 2, 2, 13);
    }


}