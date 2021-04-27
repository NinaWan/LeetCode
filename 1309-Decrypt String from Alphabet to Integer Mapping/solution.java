class Solution {
    public String freqAlphabets(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '#') {
                result = result.substring(0, result.length() - 2);
                result += String
                        .valueOf((char) (Character.getNumericValue(s.charAt(i - 2)) * 10 + Character.getNumericValue(s.charAt(i - 1)) + 'a' - 1));
            } else {
                result += String.valueOf((char) (Character.getNumericValue(s.charAt(i)) + 'a' - 1));
            }
        }

        return result;
    }
}