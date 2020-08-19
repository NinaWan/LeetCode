class Solution {
    public int maxPower(String s) {
        int result = 0;
        int count = 0;
        char pre = '\0';

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (pre == curr) {
                count++;
            } else {
                pre = curr;
                count = 1;
            }
            result = Math.max(result, count);
        }

        return result;
    }
}