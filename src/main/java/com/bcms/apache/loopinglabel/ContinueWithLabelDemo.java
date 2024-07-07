package com.bcms.apache.loopinglabel;

class ContinueWithLabelDemo {
    public static void main(String[] args) {

        String searchMe = "Look for a substring in me";
        String substring = "sub";
        boolean foundIt = false;

        int max = searchMe.length() -
                substring.length();

        test:
        for (int i = 0; i <= max; i++) {
            int n = substring.length();
            int j = i;
            int k = 0;
            while (n-- != 0) {
                System.out.println("n = " + n);
                if (searchMe.charAt(j++) != substring.charAt(k++)) {
                    continue test;
                    //sem o label o continue so pula a execucao atual do while
                    //com o label ele pula para a proxima execucao do looping externo, o for.
                }
            }
            foundIt = true;
            break test;
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it");
    }
}
/*
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 2
n = 1
n = 0
Found it
 */
