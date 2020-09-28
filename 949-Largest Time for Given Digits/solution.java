class Solution {
    public String largestTimeFromDigits(int[] arr) {
        String ans = "";

        int hh = 0, mm = 0, max = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    hh = 10 * arr[i] + arr[j];
                    mm = 10 * arr[k] + arr[6 - i - j - k];
                    int t = 60 * hh + mm;
                    if (t > max && hh < 24 && mm < 60) {
                        max = t;
                        ans = "" + arr[i] + arr[j] + ":" + arr[k] + arr[6 - i - j - k];
                    }
                }
            }
        }

        return ans;
    }
}