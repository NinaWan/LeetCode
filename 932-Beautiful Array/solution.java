class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> ans = new ArrayList();
        ans.add(1);
        while (ans.size() < n) {
            List<Integer> tmp = new ArrayList();
            for (int num : ans) {// construct odd beautiful array
                if (2 * num - 1 <= n) {
                    tmp.add(2 * num - 1);
                }
            }
            for (int num : ans) {// construct even beautiful array
                if (2 * num <= n) {
                    tmp.add(2 * num);
                }
            }
            ans = tmp;
        }

        return ans.stream().mapToInt(num -> num).toArray();
    }
}