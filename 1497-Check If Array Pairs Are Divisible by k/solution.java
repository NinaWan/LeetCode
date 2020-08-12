class Solution {
    public boolean canArrange(int[] arr, int k) {
        if (k == 1) {
            return true;
        }

        Map<Integer, Integer> freq = new HashMap();
        for (int num : arr) {
            int mod = (num % k + k) % k; // include handling negative number
            freq.put(mod, freq.getOrDefault(mod, 0) + 1);
        }

        for (int i = 0; i < k; i++) {
            if (freq.get(i) == null) {
                continue;
            }

            if (i == 0 && freq.get(0) % 2 != 0) {
                return false;
            }

            if (i == k - i && freq.get(i) % 2 != 0) {
                return false;
            }

            if (i != 0 && !freq.get(i).equals(freq.get(k - i))) {
                return false;
            }
        }

        return true;
    }
}