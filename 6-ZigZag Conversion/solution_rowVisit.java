class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        String result = "";

        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = i; j < s.length(); ) {
                    result += s.charAt(j);
                    j = j + 2 * (numRows - 1);
                }
            } else {
                for (int j = i; j < s.length(); ) {
                    result += s.charAt(j);
                    int next = 2 * (numRows - i - 1) + j;
                    if (next < s.length()) {
                        result += s.charAt(next);
                    }
                    j = j + 2 * (numRows - 1);
                }
            }
        }

        return result;
    }
}