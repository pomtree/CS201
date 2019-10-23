package recursion;

import java.util.List;

public class MorseDecoder {


    // This should recursively decode the morse code
    // This should check the prefix of the morse code to see if it can be decoded
    // If it can, track it and append it to all results of decoding the rest of the code
    // Keep all possibilities in a list and return all possibilities
    public List<String> decode(String morseCode) {
        return null;
    }

    // This should recursively encode the source text (removing spaces)
    // Encode the first character, then recursively encode the rest.
    public String encode(String text) {
        return null;
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