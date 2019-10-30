// delete this line if this is not in a folder called lab1
package lab1;

public class RemoveVowels {
    static final String VOWELS = "aeiouAEIOU";

    /**
     * Returns s with a,e,i,o,u removed
     *
     * @param s a string
     * @return
     */
    public static String removeVowels(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (VOWELS.contains(s.charAt(i) + "")) {
                s = s.substring(0, i) + s.substring(Math.min(i + 1, s.length()));
                --i;
            }
        }
        return s;

    }


    public static void main(String[] args) {
        String input = "the quick brown fox jumped over the lazy doooooge";
        System.out.println(removeVowels(input));
    }
}
