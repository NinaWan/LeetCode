class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int ans = 0;
        List<Integer> list = new ArrayList();

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                list.add(i);
            }
        }

        if (S == 0 && list.size() == 0) {
            return A.length * (A.length - 1) / 2 + A.length;
        }

        if (S == 0) {
            int n = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    n = list.get(i);
                } else {
                    n = list.get(i) - list.get(i - 1) - 1;
                }

                ans += n + n * (n - 1) / 2;
            }

            n = A.length - 1 - list.get(list.size() - 1);
            ans += n + n * (n - 1) / 2;
        } else {
            int left = 0, right = 0;
            int sum = 1;
            while (right < list.size()) {
                if (sum == S) {
                    int a = left == 0 ? list.get(left) + 1
                                      : list.get(left) - list.get(left - 1);
                    int b = right == list.size() - 1 ? A.length - list.get(right)
                                                     : list.get(right + 1) - list.get(right);
                    ans += a * b;
                    right++;
                    sum++;
                } else if (sum < S) {
                    sum++;
                    right++;
                } else {
                    left++;
                    sum--;
                }
            }
        }

        return ans;
    }
}