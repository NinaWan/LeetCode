class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n = arr.length;
        int ans = Math.abs(arr[n - 1] - target);
        List<Set<Integer>> dp = new ArrayList();
        dp.add(new HashSet(Arrays.asList(arr[n - 1])));

        for (int i = n - 2; i >= 0; i--) {
            Set<Integer> set = new HashSet();
            set.add(arr[i]);
            ans = Math.min(ans, Math.abs(arr[i] - target));
            for (int value : dp.get(dp.size() - 1)) {
                int curr = arr[i] & value;
                set.add(curr);
                ans = Math.min(ans, Math.abs(curr - target));
            }

            dp.add(set);
        }

        return ans;
    }
}