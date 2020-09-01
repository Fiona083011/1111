package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

public class Q2ElephantTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    private void constructorTest(Q2Elephant o, String v1, int v2) {
        assertNotEquals("Expected non-null object, but got null.",  o, null);
        assertEquals("Expected name to be "+v1+" but got "+o.name, v1, o.name);
        assertEquals("Expected age to be "+v2+" but got "+o.age, v2, o.age);
    }
    private void setterGetterTest(Q2Elephant o, int value) {
        assertEquals("Expected age to be "+value+" but was "+o.age, value, o.age);
        assertEquals("Expected getter to return "+value+" but it returned "+o.getAge(), value, o.getAge());
    }
    private void functionTest(Q2Elephant o, int in, int expected) {
        int v = o.remainingYears(in);
        assertEquals("Expected remainingYears() for elephant '"+o+"' and input '"+in+"' to return "+expected+" but got "+v, expected, v);
    }
    private void toStringTest(Q2Elephant o, String expected) {
        String out = o.toString();
        assertEquals("Expected toString() to produce '"+expected+"', but got '"+out+"'", expected, out);
    }
    private void factoryTest(String[] v1, int[] v2) {
        Q2Elephant[] out = Q2Elephant.makeElephants(v1, v2);
        if (v1 == null || v2 == null) {
            assertNull("Expected return null for inputs '" + v1 + "', '" + v2 + "', but did not.", out);
        } else if (v1.length == 0 || v2.length == 0 || v1.length != v2.length) {
            assertNull("Expected to return null for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but did not.", out);
        } else {
            assertNotNull("Expected non-null value for inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null.",out);
            for (int i = 0; i < v1.length; i++) {
                assertNotNull("Expected non-null value for entry ["+i+"] and inputs '" + Arrays.toString(v1) + "', '" + Arrays.toString(v2) + "', but got null entry.",out[i]);
                assertEquals("Expected name '" + v1[i] + "' but got " + out[i].name, v1[i], out[i].name);
                assertEquals("Expected age '" + v2[i] + "' but got " + out[i].age, v2[i], out[i].age);
            }
        }
    }
    static String[] names = {"Harold", "Josephine", "Bob", "Sue", "Vijay", "Ting", "Xiao", "Frank", "Rodger", "Bridget"};

    @Test
    public void testConstructor() {
        Q2Elephant o = new Q2Elephant(names[0], 10);
        constructorTest(o, names[0], 10);
    }

    @Test
    public void testSetter() {
        Q2Elephant o = new Q2Elephant(names[1], 10);
        constructorTest(o,names[1], 10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v = 1+r.nextInt(10);
            o.setAge(v);
            setterGetterTest(o, v);
        }
    }

    @Test
    public void testFunction() {
        Q2Elephant o = new Q2Elephant(names[2], 11);
        constructorTest(o,names[2], 11);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int v1 = 1+r.nextInt(10);
            int v2 = 1+r.nextInt(10);
            o.setAge(v1);
            setterGetterTest(o, v1);
            functionTest(o, v2, v2-v1);
        }
    }

    @Test
    public void testToString() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            String n = names[r.nextInt(names.length)];
            int v = r.nextInt(60);
            Q2Elephant o = new Q2Elephant(n, v);
            constructorTest(o,n, v);
            toStringTest(o, "Elephant " + n + " is " + v + " years old");
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