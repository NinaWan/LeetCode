public class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> letterToNumber = initializeMap();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                result += letterToNumber.get((Character) s.charAt(i));
            } else {
                if (letterToNumber.get((Character) s.charAt(i)) >= letterToNumber.get((Character) s.charAt(i + 1))) {
                    result += letterToNumber.get((Character) s.charAt(i));
                } else {
                    result -= letterToNumber.get((Character) s.charAt(i));
                }
            }
        }

        return result;
    }

    // Initialize map
    private Map<Character, Integer> initializeMap() {
        Map<Character, Integer> letterToNumber = new HashMap<Character, Integer>();
        letterToNumber.put('I', 1);
        letterToNumber.put('V', 5);
        letterToNumber.put('X', 10);
        letterToNumber.put('L', 50);
        letterToNumber.put('C', 100);
        letterToNumber.put('D', 500);
        letterToNumber.put('M', 1000);
        return letterToNumber;
    }
}