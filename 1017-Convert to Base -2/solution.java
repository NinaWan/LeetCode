class Solution {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }

        String ans = "";
        while (N != 0) {
            int remainder = N % (-2);
            N = N / (-2);
            if (remainder < 0) {
                remainder += 2;
                N += 1;
            }
            ans = remainder + ans;
        }

        return ans;
    }
}