class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        String result = "";
        int curr = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            curr = (shifts[i] + curr) % 26;
            char c = S.charAt(i);
            if (c + curr > 'z') {
                result = (char) ('a' + curr - 'z' + c - 1) + result;
            } else {
                result = (char) (c + curr) + result;
            }
        }

        return result;
    }
}