class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ans = new int[2];

        int aSum = 0;
        int bSum = 0;
        Set<Integer> bSet = new HashSet();
        for (int a : A) {
            aSum += a;
        }

        for (int b : B) {
            bSum += b;
            bSet.add(b);
        }

        for (int a : A) {
            int expected = a + (bSum - aSum) / 2;
            if (bSet.contains(expected)) {
                ans[0] = a;
                ans[1] = expected;
                break;
            }
        }

        return ans;
    }
}