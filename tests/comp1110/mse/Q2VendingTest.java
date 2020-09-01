package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class Q2VendingTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    private void constructorTest(Q2Vending o, String v1, int v2) {
        assertNotEquals("Expected non-null object, but got null.",  o, null);
        assertEquals("Expected id be "+v1+" but got "+o.id, v1, o.id);
        assertEquals("Expected vendRate to be "+v2+" but got "+o.vendRate, v2, o.vendRate);
    }
    private void setterGetterTest(Q2Vending o, int value) {
        assertEquals("Expected vendRate to be "+value+" but was "+o.vendRate, value, o.vendRate);
        assertEquals("Expected getter to return "+value+" but it returned "+o.getVendRate(), value, o.getVendRate());
    }
    private void functionTest(Q2Vending o, int in, int expected) {
        int v = o.wholeDaysLeft(in);
        assertEquals("Expected wholeDaysLeft() for vending machine '"+o+"' and input '"+in+"' to return "+expected+" but got "+v, expected, v);
    }
    private void toStringTest(Q2Vending o, String expected) {
        String out = o.toString();
        assertEquals("Expected toString() to produce '"+expected+"', but got '"+out+"'", expected, out);
    }
    private void factoryTest(String[] v1, int[] v2) {
        Q2Vending[] out = Q2Vending.makeVending(v1, v2);
        if (v1 == null || v2 == null) {
            assertNull("Expected return null for inputs '" + v1 + "', '" + v2 + "', but did not.", out);
        } else if (v1.length == 0 || v2.length == 0 || v1.length != v2.length) {
            assertNull("Expected to return null for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but did not.", out);
        } else {
            assertNotNull("Expected non-null value for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null.",out);
            for (int i = 0; i < v1.length; i++) {
                assertNotNull("Expected non-null value for entry ["+i+"] and inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null entry.",out[i]);
                assertEquals("Expected name '" + v1[i] + "' but got " + out[i].id, v1[i], out[i].id);
                assertEquals("Expected consumption '" + v2[i] + "' but got " + out[i].vendRate, v2[i], out[i].vendRate);
            }
        }
    }
    static String[] names = {"B6DY87", "K8F7W0", "P9J6V4", "L8G0B2", "Q2M3M8", "K8S5G3", "B7H4W4", "W2T5Y1", "C8Y3P9", "V8N6F5"};

    @Test
    public void testConstructor() {
        Q2Vending o = new Q2Vending(names[0], 10);
        constructorTest(o, names[0], 10);
    }

    @Test
    public void testSetter() {
        Q2Vending o = new Q2Vending(names[1], 10);
        constructorTest(o,names[1], 10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v = 1+r.nextInt(10);
            o.setVendRate(v);
            setterGetterTest(o, v);
        }
    }

    @Test
    public void testFunction() {
        Q2Vending o = new Q2Vending(names[2], 11);
        constructorTest(o,names[2], 11);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v1 = 10+r.nextInt(10);
            int v2 = 100+(1+r.nextInt(10));
            o.setVendRate(v1);
            setterGetterTest(o, v1);
            functionTest(o, v2, (v2/v1));
        }
    }

    @Test
    public void testToString() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            String n = names[r.nextInt(names.length)];
            int v = 10+r.nextInt(60);
            Q2Vending o = new Q2Vending(n, v);
            constructorTest(o,n, v);
            toStringTest(o, "Machine "+n+" vends "+v+" drinks per day");
        }
    }

    private String[] newRandString(int size) {
        Random r = new Random();
        String[] rtn = new String[size];
        for (int i = 0; i < size; i++) {
            rtn[i] = names[r.nextInt(names.length)];
        }
        return rtn;
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
            String[] n = newRandString(l1);
            int[] v;
            int c = r.nextInt(6);
            if (c == 0) {
                v = null;
            } else if (c == 1) {
                v= newRandInt(n.length + 1);
            } else
                v = newRandInt(n.length);
            factoryTest(n, v);
        }
    }
}