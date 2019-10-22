// delete this line if this is not in a folder called lab1
package lab1;

import java.util.Arrays;

public class RemoveVowelsA {


    /**
     * Modifies 's' removing 'a', 'e', 'i', 'o', 'u' and shifting other characters
     * <p>
     * {'t', 'h', 'e', ' ', 'd', 'o', 'g'} -> {'t', 'h',  ' ', 'd', 'g', '', ''}
     *
     * @param s an array
     * @return
     */
    public static void removeVowels(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                s[i] = ' ';
            }
        }
    }


    /**
     * Returns s as an array of chars
     *
     * @param s
     * @return
     */
    public static char[] stringToChar(String s) {
        return s.toCharArray();
    }

    public static void main(String[] args) {
        String input = "the quick brown fox jumped over the lazy dog";

        char[] inputArray = stringToChar(input);

        removeVowels(inputArray);

        System.out.println(Arrays.toString(inputArray));
    }
}
