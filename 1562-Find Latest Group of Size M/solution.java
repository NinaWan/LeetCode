class Solution {
    public int findLatestStep(int[] arr, int m) {
        int ans = -1;
        int[] length = new int[arr.length + 2];

        if (m == arr.length) {
            return arr.length;
        }

        for (int i = 0; i < arr.length; i++) {
            int currIdx = arr[i];
            int leftL = length[currIdx - 1], rightL = length[currIdx + 1];
            int currL = leftL + rightL + 1;
            length[currIdx - leftL] = currL;
            length[currIdx + rightL] = currL;

            if (leftL == m || rightL == m) {
                ans = i;
            }
        }

        return ans;
    }
}