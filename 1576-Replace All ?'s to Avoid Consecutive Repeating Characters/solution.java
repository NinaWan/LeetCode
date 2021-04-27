class Solution {
    public String modifyString(String s) {
        if (s.length() == 1) {
            return "a";
        }

        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if ((i == 0 && c != letters[i + 1]) || (i == letters.length - 1 && c != letters[i - 1]) ||
                            (i > 0 && i < letters.length - 1 && c != letters[i - 1] && c != letters[i + 1])) {
                        letters[i] = c;
                        break;
                    }
                }
            }
        }

        return new String(letters);
    }
}