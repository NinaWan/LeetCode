class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> seen = new HashSet();
        int ans = 0;

        for (int a : A) {
            if (seen.contains(a)) {
                ans = a;
                break;
            }
            seen.add(a);
        }

        return ans;
    }
}