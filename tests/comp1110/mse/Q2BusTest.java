package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class Q2BusTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    private void constructorTest(Q2Bus o, int v1, int v2) {
        assertNotEquals("Expected non-null object, but got null.",  o, null);
        assertEquals("Expected number to be "+v1+" but got "+o.number, v1, o.number);
        assertEquals("Expected speed to be "+v2+" but got "+o.speed, v2, o.speed);
    }
    private void setterGetterTest(Q2Bus o, int value) {
        assertEquals("Expected speed to be "+value+" but was "+o.speed, value, o.speed);
        assertEquals("Expected getter to return "+value+" but it returned "+o.getSpeed(), value, o.getSpeed());
    }
    private void functionTest(Q2Bus o, int in, int expected) {
        int v = o.minToGo(in);
        assertEquals("Expected minToGo() for bus '"+o+"' and input '"+in+"' to return "+expected+" but got "+v, expected, v);
    }
    private void toStringTest(Q2Bus o, String expected) {
        String out = o.toString();
        assertEquals("Expected toString() to produce '"+expected+"', but got '"+out+"'", expected, out);
    }
    private void factoryTest(int[] v1, int[] v2) {
        Q2Bus[] out = Q2Bus.makeBuses(v1, v2);
        if (v1 == null || v2 == null) {
            assertNull("Expected return null for inputs '" + v1 + "', '" + v2 + "', but did not.", out);
        } else if (v1.length == 0 || v2.length == 0 || v1.length != v2.length) {
            assertNull("Expected to return null for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but did not.", out);
        } else {
            assertNotNull("Expected non-null value for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null.",out);
            for (int i = 0; i < v1.length; i++) {
                assertNotNull("Expected non-null value for entry ["+i+"] and inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null entry.",out[i]);
                assertEquals("Expected number '" + v1[i] + "' but got " + out[i].number, v1[i], out[i].number);
                assertEquals("Expected speed '" + v2[i] + "' but got " + out[i].speed, v2[i], out[i].speed);
            }
        }
    }

    @Test
    public void testConstructor() {
        Q2Bus o = new Q2Bus(3, 10);
        constructorTest(o, 3, 10);
    }

    @Test
    public void testSetter() {
        Q2Bus o = new Q2Bus(3, 10);
        constructorTest(o,3, 10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v = 1+r.nextInt(10);
            o.setSpeed(v);
            setterGetterTest(o, v);
        }
    }

    @Test
    public void testFunction() {
        Q2Bus o = new Q2Bus(3, 10);
        constructorTest(o,3, 10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v1 = 1+r.nextInt(10);
            int v2 = 1+r.nextInt(10);
            o.setSpeed(v1);
            setterGetterTest(o, v1);
            functionTest(o, v2, (60*v2)/v1);
        }
    }

    @Test
    public void testToString() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int n = 1 + r.nextInt(20);
            int v = r.nextInt(60);
            Q2Bus o = new Q2Bus(n, v);
            constructorTest(o, n, v);
            toStringTest(o, "Bus " + n + " is travelling at " + v + " km/h");
        }
    }

    private int[] newRandInt(int size) {
        Random r = new Random();
        int[] rtn = new int [size];
        for (int i = 0; i < size; i++) {
            rtn[i] = 1+r.nextInt(20);
        }
        return rtn;
    }

    @Test
    public void testFactory() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int l1 = 1+r.nextInt(7);
            int[] n = newRandInt(l1);
            int[] s;
            int c = r.nextInt(6);
            if (c == 0) {
                s = null;
            } else if (c == 1) {
                s = newRandInt(n.length + 1);
            } else
                s = newRandInt(n.length);
            factoryTest(n, s);
        }
    }
}