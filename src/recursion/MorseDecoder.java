package recursion;

import java.util.ArrayList;
import java.util.List;

public class MorseDecoder {


    // This should recursively decode the morse code
    // This should check the prefix of the morse code to see if it can be decoded
    // If it can, track it and append it to all results of decoding the rest of the code
    // Keep all possibilities in a list and return all possibilities
    public List<String> decode(String morseCode) {
        List<String> decoded = new ArrayList<String>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0;i < morseCode.length(); i++) {
            prefix.append(morseCode.charAt(i));
            if (MorseCode.decode(prefix.toString())!=null) {
                String left = prefix.toString();
                if(i+1 == morseCode.length()) {
                    decoded.add(Character.toString(MorseCode.decode(left)));
                } else {
                    String right = morseCode.substring(i+1);
                    List<String> rightDecode = decode(right);
                    for(String s : rightDecode) {
                        decoded.add(MorseCode.decode(left) + "" + s);
                    }
                }
            }

        }
        return decoded;
    }

    // This should recursively encode the source text (removing spaces)
    // Encode the first character, then recursively encode the rest.
    private String encodeHelper(String text, String morse) {
        if(!text.isEmpty()){
            Character first = text.charAt(0);
            morse = morse + MorseCode.encode(first);
            text = text.substring(1);
            morse = encodeHelper(text, morse);
        }
        return morse;
    }

    public String encode(String text) {
        String morse = "";
        if(!text.isEmpty()) {
            morse = encodeHelper(text, morse);
        }
        return morse;
    }

    public static void main(String[] args){
        MorseDecoder decoder = new MorseDecoder();
        String encoded = decoder.encode("carleton");
        System.out.println(encoded);

        List<String> decoded = decoder.decode(encoded);
        for(String s : decoded) {
            System.out.println(s + "|" + decoder.encode(s));
        }
    }
}