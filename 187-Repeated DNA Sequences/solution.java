class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet();
        Set<String> seen = new HashSet();

        for (int i = 0; i < s.length() - 9; i++) {
            String curr = s.substring(i, i + 10);
            if (seen.contains(curr)) {
                ans.add(curr);
            } else {
                seen.add(curr);
            }
        }

        return new ArrayList(ans);
    }
}