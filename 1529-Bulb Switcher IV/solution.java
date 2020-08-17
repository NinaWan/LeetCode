class Solution {
    public int minFlips(String target) {
        int result = 0;

        for (int i = 0; i < target.length(); i++) {
            if ((result % 2 == 0 && target.charAt(i) == '0') || (result % 2 == 1 && target.charAt(i) == '1')) {
                continue;
            } else {
                result++;
            }
        }

        return result;
    }
}