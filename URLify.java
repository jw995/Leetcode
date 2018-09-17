/**
 * This program replaces all the space in a String to "%20", assuming the String has enough
 * space at the end to hold the additional characters.
 * @author: Jiayi Wang
 * @version: 1.0
 * @since: 09-16-2018
 */
public class URLify {

    // test Strings
    private static String smith = "Mr John Smith    ";
    private static String test1 = "Do you want some ice cream?";
    private static String test2 = "  Here it is!";

    /**
     * A function to replace the space in the String
     * @param str String we want to change
     * @param len String true length
     */
    public static char[] replaceSpace(char[] str, int len) {
        int spaceNum = 0;

        for (int i=0; i<len; i++) {
            if (str[i] == ' ') {
                spaceNum++;
            }
        }
        int index = len + 2 * spaceNum - 1; // the index of last digit of the new String
        char[] newStr = new char[index + 1];

        if (str.length > len) {
            // String has extra space at the end, cut the string
            str[len] = '\0';
        }

        // replace the string from behind then we will not overwrite anything
        for (int i = len - 1; i>=0; i--) {
            if (str[i] == ' ') {
                newStr[index] = '0';
                newStr[index-1] = '2';
                newStr[index-2] = '%';
                index = index -3;
            }
            else {
                newStr[index] = str[i];
                index = index - 1;
            }
        }
        return newStr;
    }

    /**
     * The main function to test the function replaceSpace
     * @param args input arguments
     */
    public static void main(String[] args) {

        String str1 = smith.trim(); // a function to remove the leading and trailing spaces.
        String str2 = test1.trim();
        String str3 = test2.trim();

        char[] input1 = str1.toCharArray();
        char[] input2 = str2.toCharArray();
        char[] input3 = str3.toCharArray();

        int length1 = str1.length();
        int length2 = str2.length();
        int length3 = str3.length();

        input1 = replaceSpace(input1, length1);
        input2 = replaceSpace(input2, length2);
        input3 = replaceSpace(input3, length3);

        str1 = String.valueOf(input1);
        str2 = String.valueOf(input2);
        str3 = String.valueOf(input3);


        System.out.println("Test1: the original String is: " + smith);
        System.out.println("After replacing the space: " + str1);

        System.out.println("Test1: the original String is: " + test1);
        System.out.println("After replacing the space: " + str2);

        System.out.println("Test1: the original String is: " + test2);
        System.out.println("After replacing the space: " + str3);

    }

}
