import static org.junit.jupiter.api.Assertions.*;

class Ex14TestAnton {

    @org.junit.jupiter.api.Test
    void subStrC() {
        char c = 'c';
        assertEquals(Ex14.subStrC("ccc",c),1); // basic test
        assertEquals(Ex14.subStrC("vvv",'v'),1); // let try different char
        assertEquals(Ex14.subStrC("cc",c),0); // 0 strings
        assertEquals(Ex14.subStrC("c",c),0); // 0 strings
        assertEquals(Ex14.subStrC("",c),0); // 0 strings
        assertEquals(Ex14.subStrC(null,c),0); // maybe we don't check a null ?
        assertEquals(Ex14.subStrC("cccc",c),2); // let see if work with biger sub
        assertEquals(Ex14.subStrC("vvvv",'v'),2); // agine that we can habdel difrent char
        assertEquals(Ex14.subStrC("cvcaczc",c),2); //  maybe we do smoe shinings because ohter chars
        assertEquals(Ex14.subStrC("CcCcCccC",c),2); // Case senstive test
        assertEquals(Ex14.subStrC("VVVVvVVVvVVVvvVVVV",'v'),2); // Case senstive test

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




}
