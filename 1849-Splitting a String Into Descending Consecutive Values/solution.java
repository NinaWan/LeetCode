class Solution {
    public boolean splitString(String s) {
        return backtrack(0, s, new ArrayList());
    }

    private boolean backtrack(int start, String s, List<Long> res) {
        if (start >= s.length()) {
            return res.size() > 1;
        }

        long num = 0;
        for (int i = start; i < s.length(); i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (res.isEmpty() || res.get(res.size() - 1) - num == 1) {
                res.add(num);
                if (backtrack(i + 1, s, res)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }

        return false;
    }
}