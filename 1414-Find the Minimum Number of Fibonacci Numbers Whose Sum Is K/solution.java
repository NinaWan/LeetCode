class Solution {
    public int findMinFibonacciNumbers(int k) {
        int pre = 1;
        int curr = 1;
        int result = 0;
        TreeSet<Integer> ts = new TreeSet();

        while (curr <= k) {
            ts.add(curr);
            int temp = curr;
            curr = curr + pre;
            pre = temp;
        }

        while (k > 0) {
            k -= ts.floor(k);
            result++;
        }

        return result;
    }
}