class Solution {
    public int rotatedDigits(int N) {
        int ans = 0;
        Set<Integer> mirrorSet = new HashSet(Arrays.asList(2, 5, 6, 9));
        Set<Integer> invalidSet = new HashSet(Arrays.asList(3, 4, 7));

        for (int i = 1; i <= N; i++) {
            int num = i;
            int mod = num % 10;
            boolean isValid = false;
            while (num != 0) {
                if (invalidSet.contains(mod)) {
                    isValid = false;
                    break;
                }

                if (mirrorSet.contains(mod)) {
                    isValid = true;
                }

                num = num / 10;
                mod = num % 10;
            }

            if (isValid) {
                ans++;
            }
        }

        return ans;
    }
}