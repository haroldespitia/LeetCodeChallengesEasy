package FirstTen;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private Map<Character, Integer> getRomanKeys() {
        Map<Character, Integer> romanKeys = new HashMap<>();
        romanKeys.put('I', 1);
        romanKeys.put('V', 5);
        romanKeys.put('X', 10);
        romanKeys.put('L', 50);
        romanKeys.put('C', 100);
        romanKeys.put('D', 500);
        romanKeys.put('M', 1000);
        return romanKeys;
    }

    private int romanToInt(String s) {
        Map<Character, Integer> romanKeys = getRomanKeys();
        int integerNumber = 0, temp = 0;
        for (int i = 0; i <= s.length() - 1; i++) {
            if (i < s.length() - 1 && romanKeys.get(s.charAt(i)) < romanKeys.get(s.charAt(i + 1))) {
                integerNumber -= romanKeys.get(s.charAt(i));
            } else {
                integerNumber += romanKeys.get(s.charAt(i));
            }

        }
        return integerNumber;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String caseA = "III";
        String caseB = "LVIII";
        String caseC = "MCMXCIV";
        System.out.println(romanToInteger.romanToInt(caseC));
    }
}
