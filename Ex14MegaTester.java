import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


class Ex14MegaTester {

    @org.junit.jupiter.api.Test
    void subStrC() {

        char c = 'c';
        assertEquals(Ex14.subStrC("ccc",c),1); // basic test
        assertEquals(Ex14.subStrC("vvv",'v'),1); // let try different char
        assertEquals(Ex14.subStrC("cc",c),0); // 0 strings
        assertEquals(Ex14.subStrC("c",c),0); // 0 strings
        assertEquals(Ex14.subStrC("ccccccccccccccccccccccc",c),21); // 0 strings
        assertEquals(Ex14.subStrC("",c),0); // 0 strings
        assertEquals(Ex14.subStrC(null,c),0); // maybe we don't check a null ?
        assertEquals(Ex14.subStrC("cccc",c),2); // let see if work with biger sub
        assertEquals(Ex14.subStrC("vvvv",'v'),2); // agine that we can habdel difrent char
        assertEquals(Ex14.subStrC("cvcaczc",c),2); //  maybe we do smoe shinings because ohter chars
        assertEquals(Ex14.subStrC("CcCcCccC",c),2); // Case senstive test
        assertEquals(Ex14.subStrC("VVVVvVVVvVVVvvVVVV",'v'),2); // Case senstive test
        assertEquals(3, Ex14.subStrC("awaxczabaar", 'a'));
        assertEquals(2, Ex14.subStrC("abcdefaaba", 'a'));
        assertEquals(0, Ex14.subStrC("aaaaaaaaaaaaaaaaaa", 'c'));

    }

    @org.junit.jupiter.api.Test
    void subStrMaxC() {
        assertEquals(Ex14.subStrMaxC("cc",'c',1),1); // simaple test
        assertEquals(Ex14.subStrMaxC("cc",'c',0),1); //
        assertEquals(Ex14.subStrMaxC("zz",'z',1),1);// can we do this with other chars?
        assertEquals(Ex14.subStrMaxC("c",'c',1),0);
        assertEquals(Ex14.subStrMaxC("",'c',1),0);
        assertEquals(Ex14.subStrMaxC("CCcCCcCC",'c',1),1); // Case senstive?
        assertEquals(Ex14.subStrMaxC("ccCCCCC",'c',1),1); // Case senstive?
        assertEquals(Ex14.subStrMaxC("cCCcCCCC",'c',1),1); // Case senstive?
        assertEquals(Ex14.subStrMaxC("ccCCCCCC",'c',1),1); // Case senstive?
        assertEquals(Ex14.subStrMaxC("ccc",'c',1),3); //
        assertEquals(Ex14.subStrMaxC("ccc",'c',0),2); //
        assertEquals(Ex14.subStrMaxC("cccc",'c',1),5); //
        assertEquals(Ex14.subStrMaxC("cccc",'c',2),6); //
        assertEquals(Ex14.subStrMaxC("cccc",'c',3),6); // there is no a sub with 3 c inside
        assertEquals(Ex14.subStrMaxC("ZXZXCCC!:)cCcXcZcCCCC",'c',3),6); // Case senstive?
        System.out.println(" if it take more then 1~2 sec maybe u dont do O(n) ?");
        for (int i = 1; i <10000000 ; i++) {// is bigger k trick our method?
            assertEquals(Ex14.subStrMaxC("",'F',(i-1)),0);
            assertEquals(Ex14.subStrMaxC("c",'c',(i-1)),0);
            assertEquals(1,Ex14.subStrMaxC("cc",'c',(i-1)));
            assertEquals(Ex14.subStrMaxC(null,'F',(i-1)),0);
            assertEquals(Ex14.subStrMaxC("",'F',-(i-1)),0);
            assertEquals(Ex14.subStrMaxC(null,'F',-(i-1)),0);
            assertEquals(Ex14.subStrMaxC("vvv",'v',i),3);
            assertEquals(Ex14.subStrMaxC("vzvzvz",'z',i),3);
            assertEquals(Ex14.subStrMaxC("ZvvZvzvZZZzvzZvvZ",'z',i),3);// case senstive + random chars
        }
        assertEquals(Ex14.subStrMaxC("ccc",'c',-1),0); //
    }

    @org.junit.jupiter.api.Test
    void zeroDistance() {
        int[] a1= {0,0};
        int[] a1copy = a1.clone();
        Ex14.zeroDistance(a1);
        assertArrayEquals(a1copy,a1);
        int[] a2= {1,0};
        int[] a2copy = a2.clone();
        Ex14.zeroDistance(a2);
        assertArrayEquals(a2copy,a2);
        int[] a3= {0,1};
        int[] a3copy = a3.clone();
        Ex14.zeroDistance(a3);
        assertArrayEquals(a3copy,a3);

        int[] a4= {0,1,0};
        int[] a4copy = a4.clone();
        Ex14.zeroDistance(a4);
        assertArrayEquals(a4copy,a4);
        int[] a5pre = {0,1,1,1,1,1,0};
        Ex14.zeroDistance(a5pre);
        int[] a5 = {0,1,2,3,2,1,0};
        assertArrayEquals(a5pre,a5);
        int[] a6pre = {0,1,1,1,1,1,0,1,1,1};
        Ex14.zeroDistance(a6pre);
        int[] a6 = {0,1,2,3,2,1,0,1,2,3};
        assertArrayEquals(a6pre,a6);


    }

