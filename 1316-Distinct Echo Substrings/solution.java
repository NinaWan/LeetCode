class Solution {
    public int distinctEchoSubstrings(String text) {
        int n = text.length();
        Set<String> set = new HashSet();

        for (int l = 0; l < n; l++) {
            for (int k = 2; l + k <= n; k += 2) {
                String s1 = text.substring(l, l + k / 2);
                String s2 = text.substring(l + k / 2, l + k);
                if (s1.equals(s2)) {
                    set.add(s1);
                }
            }
        }

        return set.size();
    }
}