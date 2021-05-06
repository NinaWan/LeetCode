class Solution {
    public int[] movesToStamp(String stamp, String target) {
        Set<Integer> set = new LinkedHashSet();
        char[] s = stamp.toCharArray();
        char[] t = target.toCharArray();
        int count = 0;

        while (count < t.length) {
            boolean isPossible = false;
            for (int i = 0; i <= t.length - s.length; i++) {
                if (!set.contains(i) && canRemoveStamp(i, t, s)) {
                    isPossible = true;
                    set.add(i);
                    count += removeStamp(i, t, s.length);
                }

                if (count == t.length) {
                    break;
                }
            }

            if (!isPossible) {
                return new int[0];
            }
        }

        int[] ans = new int[set.size()];
        int i = ans.length - 1;
        for (Integer pos : set) {
            ans[i] = pos;
            i--;
        }

        return ans;
    }

    private boolean canRemoveStamp(int start, char[] t, char[] s) {
        for (int i = 0; i < s.length; i++) {
            if (t[i + start] != '?' && t[i + start] != s[i]) {
                return false;
            }
        }

        return true;
    }

    private int removeStamp(int start, char[] t, int l) {
        int count = 0;

        for (int i = 0; i < l; i++) {
            if (t[i + start] != '?') {
                t[i + start] = '?';
                count++;
            }
        }

        return count;
    }
}