/**
 * This program checks if a String is the permutation of a palindrome.
 * The characters are not case sensitive.
 * @author: Jiayi
 * @ version 1.0
 * @ since 09-16-2018
 */
public class Palindrome {

    // test strings
    private static String str1 = "Tact coa";
    private static String str2 = "COCONANOA";
    private static String str3 = "better";

    /**
     * A function to figure out if the string being test is a permutation palindrome.
     * @param str input string
     * @return true or false
     */
    public static boolean isPermuPalindrome(String str) {
        int[] freqTable = new int['z'-'a'+ 1];
        int oddCount = 0;

        // store the frequency of each character into the table
        for (char ch : str.toCharArray()) {
            int charVal = getCharVal(ch);

            if (charVal != -1) {
                freqTable[charVal]++;
            }
        }

        for (int i = 0; i < freqTable.length; i++) {
            if (freqTable[i] % 2 == 1) {
                oddCount++;

                //check if there is more than one odd frequency
                if (oddCount > 1) {return false;}
            }
        }
        return true;
    }

    /**
     * A function to get the numeric number of the characters
     * @param ch the character in a string
     * @return an int number of the character's numeric value
     */
    public static int getCharVal(char ch) {
        int x = Character.getNumericValue(ch);
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int A = Character.getNumericValue('A');
        int Z = Character.getNumericValue('Z');

        if (x > a && x < z) {return (x - a);}
        if (x > A && x < Z) {return (x - A);}
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("String " + str1 + " is permutation palindrome: "
                + isPermuPalindrome(str1));
        System.out.println("String " + str2 + " is permutation palindrome: "
                + isPermuPalindrome(str2));
        System.out.println("String " + str3 + " is permutation palindrome: "
                + isPermuPalindrome(str3));
    }
}
