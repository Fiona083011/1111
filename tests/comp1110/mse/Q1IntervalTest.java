package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Q1IntervalTest {
    static final double DELTA = 1e-8;
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    private void test(double[] values, int start, int end, double expected) {
        double out = Q1Interval.interval(values, start, end);
        assertEquals("Expected " + expected + " but got " + out + " for start " + start + ", end "+end+", and values " + Arrays.toString(values), expected, out, DELTA);
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
        double[] v = {-3.0, 1.0, 0, 4.0, -0.5, 3.0, 2.0};
        test(v, 0, 0, -3.0);
        test(v, 0, 5, -3.0);
        test(v, 1, 5, -.5);
        test(v, 4, 4, -0.5);
        test(v, 2, 4, -0.5);
        test(v, 1, 3, 0);
    }

    @Test
    public void medium() {
        double[] v0 = {-0.5, -0.5, 4.0, 3.5, -4.5, -4.5, 3.5, 2.0, -4.5, 1.5};
        test(v0, 1, 0, 0.0);
        double[] v1 = {3.5, -1.0, -2.0, -0.5, -3.5, -3.0, -0.0, 4.0, 3.5, 1.5};
        test(v1, 2, 4, -3.5);
        double[] v2 = {0.5, -2.5, -4.5, 3.5, -3.5, 2.5, 0.5, 3.0, -4.0, 0.5};
        test(v2, 6, 1, 0.0);
        double[] v3 = {-4.5, -4.0, -0.0, -0.0, 2.0, -1.0, 3.0, 3.0, -0.5, -4.0};
        test(v3, 1, 5, -4.0);
        double[] v4 = {4.5, 1.5, -1.5, 3.5, 2.5, -1.0, 4.5, -3.5, 1.5, -0.0};
        test(v4, 5, 9, -3.5);
        double[] v5 = {-0.5, 4.0, -4.5, 0.0, -4.0, -4.0, 4.5, -4.5, 2.5, 2.0};
        test(v5, 5, 8, -4.5);
        double[] v6 = {0.0, -2.5, -2.0, 1.0, 0.0, 2.0, -0.0, 2.0, -1.5, -1.0};
        test(v6, 5, 7, -0.0);
        double[] v7 = {4.5, 3.5, 3.5, -0.5, -3.0, 3.5, 1.0, 0.0, -4.5, 4.5};
        test(v7, 3, 6, -3.0);
        double[] v8 = {-0.5, 0.5, 3.5, 0.5, 4.5, 3.5, 0.5, 4.5, -3.5, -0.5};
        test(v8, 4, 2, 0.0);
        double[] v9 = {4.0, 4.0, -4.5, 3.5, 2.5, 3.5, -4.0, -1.0, -3.0, -3.0};
        test(v9, 7, 9, -3.0);
    }

    @Test
    public void longer() {
        double[] v0 = {11.0, -0.0, 16.5, 16.5, -7.0, 9.0, -12.5, -13.5, 1.5, 13.0, 19.5, 2.0, 10.5, -10.5, 6.5, -8.0, 0.5, 13.5, -3.5, 13.5, -13.0, 11.5, 10.0, 5.5, -13.0, 18.0, 14.0, 1.0, 19.5, -7.5, -0.5, 1.5, -8.5, -5.0, 0.0, -9.0, -8.0, -6.0, 7.5, -11.0};
        test(v0, 38, 15, 0.0);
        double[] v1 = {17.0, 5.5, -10.0, 11.5, -5.0, -3.5, -0.0, -2.5, -7.5, -1.0, -15.5, 16.0, 2.5, -2.5, 16.0, -8.5, -6.5, -12.0, 1.5, -17.5, 4.5, -0.5, -17.5, 17.5, -13.5, 7.0, 10.0, 16.5, 0.5, -6.5, 14.0, 18.0, 9.5, 5.5, 2.5, 12.5, -1.5, -1.0, -16.5, -14.5};
        test(v1, 23, 35, -13.5);
        double[] v2 = {-0.0, -10.0, -14.5, 13.0, -7.0, 19.0, 10.5, 11.5, 7.0, 11.0, -2.5, -6.0, 10.0, -3.5, 18.5, -17.5, 15.0, -19.0, -17.0, -10.0, 10.0, -8.5, -19.0, -14.5, -19.5, 12.5, -1.5, 8.0, -6.5, -0.0, 16.0, -12.0, -9.5, 13.5, -1.0, 17.5, 12.5, -8.5, -14.0, -0.5};
        test(v2, 15, 33, -19.5);
        double[] v3 = {9.0, -7.5, -1.0, 4.0, 12.5, 13.0, -10.0, -17.5, 13.0, -5.0, -9.5, -17.5, 14.0, -13.0, 7.0, 4.5, -7.5, -10.0, -16.0, -13.0, -10.5, 3.0, -2.0, 9.5, -2.5, -15.0, 0.0, 2.5, -5.5, 19.0, 13.0, 9.0, 4.5, 0.0, 11.0, 6.5, 8.5, 4.5, -10.5, -7.0};
        test(v3, 24, 35, -15.0);
        double[] v4 = {9.0, -3.0, 11.5, -18.0, 19.0, 5.5, -6.0, 18.5, 11.0, -6.0, -13.5, -14.5, -5.0, -19.5, 5.0, 15.0, -6.0, -16.5, -7.0, -14.0, -11.5, -17.0, -5.5, -13.0, -5.0, 2.5, 12.5, -17.0, -6.0, 15.0, 19.0, 13.5, 11.5, 2.0, 16.0, 5.0, 11.0, -19.0, -8.5, -10.0};
        test(v4, 20, 32, -17.0);
        double[] v5 = {-4.0, 13.5, 7.5, -18.5, -6.5, 18.0, -7.0, -18.5, 1.5, 12.5, -10.0, -19.0, -10.0, -17.5, -18.5, -10.5, 12.5, -3.5, 17.0, 8.5, 11.5, -11.5, 9.5, 14.0, 13.5, 10.0, 10.0, 1.5, 15.5, 6.5, -1.0, -13.5, -10.5, -11.0, -18.5, 14.0, 0.0, -6.0, 15.0, -11.5};
        test(v5, 0, 8, -18.5);
        double[] v6 = {-6.5, 7.5, -12.5, -2.0, -5.5, -0.0, -8.0, 3.5, 11.5, 14.5, -5.0, 10.5, 11.5, 13.0, 5.5, -6.0, 5.0, -13.0, 14.5, 15.0, -12.0, -12.5, 3.0, 5.5, 14.0, -15.5, 4.0, 0.5, -14.0, 2.5, -17.0, -10.5, 10.5, 7.5, 8.5, -16.5, -12.5, -5.0, -13.5, 11.0};
        test(v6, 37, 26, 0.0);
        double[] v7 = {8.0, -8.5, 17.5, -7.5, 7.5, 17.5, 4.0, -2.5, -7.5, -4.5, 15.0, -5.5, -6.5, 1.5, 9.0, 2.0, -2.0, 11.0, -12.0, 17.5, 2.0, -19.5, -8.5, 12.0, -11.5, -10.5, 16.0, -17.5, 3.0, 9.5, -16.0, 11.5, 11.5, 5.5, -4.0, -8.0, 9.0, -13.5, -3.0, -18.5};
        test(v7, 39, 39, -18.5);
        double[] v8 = {-13.5, -11.5, -11.0, -16.5, 18.5, -2.5, -11.0, -10.5, -13.5, -15.5, 16.5, -9.5, -18.0, -18.0, -7.5, 13.5, -8.0, -7.5, -3.5, -8.5, -15.0, -18.0, -14.0, -5.0, 2.0, -4.5, 5.5, -6.0, -15.5, -19.0, 1.0, 16.5, -3.0, -6.0, 17.0, -6.0, -13.5, -4.5, -19.0, 16.5};
        test(v8, 6, 33, -19.0);
        double[] v9 = {9.0, -8.5, -12.5, 15.0, -4.0, 1.5, 1.5, -13.0, 13.5, -2.5, -14.0, -15.0, -12.5, 3.5, 0.0, -3.0, -19.5, 16.0, 14.5, 15.5, 19.0, -15.0, 3.0, 0.5, 15.5, 0.5, 15.0, 14.5, 19.5, -10.0, -16.5, -15.5, -17.5, 18.0, -15.0, 2.0, 10.5, -3.0, -7.0, 18.5};
        test(v9, 15, 20, -19.5);
    }
}