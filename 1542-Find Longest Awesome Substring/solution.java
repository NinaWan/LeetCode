class Solution {
    public int longestAwesome(String s) {
        int[] firstOccur = new int[1024];
        int currMask = 0;// 10 digits to represent if the count for 0~9 respectively is odd(1) or even(0)
        Arrays.fill(firstOccur, s.length());
        firstOccur[0] = -1;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            currMask ^= 1 << (s.charAt(i) - '0');

            // all numbers appear even times
            result = Math.max(result, i - firstOccur[currMask]); // range of subString is [firstOccur[currMask]+1, i]

            // all numbers except one appear even times
            for (int j = 0; j < 10; j++) {// for all possible numbers
                result = Math.max(result, i - firstOccur[currMask ^ (1 << j)]); // range of subString is [min(firstOccur[mask^1<<j])+1, i]
            }

            firstOccur[currMask] = Math.min(firstOccur[currMask], i);
        }

        return result;
    }
}