package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Q4TunnelsTest {
  @Rule
  public Timeout globalTimeout = Timeout.millis(1000);


  private void directTest(String board, int from, boolean vertical, int expected) {
    int out = Q4Tunnels.directlyReaches(board, from, vertical);
    assertEquals("Expected '" + expected + "' but got '" + out + "' for '" + board+"' and position '"+from+"' with vertical="+vertical, expected, out);
  }
  private void shortestTest(String board, int start, int end, int expected) {
    int out = Q4Tunnels.shortest(board, start, end);
    assertEquals("Expected '" + expected + "' but got '" + out + "' for '" + board+"' and start '"+start+"' and end '"+end+"'", expected, out);
  }

  @Test
  public void testDirectSimple() {
    directTest("WWWWWWWWW", 0, true, -1);
    directTest("WWWWWWWWW", 3, true, 0);
    directTest("WWWWWWWWW", 3, false, -1);
    directTest("WWWWWWWWW", 7, false, 6);
    directTest("XXXXXXXXX", 0, true, 6);
    directTest("XXXXXXXXX", 6, true, -1);
    directTest("XXXXXXXXX", 0, false, -1);
    directTest("XXXXXXXXX", 8, false, -1);
    directTest("YYYYYYYYYYYYYYYY", 0, true, 12);
    directTest("YYYYYYYYYYYYYYYY", 3, true, 15);
    directTest("YYYYYYYYYYYYYYYY", 3, false, 0);
    directTest("YYYYYYYYYYYYYYYY", 13, false, -1);
    directTest("ZZZZZZZZZ", 0, true, -1);
    directTest("ZZZZZZZZZ", 7, true, 1);
    directTest("ZZZZZZZZZ", 0, false, 1);
    directTest("ZZZZZZZZZ", 8, false, -1);
  }

  @Test
  public void testDirect(){
    directTest("WYXXXZXYZ", 4, true, -1);
    directTest("YWYYWWZXW", 7, false, -1);
    directTest("WWWWZYWYY", 5, false, -1);
    directTest("ZXZZZZXZZ", 7, true, 1);
    directTest("WWYZWZWXW", 1, true, -1);
    directTest("WWYXYYYYW", 6, false, -1);
    directTest("ZYXXWYZYW", 6, false, 7);
    directTest("XYYYXXXZY", 8, false, -1);
    directTest("XWWWWXXZZ", 1, true, -1);
    directTest("WZXXYWZYY", 6, true, 0);
    directTest("YZXZWXWWXWZZWWXX", 3, false, -1);
    directTest("YXXXZYXYYXXWZXYW", 6, true, 14);
    directTest("XXZWZYYYZXZZZZWX", 2, true, -1);
    directTest("XYYWWZYZZZYWZZYY", 0, true, 8);
    directTest("XZWXYXZXZZWZXZYZ", 11, true, 3);
    directTest("ZXZXWYYYXWZXXWYZ", 4, true, 0);
    directTest("ZZXYZWZZYXZYWZXW", 1, true, -1);
    directTest("XYXXXWZXYZYXXWWW", 4, false, 7);
    directTest("YYYZZXYWZZZXXZWY", 11, true, -1);
    directTest("ZZWZXWWYYYWWYWXW", 2, false, 1);
    directTest("YWXWXXWWXWYZWXWWXYYXZYWWW", 23, false, 22);
    directTest("WXWWWYWWZYYZZYYYWZZZXYWYX", 6, true, 1);
    directTest("XYZXWZXXXYZZXZZZXYWYXYXYW", 14, true, 4);
    directTest("XXWWWYYYXXWWYZYXWWXZXWWZY", 9, true, 19);
    directTest("XXXZZXXXWXXYZYXXXXZYXWZZY", 24, false, 21);
    directTest("ZXZXXZZZYYWYZYZWZWXWZYWYY", 3, true, 13);
    directTest("YWZYWXWXYWWYXXZXYWZWZYYXX", 5, false, 8);
    directTest("XWWZXYWWXWZXXZZZWWYYWWWYY", 4, true, 14);
    directTest("XXYXXXWZWXZYYWXZZYWYXYYXY", 11, false, -1);
    directTest("ZXYXYXZYWWYWWYZYXZXWXZYWZ", 15, true, -1);
  }
  @Test
  public void testShortestSimple() {
    shortestTest("WWWWWWWWW", 0, 0, 0);
    shortestTest("WWWWWWWWW", 3, 0, 1);
    shortestTest("WWWWWWWWW", 6, 0, 2);
    shortestTest("XXXXXXXXX", 0, 6, 1);
    shortestTest("XXXXXXXXX", 3, 0, 0);
    shortestTest("YYYYYYYYYYYYYYYY", 0, 12, 1);
    shortestTest("YYYYYYYYYYYYYYYY", 3, 15, 1);
    shortestTest("ZZZZZZZZZ", 6, 0, 1);
    shortestTest("ZZZZZZZZZ", 3, 0, 0);
    shortestTest("ZZZZZZZZZ", 0, 1, 1);
    shortestTest("ZZZZZZZZZ", 0, 2, 2);
    shortestTest("ZZZZZZZZZ", 0, 3, 0);
  }
  @Test
  public void testShortestRandom() {
    shortestTest("WWXXWWWYW", 1, 2, 0);
    shortestTest("YYZXYXZYY", 6, 8, 0);
    shortestTest("WXZYYYWZY", 4, 3, 0);
    shortestTest("XXWYXXYYZ", 6, 3, 0);
    shortestTest("XXYYYYYZZ", 6, 8, 0);
    shortestTest("WXXZWZZZZ", 8, 8, 0);
    shortestTest("ZXZZWWYZY", 6, 0, 0);
    shortestTest("ZZWXZWWXX", 4, 4, 0);
    shortestTest("ZYZYZZWWY", 2, 6, 0);
    shortestTest("YZWYYWWWW", 7, 3, 2);
  }
  @Test
  public void testShortest() {
    shortestTest("XZYXZXZWWXXYZZXZ", 14, 11, 0);
    shortestTest("WYZYXWWZWXZZXYXY", 7, 13, 0);
    shortestTest("XYWXXYWXXYWYZYXX", 11, 13, 0);
    shortestTest("ZXXXYXYYYXYZYZXZ", 2, 6, 0);
    shortestTest("YZYXYZYYZZZXWWWW", 2, 13, 2);
    shortestTest("ZWZYWZYZXZXXWZXZ", 9, 1, 1);
    shortestTest("YXXWYYZZXXZZWXYX", 2, 6, 0);
    shortestTest("XYYXWXXXXZZYYWZZ", 7, 0, 0);
    shortestTest("WYWZWZWZWXWXZYWW", 9, 1, 0);
    shortestTest("ZWXXZZZWXZZXXWYY", 2, 13, 0);
    shortestTest("WWXYZZYYWXYXWZZWYXXZXWXWZ", 13, 18, 2);
    shortestTest("ZZXZZZXYYZWZWWWWZXWWZYZZX", 10, 21, 0);
    shortestTest("WXYZWYYWWYXWWZWZWYXXZZXZW", 12, 20, 3);
    shortestTest("ZXYYWYXXXZXWXWZXWYWYYXZXZ", 24, 11, 6);
    shortestTest("ZZXXZYXXYZXYZWZYYZZXZWWZY", 24, 9, 0);
    shortestTest("ZZYXZYYWWXWZZZWXYZXWXXWXZ", 9, 2, 0);
    shortestTest("YZYXXXZXWZYYYZXWXWXXYYZYW", 15, 10, 1);
    shortestTest("YZYXYZZWZXZXXXYZYWXZZWYYY", 10, 15, 2);
    shortestTest("YZXYYZXZYWZXXXZXWXXZYWYZZ", 11, 9, 4);
    shortestTest("XYZXZWXWYZZYZZWZZXZXZZYWW", 4, 8, 0);
  }
}
