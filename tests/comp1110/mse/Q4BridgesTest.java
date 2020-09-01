package comp1110.mse;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

public class Q4BridgesTest {
  @Rule
  public Timeout globalTimeout = Timeout.millis(1000);


  private void directTest(String board, int from, boolean vertical, int expected) {
    int out = Q4Bridges.directlyReaches(board, from, vertical);
    assertEquals("Expected '" + expected + "' but got '" + out + "' for '" + board+"' and position '"+from+"' with vertical="+vertical, expected, out);
  }
  private void longestTest(String board, int start, int expected) {
    int out = Q4Bridges.longest(board, start);
    assertEquals("Expected '" + expected + "' but got '" + out + "' for '" + board+"' and start '"+start+"'", expected, out);
  }

  @Test
  public void testDirectSimple() {
    directTest("AAAAAAAAA", 0, true, -1);
    directTest("AAAAAAAAA", 3, true, 0);
    directTest("AAAAAAAAA", 3, false, 5);
    directTest("AAAAAAAAA", 7, false, -1);
    directTest("BBBBBBBBB", 0, true, 3);
    directTest("BBBBBBBBB", 6, true, -1);
    directTest("BBBBBBBBB", 0, false, -1);
    directTest("BBBBBBBBB", 8, false, 6);
    directTest("CCCCCCCCC", 0, true, -1);
    directTest("CCCCCCCCC", 7, true, 1);
    directTest("CCCCCCCCC", 0, false, 1);
    directTest("CCCCCCCCC", 8, false, -1);
    directTest("DDDDDDDDD", 0, true, 6);
    directTest("DDDDDDDDD", 7, true, -1);
    directTest("DDDDDDDDD", 0, false, -1);
    directTest("DDDDDDDDD", 8, false, 7);
  }
  @Test
  public void testDirect(){
    directTest("AADBAABBD", 6, true, -1);
    directTest("CCACACDCB", 2, false, -1);
    directTest("CDACCCCDA", 7, true, -1);
    directTest("BDDABBABA", 0, false, -1);
    directTest("DCACCACCB", 4, true, -1);
    directTest("DDBBABBDA", 1, false, 0);
    directTest("CAABAACDB", 0, true, -1);
    directTest("BDDABBCCA", 4, true, 7);
    directTest("CCDBCBCAC", 6, true, 0);
    directTest("BABDDDACA", 5, true, -1);
    directTest("CDCBBDCDCACBDBDB", 3, true, 7);
    directTest("ADCBBDCDBDCCBACB", 5, false, 4);
    directTest("DACCCBCBDBBDBBDD", 4, true, -1);
    directTest("DCAABABCCDCACDCD", 8, false, 9);
    directTest("BDBDCCBACBACDDCB", 4, false, 5);
    directTest("DBDDCCDDCDAADBDC", 2, false, 1);
    directTest("CDACCCDBBABCDBDA", 10, true, 14);
    directTest("DCBDBABDADDCAADA", 10, false, 9);
    directTest("BBCDCADCADAACACD", 14, true, 6);
    directTest("BBAADBCCADDCAABB", 14, true, -1);
    directTest("DCBBBBDDABCCCCCCCBDBABABA", 23, true, -1);
    directTest("DBCBCADCBAACCDDBCAABCCCAB", 12, false, 13);
    directTest("BABDBDCBBDDCDDADDDDABCBBD", 21, true, 11);
    directTest("CCACDBDDDCCACCACBDCDDADBA", 3, true, -1);
    directTest("CDBDADBADCCACCBBDCBCCBADB", 17, false, 18);
    directTest("CBADADACBADDBADAACDBBAADB", 8, false, 6);
    directTest("DADBDCDCCBDDCDBBCDBCDAABD", 11, true, 21);
    directTest("DDCAAACCBDBDCCDDCBBBBBCAB", 22, false, 23);
    directTest("DBDCBAAABBDCCABBDAACBACBC", 3, true, -1);
    directTest("CCDCCDAACAACCCDDADDBBDDBB", 22, true, -1);
  }
  @Test
  public void testLongestSimple() {
    longestTest("AAAAAAAAA", 0, 2);
    longestTest("AAAAAAAAA", 2, 1);
    longestTest("AAAAAAAAA", 6, 4);
    longestTest("AAAAAAAAA", 8, 3);
    longestTest("BBBBBBBBB", 0, 3);
    longestTest("BBBBBBBBB", 2, 4);
    longestTest("CCCCCCCCC", 6, 4);
    longestTest("CCCCCCCCC", 8, 2);
    longestTest("DDDDDDDDD", 2, 4);
    longestTest("DDDDDDDDD", 0, 2);
    longestTest("DDDDDDDDD", 6, 1);
  }
  @Test
  public void testLongestRandom() {
    longestTest("CABACDBDC", 3, 3);
    longestTest("CBDACAABC", 7, 1);
    longestTest("DCAADDABC", 4, 6);
    longestTest("BCAADDCAA", 5, 4);
    longestTest("DAADCBCCB", 6, 3);
    longestTest("DCBBBBBCD", 4, 7);
    longestTest("DCDCDABDC", 7, 2);
    longestTest("AADCBCACD", 0, 5);
    longestTest("CBACCCCCD", 2, 1);
    longestTest("CBABBBBDB", 3, 2);
    longestTest("BCBABAACA", 2, 4);
    longestTest("DCADDCCBD", 3, 1);
    longestTest("DDCDADAAB", 0, 3);
    longestTest("DBBDDDBBA", 8, 4);
    longestTest("CBABBCCDA", 3, 6);
    longestTest("DBADCBBBD", 1, 5);
    longestTest("AAABBCDBB", 5, 1);
    longestTest("BCDADCCDA", 4, 3);
    longestTest("BBCCBBDCD", 8, 4);
    longestTest("CACBCBCDC", 3, 4);
  }
  @Test
  public void testLongest() {
    longestTest("ABBAACCABBDBCABA", 10, 5);
    longestTest("CBDDDABCCCDBDDAD", 9, 4);
    longestTest("AAABDCACBDABDDCA", 10, 3);
    longestTest("BBCCDCBDABAAACDD", 13, 7);
    longestTest("CCBAADDCBDBDBCAC", 4, 11);
    longestTest("DCCABDDBDDCABCAC", 4, 2);
    longestTest("CACAABDCCBAABABA", 15, 3);
    longestTest("CCBDCBCACABCCAAC", 2, 5);
    longestTest("CDACBCCCAADCDDCA", 0, 6);
    longestTest("CAADADABBDCCDCCC", 11, 3);
    longestTest("DDBBBDCBBCDBDBCA", 6, 8);
    longestTest("AABABACDADDABACA", 9, 3);
    longestTest("CCBDACAADADDBCAA", 11, 8);
    longestTest("CBCCCDCCBCBCBACD", 9, 8);
    longestTest("ABDCADCCCBDCCCAC", 6, 2);
    longestTest("CCDAACBBABBACBAC", 1, 6);
    longestTest("ABDAABDAADCADBAD", 13, 1);
    longestTest("DBACCDABACADDDBB", 9, 5);
    longestTest("DABACACDBDCCDCDD", 2, 9);
    longestTest("CDDDCBCCBCCBADDB", 11, 6);
    longestTest("ADACCCADDBCACCBACCBDDBADB", 7, 12);
    longestTest("CDAABCCABCDABCACBBCBAACAC", 3, 1);
    longestTest("CDCBACADCDBADACBCCADDDBAD", 4, 1);
    longestTest("ADBCBBBBDCAACCDDCABDBADDA", 16, 11);
    longestTest("ADDAABDBBDBDDBDCDBAACDADD", 20, 4);
    longestTest("DDDBBCDADACDCBDCBAACCBACC", 17, 10);
    longestTest("DBCABDACBCBAAACBDDACCBCAA", 14, 4);
    longestTest("CBDAAAADADDADBBDCDDDBDAAC", 15, 1);
    longestTest("DABADBCBADCACDCDCCDCDBDAD", 18, 10);
    longestTest("CCADBBDAADDDABDABCCDAABDB", 8, 16);
    longestTest("ABACCDBADAACDBCDCACABACAD", 7, 3);
    longestTest("DDCABDDBDAABBCADCDDACDAAD", 0, 8);
    longestTest("DBCBBBBCBABDCBADBCDBDDABC", 0, 3);
    longestTest("AACBCCAAABBDCBBACBBCDCCAA", 2, 3);
    longestTest("DBACABBCCDAACDDABDCCDDCCD", 5, 6);
    longestTest("DADACDAABDBACBBDDBADCAABC", 12, 6);
    longestTest("CBCBCDADDDBADBBCBACBDCCAA", 20, 1);
    longestTest("BACADDCADAADACBBDADCAAADC", 19, 8);
    longestTest("CDAAADABADACBBCCBCBDCDBBA", 8, 2);
    longestTest("CAAAACCDAACBCDDABADBBAADB", 15, 11);
  }
}
