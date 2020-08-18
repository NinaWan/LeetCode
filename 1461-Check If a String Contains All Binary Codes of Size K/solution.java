class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int need = 1 << k; // 2^k
        Set<String> set = new HashSet();

        for (int i = k - 1; i < s.length(); i++) {
            String ss = s.substring(i - k + 1, i + 1);

            if (!set.contains(ss)) {
                set.add(ss);
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}