    @org.junit.jupiter.api.Test
    void isTrans() {
        assertEquals(true,Ex14.isTrans("",""));
        assertEquals(false,Ex14.isTrans("a",""));
        assertEquals(false,Ex14.isTrans("","a"));
        assertEquals(true,Ex14.isTrans("a","a"));
        assertEquals(true,Ex14.isTrans("a","aa"));
        assertEquals(true,Ex14.isTrans("a","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(false,Ex14.isTrans("aa","a"));
        assertEquals(true,Ex14.isTrans("aa","aa"));
        assertEquals(true,Ex14.isTrans("aa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(false,Ex14.isTrans("aaa","a"));
        assertEquals(false,Ex14.isTrans("aaa","aa"));
        assertEquals(true,Ex14.isTrans("aaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals(true,Ex14.isTrans("abc","abc"));
        assertEquals(true,Ex14.isTrans("aabc","aaabc"));
        assertEquals(true,Ex14.isTrans("aabc","aaabbc"));
        assertEquals(true,Ex14.isTrans("aabc","aaabcc"));
        assertEquals(true,Ex14.isTrans("aabc","aaabc"));
        assertEquals(true,Ex14.isTrans("aabbc","aaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbcccc"));
        assertEquals(false,Ex14.isTrans("aabbc","abbbbbbbbbbbbbcccc"));
        assertEquals(false,Ex14.isTrans("aabbcc","abc"));
        assertEquals(false,Ex14.isTrans("aabbcc","abcc"));
        assertEquals(false,Ex14.isTrans("aabbcc","abbcc"));
        assertEquals(false,Ex14.isTrans("aabbcc","aabcc"));
        assertEquals(false,Ex14.isTrans("aabbcc","abc"));
        assertEquals(false,Ex14.isTrans("ABC","abc"));
        assertEquals(false,Ex14.isTrans("abc","ABC"));
        assertEquals(false,Ex14.isTrans("aabcccc","abcc"));
        assertEquals(false,Ex14.isTrans("aabcccc","aabcc"));
        assertEquals(true,Ex14.isTrans("aabcccc","aabbcccc"));
        assertEquals(false,Ex14.isTrans("aabcccc","ababcc"));

    }

    @org.junit.jupiter.api.Test
    void countPaths() {
        int[][] a = {{22}};
        assertEquals(1, Ex14.countPaths(a)); // if we start at end
        try{
            int[][] a1 = {{0}};
            assertEquals(1, Ex14.countPaths(a1)); // may ur if are no in order?
            int[][] a2 = {{0,0},{0,0}};
            assertEquals(0, Ex14.countPaths(a2)); // can u count ?
        }catch( RuntimeException ex) {
            System.out.println(" maybe u don't check for 0?");
        }


        int[][] a3 = {{10,10},{10,0}};
        assertEquals(2, Ex14.countPaths(a3));

        int[][] a3_1 = {{10,0},{10,0}};
        assertEquals(1, Ex14.countPaths(a3_1));

        int[][] a4 = {{11,10},{10,0}}; // hmmm let see if u pass this
        assertEquals(1, Ex14.countPaths(a4));
        int[][] a5 = {{11,0},{0,0}}; // how about this?
        assertEquals(1, Ex14.countPaths(a5));
        int[][] a6 = {{11,11},{11,11}}; //  so u sure u handel this?
        assertEquals(1, Ex14.countPaths(a6));
        int[][] b1 = {{11,11,11},{11,11,11}}; // let do a מלבן
        assertEquals(0, Ex14.countPaths(b1));
        int[][] b2 = {{11,11,11},{10,10,74}}; // ok a מלבן that can be solved
        assertEquals(1, Ex14.countPaths(b2));
        int[][] b3 = {{10,11,11},{10,10,74}}; // ok a מלבן that can be solved
        assertEquals(2, Ex14.countPaths(b3));
        int[][] c1 = {{23,22,11,2},{0,1,2,3},{9,22,33,0}};
        assertEquals(Ex14.countPaths(c1),1);
        int[][] c2 = {{11,22,11,2},{0,11,2,3},{9,22,10,9}};
        assertEquals(Ex14.countPaths(c2),1);
        int[][] c3 = {{11,22,11,2},{0,10,11,3},{9,10,10,9}};
        assertEquals(Ex14.countPaths(c3),2);
        int[][] c4 = {{10,10,10,10},{10,10,10,10},{10,10,10,10}};
        assertEquals(Ex14.countPaths(c4),10);
        int[][] d1 = {{10,10,10,10},{10,10,10,10},{10,10,10,10},{10,10,10,10}};
        assertEquals(Ex14.countPaths(d1),20);
        int[][] d2 = {{10,10,10,10},{10,10,10,10},{10,10,10,0},{10,10,0,10}};
        assertEquals(Ex14.countPaths(d2),0);
        int[][] d3 = {{10,10,10,0},{10,10,10,0},{10,10,11,0},{0,0,0,0}};
        assertEquals(Ex14.countPaths(d3),6);

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <=10 ; j++) {
                assertEquals(Ex14.countPaths(mat10(i,j)),numberOfPaths(i,j));
            }
        }




    }
    // Question 1
    @Test
    void whenNoPattern_shouldReturnZero() {
        assertSubStrCPatternAppears(0, "", ' ');
        assertSubStrCPatternAppears(0, "cbc", 'c');
        assertSubStrCPatternAppears(0, "cbcc", 'A');
        assertSubStrCPatternAppears(0, "AcBacBAc", 'b');
    }

    @Test
    void shouldReturnNumberOfPatternInString() {
        assertSubStrCPatternAppears(0, "cbcaBas", 'c');
        assertSubStrCPatternAppears(1, "ccc", 'c');
        assertSubStrCPatternAppears(2, "cccc", 'c');
        assertSubStrCPatternAppears(3, "ccccc", 'c');
        assertSubStrCPatternAppears(1, "cCcaBbac", 'c');
        assertSubStrCPatternAppears(1, "cbcbb", 'b');
        assertSubStrCPatternAppears(3, "ACcCCabBcDaacacc", 'c');
        assertSubStrCPatternAppears(1, "ccccCcCBAC", 'C');
        assertSubStrCPatternAppears(4, "abcbcabcacabcc", 'c');
    }

    @Test
    void whenNoPattern_thenReturnZero() {
        assertSubStrMaxPatternAppears(0, "", 'c', 0);
        assertSubStrMaxPatternAppears(0, "abc", 'c', 1);
        assertSubStrMaxPatternAppears(0, "abcAcBc", 'a', 2);
        assertSubStrMaxPatternAppears(0, "abc", 'c', 2);
    }

    @Test
    void whenGivenZeroK_shouldFindPattern() {
        assertSubStrMaxPatternAppears(1, "cc", 'c', 0);
        assertSubStrMaxPatternAppears(1, "cabcC", 'c', 0);
        assertSubStrMaxPatternAppears(2, "ccc", 'c', 0);
        assertSubStrMaxPatternAppears(2, "acbcbbaaAc", 'c', 0);
        assertSubStrMaxPatternAppears(3, "cccc", 'c', 0);
        assertSubStrMaxPatternAppears(3, "acccca", 'c', 0);
    }

    @Test
    void whenGivenKNumberOfAppearancesInBetween_thenFindPattern() {
        assertSubStrMaxPatternAppears(0, "abc", 'c', 2);
        assertSubStrMaxPatternAppears(3, "ccc", 'c', 1);
        assertSubStrMaxPatternAppears(5, "cccc", 'c', 1);
        assertSubStrMaxPatternAppears(3, "ccc", 'c', 1);
        assertSubStrMaxPatternAppears(6, "cccc", 'c', 2);
        assertSubStrMaxPatternAppears(1, "abcbc", 'c', 0);
        assertSubStrMaxPatternAppears(6, "abcbcabcacab", 'c', 2);
        assertSubStrMaxPatternAppears(6, "abcbcabcacab", 'c', 3);

    }

    // Question 2
    @Test
    void shouldModifyBetweenTwoZeros() {
        assertArrModified(arrBuilder(0, 1, 0, 1), arrBuilder(0, 1, 0, 1));
        assertArrModified(arrBuilder(0, 1, 1, 0), arrBuilder(0, 1, 1, 0));
        assertArrModified(arrBuilder(0, 1, 2, 1, 0), arrBuilder(0, 1, 1, 1, 0));
        assertArrModified(arrBuilder(0, 1, 2, 3, 2, 1, 0), arrBuilder(0, 1, 1, 1, 1, 1, 0));
        assertArrModified(arrBuilder(0, 1, 2, 3, 3, 2, 1, 0), arrBuilder(0, 1, 1, 1, 1, 1, 1, 0));
    }

    @Test
    void whenDoesNotStartWithZero_shouldModifyTheFirstDigitsLeft() {
        assertArrModified(arrBuilder(2, 1, 0, 1), arrBuilder(1, 1, 0, 1));
        assertArrModified(arrBuilder(3, 2, 1, 0), arrBuilder(1, 1, 1, 0));
        assertArrModified(arrBuilder(4, 3, 2, 1, 0, 1, 1, 0), arrBuilder(1, 1, 1, 1, 0, 1, 1, 0));
    }


    @Test
    void whenDoesNotEndWithZero_ModifyToTheRight() {
        assertArrModified(arrBuilder(1, 0, 1, 2, 3), arrBuilder(1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(1, 0, 1, 2, 3, 4, 5), arrBuilder(1, 0, 1, 1, 1, 1, 1));
    }

    @Test
    void shouldModifyToTheLeftAndRight() {
        assertArrModified(arrBuilder(2, 1, 0, 1, 2), arrBuilder(1, 1, 0, 1, 1));
        assertArrModified(arrBuilder(3, 2, 1, 0, 1, 2), arrBuilder(1, 1, 1, 0, 1, 1));
        assertArrModified(arrBuilder(3, 2, 1, 0, 1, 2, 3), arrBuilder(1, 1, 1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(4, 3, 2, 1, 0, 1, 2, 3, 4, 5), arrBuilder(1, 1, 1, 1, 0, 1, 1, 1, 1, 1));
    }


    @Test
    void shouldModifyFullArray() {
        assertArrModified(arrBuilder(0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3), arrBuilder(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(2, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3), arrBuilder(1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(2, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3), arrBuilder(1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(arrBuilder(2, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 4, 3, 2, 1, 0, 1, 2, 3)), arrBuilder(1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        assertArrModified(arrBuilder(arrBuilder(2, 1, 0, 1, 2, 3, 2, 1, 0, 1, 2, 3, 4, 4, 3, 2, 1, 0, 1, 2, 3)), arrBuilder(1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1));
        //Note: expected by tester
        assertArrModified(arrBuilder(0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0, 1, 2), arrBuilder(0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1));
    }

    // Question 3
    @Test
    void edgeCases() {
        assertTrans("", "");
        assertNotTrans("ab", "a");
        assertNotTrans("ab", "aaa");
    }

    @Test
    void whenSingleLetter_shouldFindTransformed() {
        assertTrans("a", "a");
        assertTrans("a", "aa");
        assertNotTrans("a", "aab");
        assertNotTrans("a", "aaaaba");
        assertNotTrans("a", "acaa");
    }

    @Test
    void whenSameLettersAppear_shouldVerifyTransformed() {
        assertTrans("aa", "aa");
        assertNotTrans("aa", "ab");
        assertTrans("ab", "ab");
        assertTrans("abc", "abc");
        assertTrans("aabc", "aabc");
        assertTrans("aabbbccc", "aabbbccc");
        assertNotTrans("aabbcc", "aabbccd");
        assertNotTrans("aabbcc", "aeabbcc");
    }

    @Test
    void whenMultipleLetters_shouldFindTransformed() {
        assertTrans("aab", "aaab");
        assertTrans("aab", "aaabbb");
        assertTrans("aabc", "aaabbbc");
        assertNotTrans("aabc", "aaabbbca");
        assertNotTrans("aabc", "aaabbbcccd");

        // Note: expected by tester
        assertTrans("abbcd", "aabbccdd");
        assertNotTrans("abbcd", "abcd");
    }

    @Test
    void ofek(){

    }

    // Question 4


    // Helper Methods
    // Question 1

    private void assertSubStrCPatternAppears(int expectedPatternAppearances, String stringToCheck, char charToFind) {
        assertEquals(expectedPatternAppearances, Ex14.subStrC(stringToCheck, charToFind));

    }

    private void assertSubStrMaxPatternAppears(int expectedAppearances, String s, char charToFind, int appearsBetweenLetters) {
        assertEquals(expectedAppearances, Ex14.subStrMaxC(s, charToFind, appearsBetweenLetters));
    }

    // Question 2

    private void assertArrModified(int[] expected, int[] actual) {
        Ex14.zeroDistance(actual);
        assertArrayEquals(expected, actual);
    }

    private int[] arrBuilder(int... args) {
        int[] array = new int[args.length];
        System.arraycopy(args, 0, array, 0, args.length);
        return array;
    }


    // Question 3
    private void assertTrans(String original, String transformed) {
        assertTrue(Ex14.isTrans(original, transformed));
    }

    private void assertNotTrans(String original, String transformed) {
        assertFalse(Ex14.isTrans(original, transformed));
    }

    public void printMat(int[][] mat){
        String s="";
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                s= s +"\t" +""+mat[i][j];
            }
            s+="\n";
        }
        System.out.print(s);
    }

    static int[][] mat10(int m,int n){
        int[][] ret = new int[m][n];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) {
                ret[i][j]=10;
            }
        }
        return ret;
    }

    static int numberOfPaths(int m, int n)
    {
        // We have to calculate m+n-2 C n-1 here
        // which will be (m+n-2)! / (n-1)! (m-1)!
        int path = 1;
        for (int i = n; i < (m + n - 1); i++) {
            path *= i;
            path /= (i - n + 1);
        }
        return path;
    }
    //Ofek tester credit to him
    @Test
    void ofek621Tester()
    {

        String[] randText = { "qcccjfqcbeccccc", "cctcohqwjcrcfli", "cyylclsccwvvdch", "ckhafqcccbpccrc",
                "fcicezccccrcccr", "ucccccclvcacyqj", "ccorclgyeycckxw", "wcccwcjcbrdcjcc", "leczccczsccwcpa",
                "uqtiyjlyccccxcz", "qcbpcyrymtivcnz", "ocmgacnifcbqeic", "dydwgfsbiczdwnc", "cfctcyccccchcdl",
                "qsctcmgkjpxwyjc", "rcbtckmtupjtlcc", "ccrdwddxcaccrzc", "nqrcctcceshpscl", "crcsncdcjclcazh",
                "cicccukgscccovn", "cicccdccccfowlt", "civzcczwcfqcnzj", "cslzcdpcctcofzg", "jccxelndregcoql",
                "csjdwcaccocglbb", "ccgcuxukvcgmcqc", "wvkccccmcircecc", "ccafzqelvoccyfc", "coclaclccqqcjvc",
                "cccxadbcngtdcdv", "ccsbecfckdncmuv", "cwzfszccncccifc", "fcchtcqketojwbi", "czoccpccrcccbas",
                "ecbchpciumdercx", "qcccogvcmccqcos", "cxnrbyccocgcqmx", "thckcycctfllqcx", "ibirccrfmcmgszo",
                "pnhencqccealnzj" };

        Integer[] randSubStrCAnswer = { 7, 3, 3, 5, 7, 6, 3, 6, 5, 3, 1, 2, 0, 7, 1, 2, 4, 3, 4, 5, 6, 3, 3, 1, 3, 4, 6,
                3, 5, 3, 3, 5, 1, 6, 2, 5, 3, 3, 1, 1 };

        for (int i = 0; i < randText.length; i++)
        {
            String conditionString = String.format("subStrC(\"%s\", 'c') == %d", randText[i], randSubStrCAnswer[i]);
            assertEqualsInt("subStrC", conditionString, Ex14.subStrC(randText[i], 'c'), randSubStrCAnswer[i], true);
        }

        assertEqualsInt("subStrMaxC", "subStrMaxC(\"c\", 'c', 1) == 0", Ex14.subStrMaxC("c", 'c', 1), 0, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"cc\", 'c', 0) == 1", Ex14.subStrMaxC("cc", 'c', 0), 1, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"ccc\", 'c', 1) == 3", Ex14.subStrMaxC("ccc", 'c', 1), 3, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"aacaa\", 'c', 0) == 0", Ex14.subStrMaxC("aacaa", 'c', 0), 0, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"caacaac\", 'c', 10) == 3", Ex14.subStrMaxC("caacaac", 'c', 10), 3,
                true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"acacacacccac\", 'c', 2) == 9",
                Ex14.subStrMaxC("acacacacccac", 'c', 2), 15, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"acccacaacfdccadvsc\", 'c', 5) == 27",
                Ex14.subStrMaxC("acccacaacfdccadvsc", 'c', 5), 27, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"\", 'c', 3) == 0", Ex14.subStrMaxC("", 'c', 3), 0, true);
        assertEqualsInt("subStrMaxC", "subStrMaxC(\"asdvssdf\", 'c', 4) == 0", Ex14.subStrMaxC("asdvssdf", 'c', 3), 0,
                true);

        Integer[] randK = { 3, 0, 1, 0, 2, 4, 0, 5, 3, 1, 3, 2, 1, 0, 0, 3, 1, 5, 0, 4, 3, 5, 3, 1, 2, 2, 1, 4, 3, 0, 3,
                5, 5, 2, 1, 3, 4, 3, 0, 3 };
        Integer[] randSubStrMaxCAnswer = { 26, 4, 7, 6, 21, 25, 4, 27, 18, 7, 3, 6, 1, 8, 2, 6, 9, 10, 5, 20, 22, 10,
                10, 3, 9, 12, 13, 10, 18, 4, 10, 21, 3, 18, 5, 18, 10, 10, 2, 3 };

        for (int i = 0; i < randText.length; i++)
        {
            String conditionString = String.format("subStrMaxC(\"%s\", 'c', %d) == %d", randText[i], randK[i],
                    randSubStrMaxCAnswer[i]);
            assertEqualsInt("subStrMaxC", conditionString, Ex14.subStrMaxC(randText[i], 'c', randK[i]),
                    randSubStrMaxCAnswer[i], true);
        }

        //@formatter:off
        Integer[][] arr =
                {
                        { 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0 },
                        { 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
                        { 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0 },
                        { 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        Integer[][] arrAfter =
                {
                        { 0 },
                        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
                        { 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 },
                        { 3, 2, 1, 0, 1, 2, 1, 0, 1, 1, 0, 1, 0 },
                        { 1, 0, 0, 0, 1, 2, 1, 0, 1, 0, 0, 1, 0 },
                        { 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4 },
                        { 3, 2, 1, 0, 1, 0, 0, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5 },
                        { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0, 0, 1 },
                        { 4, 3, 2, 1, 0, 0, 1, 1, 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 1 },
                        { 2, 1, 0, 1, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7 },
                        { 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
                        { 2, 1, 0, 1, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 2, 1, 0, 1, 2 },
                        { 0, 1, 2, 3, 2, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 5 },
                        { 2, 1, 0, 0, 1, 2, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
                        { 7, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 1, 0 },
                        { 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 } };
        //@formatter:on

        for (int i = 0; i < arr.length; i++)
        {
            int[] asPremitive = Arrays.stream(arr[i]).mapToInt(Integer::intValue).toArray();
            Ex14.zeroDistance(asPremitive);
            Integer[] asObject = Arrays.stream(asPremitive).boxed().toArray(Integer[]::new);
            assertEqualsIntArray("zeroDistance", "zeroDistance(arr[" + i + "])", asObject, arrAfter[i], true);
        }

        assertBoolean("isTrans", "isTrans(\"abc\", \"aabbcc\")", Ex14.isTrans("abc", "aabbcc"), true);
        assertBoolean("isTrans", "isTrans(\"abbc\", \"aabbcc\")", Ex14.isTrans("abbc", "aabbcc"), true);
        assertBoolean("isTrans", "isTrans(\"aabbcc\", \"aabbcc\")", Ex14.isTrans("aabbcc", "aabbcc"), true);
        assertBoolean("isTrans", "isTrans(\"aabbccc\", \"aabbcc\")", Ex14.isTrans("aabbccc", "aabbcc"), false);
        assertBoolean("isTrans", "isTrans(\"a\", \"\")", Ex14.isTrans("a", ""), false);
        assertBoolean("isTrans", "isTrans(\"t\", \"tttt\")", Ex14.isTrans("t", "tttt"), true);
        assertBoolean("isTrans", "isTrans(\"ggdgg\", \"gddgg\")", Ex14.isTrans("ggdgg", "gddgg"), false);
        assertBoolean("isTrans", "isTrans(\"jjhhhllk\", \"jhhllk\")", Ex14.isTrans("jjhhhllk", "jhhllk"), false);
        assertBoolean("isTrans", "isTrans(\"ttrrryy\", \"ttttrrrrry\")", Ex14.isTrans("ttrrryy", "ttttrrrrry"), false);
        assertBoolean("isTrans", "isTrans(\"abc\", \"acb\")", Ex14.isTrans("abc", "acb"), false);
        assertBoolean("isTrans", "isTrans(\"abc\", \"acccbbb\")", Ex14.isTrans("abc", "acccbbb"), false);
        assertBoolean("isTrans", "isTrans(\"abbc\", \"aaabbbabbc\")", Ex14.isTrans("abbc", "aaabbbabbc"), false);
        assertBoolean("isTrans", "isTrans(\"abbc\", \"abbca\")", Ex14.isTrans("abbc", "abbca"), false);
        assertBoolean("isTrans", "isTrans(\"abbc\", \"abbcccca\")", Ex14.isTrans("abbc", "abbcccca"), false);
        assertBoolean("isTrans", "isTrans(\"\", \"\")", Ex14.isTrans("", ""), true);
        assertBoolean("isTrans", "isTrans(\"a\", \"\")", Ex14.isTrans("a", ""), false);
        assertBoolean("isTrans", "isTrans(\"\", \"a\")", Ex14.isTrans("", "a"), false);

        //@formatter:off
        Integer[][] countPathArr1 = {{20, 21, 32, 31, 65, 96}, {45, 30, 82, 79, 10, 52}, {51, 46, 96, 48, 45, 10}, {50, 13, 5, 95, 1, 37}};
        Integer[][] countPathArr2 = {{20, 97, 93, 15, 15, 61}, {37, 10, 36, 40, 93, 18}, {1, 12, 82, 85, 69, 25}, {12, 52, 95, 36, 7, 90}, {80, 84, 30, 97, 24, 50}, {46, 12, 56, 1, 70, 27}, {51, 6, 74, 7, 50, 48}, {10, 52, 23, 28, 75, 45}, {37, 26, 78, 90, 8, 64}, {97, 67, 2, 58, 92, 2}};
        Integer[][] countPathArr3 = {{10, 82, 51, 79, 20, 56, 1, 86, 60, 14, 3, 58, 36, 4, 95}, {10, 61, 16, 39, 12, 17, 81, 16, 34, 24, 47, 46, 74, 76, 25}, {50, 34, 38, 48, 4, 60, 3, 17, 57, 49, 78, 49, 31, 19, 85}, {67, 52, 38, 21, 20, 43, 98, 94, 7, 32, 23, 64, 47, 67, 96}, {53, 34, 3, 87, 32, 21, 53, 15, 8, 72, 30, 70, 87, 30, 40}, {25, 40, 78, 25, 6, 76, 6, 8, 74, 91, 65, 90, 15, 3, 32}, {84, 13, 76, 78, 10, 21, 68, 52, 83, 25, 37, 35, 60, 46, 62}, {31, 25, 23, 30, 26, 72, 49, 39, 94, 0, 75, 41, 53, 98, 14}, {64, 58, 59, 10, 43, 50, 4, 96, 84, 32, 0, 5, 36, 2, 96}, {1, 5, 37, 25, 48, 23, 70, 19, 41, 28, 37, 19, 70, 46, 31}, {61, 95, 75, 34, 80, 49, 98, 7, 8, 13, 73, 62, 87, 73, 53}, {49, 92, 70, 32, 58, 2, 89, 7, 23, 82, 26, 97, 5, 45, 79}, {76, 2, 64, 25, 97, 40, 7, 30, 30, 64, 95, 45, 75, 76, 53}, {23, 79, 32, 82, 74, 46, 43, 82, 16, 27, 54, 63, 32, 93, 13}, {27, 83, 73, 0, 49, 63, 78, 45, 3, 73, 45, 48, 69, 25, 16}, {28, 46, 90, 8, 29, 40, 50, 9, 60, 80, 28, 84, 51, 54, 76}, {13, 27, 35, 75, 5, 80, 74, 64, 68, 29, 38, 35, 14, 63, 59}, {41, 35, 10, 10, 57, 42, 98, 93, 59, 19, 40, 3, 35, 13, 17}, {0, 35, 12, 30, 98, 91, 86, 26, 74, 10, 7, 73, 21, 52, 28}, {89, 93, 82, 96, 24, 97, 92, 94, 6, 25, 51, 25, 51, 27, 82}};
        Integer[][] countPathArr4 = {{46, 70, 38}, {87, 83, 2}, {16, 40, 65}, {84, 58, 14}};
        Integer[][] countPathArr5 =	{{83, 17, 48}, {37, 95, 84}, {3, 90, 21}, {36, 75, 71}};
        Integer[][] countPathArr6 =	{{10, 1, 13, 71}, {10, 22, 17, 11}, {2, 7, 5, 25}, {39, 57, 91, 74}};
        Integer[][] countPathArr7 =	{{10, 20, 86, 30}, {20, 63, 21, 49}, {86, 12, 86, 5}, {18, 70, 29, 79}};
        Integer[][] countPathArr8 = {{68, 66, 19, 57}, {21, 4, 13, 58}, {0, 31, 15, 93}, {20, 47, 0, 72}};
        Integer[][] countPathArr9 = {{30, 18, 90, 50, 45, 31, 61}, {15, 29, 51, 5, 38, 63, 80}, {55, 61, 9, 63, 15, 26, 57}, {23, 30, 92, 89, 15, 89, 81}, {23, 71, 0, 43, 29, 97, 39}, {49, 44, 55, 20, 52, 41, 55}, {28, 44, 54, 70, 71, 23, 12}, {63, 41, 33, 32, 19, 67, 59}, {78, 80, 19, 19, 72, 54, 74}, {86, 19, 98, 85, 77, 19, 71}};
        Integer[][] countPathArr10 = {{20, 9, 10, 30, 15, 20, 23, 59, 15, 96}, {3, 78, 51, 80, 66, 38, 34, 85, 97, 8}, {31, 41, 64, 45, 12, 22, 17, 64, 92, 68}, {9, 86, 46, 30, 14, 33, 36, 88, 99, 97}, {30, 59, 43, 78, 12, 0, 79, 67, 46, 9}, {9, 43, 78, 99, 86, 97, 51, 54, 75, 35}, {86, 25, 24, 40, 38, 81, 50, 23, 76, 84}, {85, 45, 35, 11, 16, 8, 79, 16, 92, 9}, {93, 83, 53, 68, 56, 92, 31, 13, 71, 98}, {67, 75, 33, 71, 6, 81, 6, 70, 39, 35}};
        Integer[][] countPathArr11 = {{10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}};
        Integer[][] countPathArr12 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        Integer[][] countPathArr13 = {{2, 64, 3, 99, 43, 90, 83, 31, 53, 8, 76, 71, 43, 66, 25}};
        Integer[][] countPathArr14 = {{3}, {54}, {21}, {5}, {26}, {74}, {35}, {25}, {6}, {65}, {10}, {50}, {59}, {7}, {99}};
        Integer[][] countPathArr15 = {{3}};
        Integer[][] countPathArr16 = {{64}};
        Integer[][] countPathArr17 = {{30, 18, 90, 0, 45, 31, 61}, {15, 29, 51, 5, 38, 63, 80}, {55, 61, 9, 63, 15, 26, 57}, {23, 30, 92, 89, 15, 89, 81}, {23, 71, 0, 43, 29, 97, 39}, {49, 44, 55, 20, 52, 41, 55}, {28, 44, 54, 70, 71, 23, 12}, {63, 41, 33, 32, 19, 67, 59}, {78, 80, 19, 19, 72, 54, 74}, {86, 19, 98, 85, 77, 19, 71}};

        ArrayList<Integer[][]> countPathArrList = new ArrayList<Integer[][]>();
        countPathArrList.add(countPathArr1);
        countPathArrList.add(countPathArr2);
        countPathArrList.add(countPathArr3);
        countPathArrList.add(countPathArr4);
        countPathArrList.add(countPathArr5);
        countPathArrList.add(countPathArr6);
        countPathArrList.add(countPathArr7);
        countPathArrList.add(countPathArr8);
        countPathArrList.add(countPathArr9);
        countPathArrList.add(countPathArr10);
        countPathArrList.add(countPathArr11);
        countPathArrList.add(countPathArr12);
        countPathArrList.add(countPathArr13);
        countPathArrList.add(countPathArr14);
        countPathArrList.add(countPathArr15);
        countPathArrList.add(countPathArr16);
        countPathArrList.add(countPathArr17);

        ArrayList<Integer> countPathArrAnsList = new ArrayList<Integer>();
        countPathArrAnsList.add(3);
        countPathArrAnsList.add(6);
        countPathArrAnsList.add(10);
        countPathArrAnsList.add(0);
        countPathArrAnsList.add(0);
        countPathArrAnsList.add(3);
        countPathArrAnsList.add(3);
        countPathArrAnsList.add(0);
        countPathArrAnsList.add(4);
        countPathArrAnsList.add(5);
        countPathArrAnsList.add(70);
        countPathArrAnsList.add(70);
        countPathArrAnsList.add(1);
        countPathArrAnsList.add(1);
        countPathArrAnsList.add(1);
        countPathArrAnsList.add(1);
        countPathArrAnsList.add(2);

        ArrayList<String> countPathArrPathList = new ArrayList<String>();
        countPathArrPathList.add(
                "[0][0] -> [0][2] -> [2][5] -> [3][5]\r\n" +
                        "[0][0] -> [0][2] -> [3][4] -> [3][5]\r\n" +
                        "[0][0] -> [2][0] -> [3][5]");
        countPathArrPathList.add(
                "[0][0] -> [0][2] -> [9][5]\r\n" +
                        "[0][0] -> [2][0] -> [3][0] -> [5][1] -> [7][2] -> [9][5]\r\n" +
                        "[0][0] -> [2][0] -> [3][0] -> [4][2] -> [4][5] -> [9][5]\r\n" +
                        "[0][0] -> [2][0] -> [3][0] -> [4][2] -> [7][2] -> [9][5]\r\n" +
                        "[0][0] -> [2][0] -> [2][1] -> [4][2] -> [4][5] -> [9][5]\r\n" +
                        "[0][0] -> [2][0] -> [2][1] -> [4][2] -> [7][2] -> [9][5]");
        countPathArrPathList.add(
                "[0][0] -> [0][1] -> [8][3] -> [8][4] -> [11][8] -> [14][10] -> [19][14]\r\n" +
                        "[0][0] -> [0][1] -> [8][3] -> [8][4] -> [11][8] -> [13][11] -> [19][14]\r\n" +
                        "[0][0] -> [0][1] -> [8][3] -> [9][3] -> [11][8] -> [14][10] -> [19][14]\r\n" +
                        "[0][0] -> [0][1] -> [8][3] -> [9][3] -> [11][8] -> [13][11] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [7][2] -> [9][5] -> [11][8] -> [14][10] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [7][2] -> [9][5] -> [11][8] -> [13][11] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [8][4] -> [11][8] -> [14][10] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [8][4] -> [11][8] -> [13][11] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [9][3] -> [11][8] -> [14][10] -> [19][14]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [9][3] -> [11][8] -> [13][11] -> [19][14]");
        countPathArrPathList.add("None");
        countPathArrPathList.add("None");
        countPathArrPathList.add(
                "[0][0] -> [0][1] -> [1][1] -> [3][3] \r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [3][3] \r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [3][3]");
        countPathArrPathList.add(
                "[0][0]	 -> [0][1] -> [0][3] -> [3][3]\r\n" +
                        "[0][0] -> [0][1] -> [2][1] -> [3][3]\r\n" +
                        "[0][0] -> [1][0] -> [1][2] -> [3][3]");
        countPathArrPathList.add("None");
        countPathArrPathList.add(
                "[0][0] -> [0][3] -> [5][3] -> [5][5] -> [9][6]\r\n" +
                        "[0][0] -> [0][3] -> [5][3] -> [7][3] -> [9][6]\r\n" +
                        "[0][0] -> [3][0] -> [5][3] -> [5][5] -> [9][6]\r\n" +
                        "[0][0] -> [3][0] -> [5][3] -> [7][3] -> [9][6]");
        countPathArrPathList.add(
                "[0][0] -> [0][2] -> [0][3] -> [3][3] -> [3][6] -> [9][9]\r\n" +
                        "[0][0] -> [0][2] -> [0][3] -> [3][3] -> [6][3] -> [6][7] -> [9][9]\r\n" +
                        "[0][0] -> [0][2] -> [1][2] -> [6][3] -> [6][7] -> [9][9]\r\n" +
                        "[0][0] -> [2][0] -> [3][3] -> [3][6] -> [9][9]\r\n" +
                        "[0][0] -> [2][0] -> [3][3] -> [6][3] -> [6][7] -> [9][9]");
        countPathArrPathList.add(
                "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [0][4] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [4][0] -> [4][1] -> [4][2] -> [4][3] -> [4][4]");
        countPathArrPathList.add(
                "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [4][0] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" +
                        "[0][0] -> [0][1] -> [0][2] -> [0][3] -> [0][4] -> [1][4] -> [2][4] -> [3][4] -> [4][4]");
        countPathArrPathList.add("[0][0] -> [0][2] -> [0][5] -> [0][14]");
        countPathArrPathList.add("[0][0] -> [3][0] -> [8][0] -> [14][0]");
        countPathArrPathList.add("[0][0]");
        countPathArrPathList.add("[0][0]");
        countPathArrPathList.add(
                "[0][0] -> [3][0] -> [5][3] -> [5][5] -> [9][6]\r\n" +
                        "[0][0] -> [3][0] -> [5][3] -> [7][3] -> [9][6]");

        //@formatter:on

        for (int i = 0; i < countPathArrList.size(); i++)
        {
            String message = String.format("Array:\r\n%sThe paths:\r\n%s", arrayDeepToString(countPathArrList.get(i)),
                    countPathArrPathList.get(i));
            int[][] asPrimitive = new int[countPathArrList.get(i).length][countPathArrList.get(i)[0].length];

            for (int j = 0; j < countPathArrList.get(i).length; j++)
                for (int j2 = 0; j2 < countPathArrList.get(i)[0].length; j2++)
                    asPrimitive[j][j2] = countPathArrList.get(i)[j][j2];

            assertEqualsInt("countPath", "countPath(countPathArr1) == " + countPathArrAnsList.get(i),
                    Ex14.countPaths(asPrimitive), countPathArrAnsList.get(i), true, message);
        }

        results();
        exportLog("Ex14Tester");
    }

    static void addTest(String methodTest, String conditionString, Object functionValue, Object expectedValue,
                        boolean condition, boolean expectedResult, int stackTrace, String adiadditionalMessage)
    {
        int lineNum = Thread.currentThread().getStackTrace()[stackTrace].getLineNumber();


        if (expectedResult == condition)
        {

        }
        else
        {
            System.out.println("ERROR");
        }
    }

    public static String arrayDeepToString(Object[] arr)
    {
        String s = "";

        for (int i = 0; i < arr.length; i++)
            if (arr[i] instanceof Object[])
                s += arrayDeepToString((Object[]) arr[i]) + "\r\n";
            else
                s += arr[i].toString() + "\t";

        return s;
    }

    public static void assertEqualsInt(String methodTest, String conditionString, int functionValue, int expectedValue,
                                       boolean expectedResult)
    {
        addTest(methodTest, conditionString, functionValue, expectedValue, functionValue == expectedValue,
                expectedResult, 3, "");
    }

    public static void assertEqualsInt(String methodTest, String conditionString, int functionValue, int expectedValue,
                                       boolean expectedResult, String customMessage)
    {
        addTest(methodTest, conditionString, functionValue, expectedValue, functionValue == expectedValue,
                expectedResult, 3, customMessage);
    }

    public static void assertEqualsIntArray(String methodTest, String conditionString, Integer[] arr,
                                            Integer[] arrAfter, boolean expectedResult)
    {
        addTest(methodTest, conditionString, arr, arrAfter, Arrays.equals(arr, arrAfter), expectedResult, 3, "");
    }

    public static void assertBoolean(String methodTest, String conditionString, boolean functionValue,
                                     boolean expectedResult)
    {
        addTest(methodTest, conditionString, functionValue, expectedResult, functionValue, expectedResult, 3, "");
    }

    public static void results()
    {

    }

    public static String addUnderline(String s)
    {
        return s + "\r\n" + new String(new char[s.length()]).replace("\0", "-");
    }

    public static void exportLog(String fileName)
    {
        try
        {
            String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
            String filePath = String.format("%s\\%s.txt", desktopPath, fileName);

            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.flush();
            bw.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String print2DArr(int[][] _arr)
    {
        String s = "";

        for (int i = 0; i < _arr.length; i++)
            s += Arrays.toString(_arr[i]) + "\r\n";

        return s;
    }
}
