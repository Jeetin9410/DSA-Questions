package Playground;

import java.util.HashMap;
import java.util.Map;

public class CharacterCount {
    /*
      65 to 90 --> upper case
      97 to 122 --> lowercase
     */
    public static void main(String[] args) {
        String str = "abcdefghaavbcuavsouf212436@#$$%^";
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            int code = str.charAt(i);
            if((code >= 65 && code <= 90) || (code>= 97 && code<= 122)) {
                freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()) {
            System.out.println(entry.getKey() + "  "+ entry.getValue());
        }
    }
}
