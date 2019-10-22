package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MorseDecoder {


    // This should recursively decode the morse code
    // This should check the prefix of the morse code to see if it can be decoded
    // If it can, track it and append it to all results of decoding the rest of the code
    // Keep all possibilities in a list and return all possibilities
    public List<String> decodeIF(String morseCode) {
        List<String> list = new ArrayList<>();

        //1 char string
        if (morseCode.length() > 0) {
            String sub = morseCode.substring(0, 1);
            String decoded = String.valueOf(MorseCode.decode(sub));
            if (decoded != null) {
                list.add(decoded);
                list.addAll(decode(morseCode.substring(1)));
            }
        }
        //2 char string
        if (morseCode.length() > 1) {
            String sub = morseCode.substring(0, 2);
            String decoded = String.valueOf(MorseCode.decode(sub));
            if (decoded != null) {
                list.add(decoded);
                list.addAll(decode(morseCode.substring(2)));
            }
        }
        //3 char string
        if (morseCode.length() > 2) {
            String sub = morseCode.substring(0, 3);
            String decoded = String.valueOf(MorseCode.decode(sub));
            if (decoded != null) {
                list.add(decoded);
                list.addAll(decode(morseCode.substring(3)));
            }
        }
        //4 char string
        if (morseCode.length() > 3) {
            String sub = morseCode.substring(0, 4);
            String decoded = String.valueOf(MorseCode.decode(sub));
            if (decoded != null) {
                list.add(decoded);
                list.addAll(decode(morseCode.substring(4)));
            }
        }
        //5 char string
        if (morseCode.length() > 4) {
            String sub = morseCode.substring(0, 5);
            String decoded = String.valueOf(MorseCode.decode(sub));
            if (decoded != null) {
                list.add(decoded);
                list.addAll(decode(morseCode.substring(5)));
            }
        }


        return list;
    }

    public List<String> decode(String morseCode) {
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            if (morseCode.length() > i - 1) {
                String sub = morseCode.substring(0, i);
                String decoded = String.valueOf(MorseCode.decode(sub));
                if (decoded != null) {
                    list.add(decoded);
                    List<String> newList = decode(morseCode.substring(i));
                    for (String s : newList)
                        if (s != null)
                            list.add(s);

                }
            }
        }
        return list;
    }

    // This should recursively encode the source text (removing spaces)
    // Encode the first character, then recursively encode the rest.
    private static String encodeHelper(String text, String morse) {
        if (!text.isEmpty()) {
            Character first = text.charAt(0);
            morse = encode(String.valueOf(first)) + morse;
            text = text.substring(1);
            morse = encodeHelper(text, morse);
        }
        return morse;
    }

    public static String encode(String text) {
        String morse = "";
        if (!text.isEmpty()) {
            morse = encodeHelper(text, morse);
        }
        return morse;
    }

    public static void main(String[] args) {
        MorseDecoder decoder = new MorseDecoder();
        String s = "Thomas Pree";
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(1));
        System.out.println(decoder.decode("-.-..-.-..-...-----."));


    }

    private static final Map<Character, String> MORSE_CODE = createMorseCodeMap();

    private static Map<Character, String> createMorseCodeMap() {
        Map<Character, String> morse = new HashMap<>();
        morse.put('a', ".-");
        morse.put('b', "-...");
        morse.put('c', "-.-.");
        morse.put('d', "-..");
        morse.put('e', ".");
        morse.put('f', "..-.");
        morse.put('g', "--.");
        morse.put('h', "....");
        morse.put('i', "..");
        morse.put('j', ".---");
        morse.put('k', "-.-");
        morse.put('l', ".-..");
        morse.put('m', "--");
        morse.put('n', "-.");
        morse.put('o', "---");
        morse.put('p', ".--.");
        morse.put('q', "--.-");
        morse.put('r', ".-.");
        morse.put('s', "...");
        morse.put('t', "-");
        morse.put('u', "..-");
        morse.put('v', "...-");
        morse.put('w', ".--");
        morse.put('x', "-..-");
        morse.put('y', "-.--");
        morse.put('z', "--..");
        morse.put('1', ".----");
        morse.put('2', "..---");
        morse.put('3', "...--");
        morse.put('4', "....-");
        morse.put('5', ".....");
        morse.put('6', "-....");
        morse.put('7', "--...");
        morse.put('8', "---..");
        morse.put('9', "----.");
        morse.put('0', "-----");
        return morse;
    }
}