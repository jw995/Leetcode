/**
 * @author: Jiayi
 * @ver:    1.0
 * @since:  09-04-2018
 */
import java.util.*;

public class isPermutation {

    private static String str1 = "good";
    private static String str2 = "dog";

    private static String str3 = "shampoo";
    private static String str4 = "oopsham";

    /**
     * @param str1
     * @param str2
     * @return true if two strings are permutation, vice versa
     */
    public static boolean isPermutation(String str1, String str2){
        // compare length
        if (str1.length() != str2.length()){
            return false;
        }

        char[] cStr1 = str1.toCharArray();
        char[] cStr2 = str2.toCharArray();

        // sort the char array
        Arrays.sort(cStr1);
        Arrays.sort(cStr2);
        String s1 = new String (cStr1);
        String s2 = new String (cStr2);

        return s1.equals(s2);
    }


    public static void main (String[] args) {
        boolean result1 = isPermutation(str1, str2);
        boolean result2 = isPermutation(str3, str4);

        System.out.println("String "+ str1 + " and string "
                + str2 + " is permutation: " + result1);
        System.out.println("String "+ str3 + " and string "
                + str4 + " is permutation: " + result2);
    }
}
