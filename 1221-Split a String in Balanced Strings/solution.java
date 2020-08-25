class Solution {
    public int balancedStringSplit(String s) {
        int result = 0;
        int rCount = 0;
        int lCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'R') {
                rCount++;
            } else {
                lCount++;
            }

            if (rCount == lCount) {
                result++;
                rCount = 0;
                lCount = 0;
            }
        }

        return result;
    }
}