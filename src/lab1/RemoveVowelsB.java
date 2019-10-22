// delete this line if this is not in a folder called lab1
package lab1;

import java.util.Arrays;

public class RemoveVowelsB {


    /**
     * Returns a new array that is a copy of s with vowels removed.
     * The new array should have no empty characters (it should be smaller in length than s).
     * <p>
     * <p>
     * {'t', 'h', 'e', ' ', 'd', 'o', 'g'} -> {'t', 'h',  ' ', 'd', 'g'}
     *
     * @param s an array
     * @return a new array
     */
    public static char[] removeVowels(char[] s) {
        int num = s.length;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
                num--;
            }
        }
        char[] newArray = new char[num];
        int num2 = 0;
         for(int i = 0; i < s.length ; i++) {
            if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {

            }
            else {
               newArray[num2] = s[i];
               num2++;
            }
        }
         return newArray;
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

        char[] outputArray = removeVowels(inputArray);

        System.out.println(Arrays.toString(inputArray));
        System.out.println(Arrays.toString(outputArray));
    }
}
