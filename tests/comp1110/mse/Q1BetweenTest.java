package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q1BetweenTest {
    static final double DELTA = 1e-8;
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    private void test(double[] values, double min, double max, double expected) {
        double out = Q1Between.between(values, min, max);
        assertEquals("Expected " + expected + " but got " + out + " for min " + min + ", max "+max+", and values " + Arrays.toString(values), expected, out, DELTA);
    }

    @Test
    public void testNull() {
        test(null, 0, 0, 0);
    }

    @Test
    public void testEmpty() {
        double[] v = {};
        test(v, 0, 0, 0);
    }

    @Test
    public void testSimple() {
        double[] v = {0, 1.0, 0, 4.0, 0, 3.0, 2.0};
        test(v, 0, 0, 0);
        test(v, -1, 5, 1.42857142857142);
        test(v, 0, 5, 2.5);
        test(v, 1, 4, 2.5);
        test(v, 2, 2.5, 0);
        test(v, 5, 0, 0);
    }

    @Test
    public void medium() {
        double[] v0 = {-3.5, -3.0, -4.5, -1.0, -2.0, 3.0, -3.0, -4.5, -1.5, -4.5};
        test(v0, -4.5, -2.0, -3.1666666666666665);
        double[] v1 = {-3.0, 2.5, -4.5, 4.0, -4.0, -2.5, -1.5, -4.5, -3.0, -2.5};
        test(v1, -5.0, -4.5, 0.0);
        double[] v2 = {-1.0, 3.0, 3.5, -1.5, -4.5, -3.5, -4.5, -0.5, 2.0, -2.0};
        test(v2, -5.0, 2.5, -1.9375);
        double[] v3 = {-0.5, 3.5, -3.5, 3.0, -0.0, 4.5, -1.5, -4.0, 4.5, -2.5};
        test(v3, 2.5, -2.0, 0.0);
        double[] v4 = {-3.0, -4.0, -2.5, -2.5, -2.5, -0.0, 3.0, -3.5, -0.5, -0.5};
        test(v4, -3.0, 3.0, -1.4166666666666667);
        double[] v5 = {2.0, 4.0, -1.0, 0.5, 3.0, 3.0, 1.5, -0.5, -2.0, 4.5};
        test(v5, -0.5, 0.5, 0.0);
        double[] v6 = {-0.0, 1.5, -1.0, 0.5, 3.0, 4.0, -1.5, -3.5, 4.5, 1.0};
        test(v6, 0.5, 1.0, 0.0);
        double[] v7 = {-4.0, 4.5, 2.5, -4.0, -4.5, 2.0, -4.5, -2.0, -3.5, 0.0};
        test(v7, -4.5, -4.0, 0.0);
        double[] v8 = {-4.5, 0.5, -2.0, -1.5, -3.5, 2.0, 1.5, -2.0, 2.5, -0.0};
        test(v8, -4.5, -0.5, -2.25);
        double[] v9 = {1.5, -1.0, 1.5, 4.5, -1.0, -3.5, -3.0, 1.5, 4.5, 1.0};
        test(v9, -4.0, 1.0, -2.125);
    }

    @Test
    public void longer() {
        double[] v0 = {-16.5, -2.5, -14.5, 8.5, 10.5, -18.0, 3.5, -11.5, 14.5, 11.5, -14.5, 17.0, -17.0, 9.5, 10.0, 19.5, 9.5, 1.5, -17.5, -18.0, -18.0, -9.5, 8.5, -1.5, 5.5, 16.0, 9.0, 11.0, 7.5, -13.5, 12.5, 5.0, 5.0, 6.5, 10.5, 19.0, -11.0, 9.0, 6.5, 17.0};
        test(v0, 10.5, 9.5, 0.0);
        double[] v1 = {-3.5, -12.5, -7.0, -14.0, -7.0, 11.5, -10.5, 2.0, -17.5, -9.0, -2.5, 19.0, 15.0, 5.5, -19.0, -5.0, -2.5, -10.5, 16.0, -18.5, 2.0, -17.5, -8.5, 17.5, -2.5, 2.5, 9.0, -7.0, 0.5, 17.5, -14.5, 2.5, 10.5, 0.0, -8.5, -18.5, 3.0, -16.0, 10.0, 6.0};
        test(v1, 11.0, 18.5, 15.5);
        double[] v2 = {19.5, -12.0, -13.0, 18.5, 19.0, -9.5, -9.5, -15.0, 10.5, 13.0, 15.5, 16.5, -5.5, -4.5, 17.5, -13.5, 1.0, -16.0, -14.0, -7.0, -14.0, -16.0, 2.0, -14.0, -7.5, -11.0, 9.5, -9.0, 17.0, 11.5, 19.5, 11.5, -10.5, -9.0, -9.5, -13.0, 10.0, 12.5, -17.5, 7.0};
        test(v2, 15.0, 17.0, 16.0);
        double[] v3 = {-12.0, 16.5, 8.5, 6.5, 6.0, 19.0, -11.0, 10.0, -2.5, 8.5, -7.5, 17.0, -10.0, 17.0, 2.0, -5.5, -3.5, -17.0, 0.0, -6.5, -6.5, -10.0, 2.5, -17.0, -19.0, -7.0, -17.0, -13.0, -6.5, -7.5, -7.0, 9.5, -15.5, -8.0, -5.5, 13.0, -18.0, -14.5, -11.0, -12.5};
        test(v3, -2.5, -13.0, 0.0);
        double[] v4 = {1.5, 19.0, -8.0, 14.5, -12.5, -2.0, 15.0, 1.0, -1.0, -0.0, 1.5, -13.0, 15.0, -2.5, 12.0, 19.5, -4.0, 19.5, -8.0, -6.5, -0.5, -6.0, 19.0, 14.0, -16.5, -14.0, -1.0, -18.5, -3.5, -13.0, 6.0, -2.0, 1.5, -0.5, -15.5, 10.0, -9.0, 12.0, 3.5, -3.0};
        test(v4, 14.5, -9.5, 0.0);
        double[] v5 = {-17.0, -11.0, -8.0, -3.5, 0.5, 13.0, 10.0, -16.0, -2.5, -13.5, -15.0, -13.0, -3.0, 1.0, -17.5, -17.0, -11.5, 9.5, 14.5, -13.0, -3.0, 2.0, -2.0, 18.5, 9.5, -10.0, -7.5, 19.5, -3.0, -15.0, 1.0, -7.5, 17.0, 2.5, -19.5, -18.5, -19.5, 4.0, 19.5, -11.0};
        test(v5, -15.5, 14.5, -3.5714285714285716);
        double[] v6 = {3.5, 14.0, -12.5, 4.5, -9.5, -18.5, 17.0, -18.0, 6.5, 11.0, 9.0, -19.5, 1.0, 3.5, 14.0, -10.5, -7.5, -15.5, -0.5, -6.5, -14.5, -10.0, -16.5, -15.0, -18.5, 15.0, -0.0, 0.5, 10.0, -4.0, -8.5, 1.0, -0.0, 3.5, 6.5, -3.5, 12.0, 0.0, -10.5, 11.0};
        test(v6, 11.0, -4.5, 0.0);
        double[] v7 = {4.0, -7.0, -6.5, -13.0, -12.5, 11.0, 1.0, 16.5, -12.0, 9.5, -5.0, 15.0, -9.0, 7.5, 11.0, 4.0, 2.0, -9.5, 12.5, -2.0, -19.0, 2.0, -15.5, 15.0, -0.5, 12.0, 0.0, 12.0, 1.0, 8.0, 18.0, -16.0, 19.0, -7.0, -18.5, -10.0, 15.0, -15.0, 1.0, -11.0};
        test(v7, -6.5, 11.5, 3.40625);
        double[] v8 = {15.0, 18.5, -6.0, 13.0, -5.0, -16.5, -16.5, -17.5, 19.5, -4.5, 15.0, -8.5, -5.0, -10.5, 11.5, -14.5, -12.0, -6.0, 10.0, -12.5, 13.5, 6.0, 11.5, 12.0, -19.0, -0.0, 5.5, 13.0, -10.0, 8.0, 15.0, 18.5, 10.0, -2.0, -7.5, -10.0, 19.5, -4.5, 12.0, 10.0};
        test(v8, 18.5, 12.0, 0.0);
        double[] v9 = {-11.5, -18.0, 12.0, 3.0, -12.5, 4.5, -3.0, 19.0, -14.0, 19.0, -19.5, -3.0, 16.5, 3.0, -16.5, 15.0, 3.0, -2.5, -7.5, -4.0, 4.0, -18.0, -13.5, 4.0, 8.0, 4.5, 1.0, -9.5, 8.0, -8.5, 2.5, 1.0, -10.5, 4.0, -2.0, -19.0, 10.0, -10.5, -9.0, -17.5};
        test(v9, -3.0, 0.5, -2.25);
    }
}