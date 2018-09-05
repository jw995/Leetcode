/**
 * @author: Jiayi
 * @ver:    1.0
 * @since:  09-04-2018
*/

public class isUnique {
    //String1: test
    private static String str1 = "test";

    //String2 : abcdefktg
    private static String str2 = "abcdefktg";

    /**
     * @param str
     * @return true if str is unique, false if str is not unique
     */

    public static boolean isUnique(String str){

        // there is 128 unique characters in total
        if (str.length() > 128){
            return false;
        }

        boolean[] judgeSet = new boolean[128];

        for (int i=0; i<str.length(); i++ ){
            // convert the character into ASCII using int
            int charVal = str.charAt(i);

            if (judgeSet[charVal] == true){
                return false;
            }
            judgeSet[charVal] = true;
        }
        return true;
    }

    public static void main(String[] args){
        //Test 1
        boolean result1 = isUnique(str1);

        //Test 2
        boolean result2 = isUnique(str2);

        //Print out results
        System.out.println("After function call: ");
        System.out.println("Test of String \"test\" is "+ result1);
        System.out.println("Test of String \"abcdefktg\" is "+ result2);
    }
}
