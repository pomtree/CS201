// delete this line if this is not in a folder called lab1
package lab1;

public class Palindrome {

    /**
     * Returns true if 's' reads the same forwards and back (with spaces removed)
     *
     * @param s a string
     * @return true if s is a palindrome
     */
    public static boolean isPalindrome(String s) {
        return removeSpaces(s).equals(removeSpaces(flip_string(s)));
    }

    public static void printResult(boolean a) {
        if (a) {
            System.out.println("Yes this is a palindrome");
        } else {
            System.out.println("No this is not a palindrome");
        }
    }

    public static void main(String[] args) {
        String s = "a man a plan a canal panama";
        boolean a = isPalindrome(s);
        printResult(a);
        String t = "racecars";
        boolean b = isPalindrome(t);
        printResult(b);
    }

    static String removeSpaces(String str) {
        String new_string = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                new_string += str.charAt(i) + "";
            }
        }
        return new_string;
    }

    static String flip_string(String s) {
        String new_string = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            new_string += s.charAt(i) + "";
        }
        return new_string;
    }

}


