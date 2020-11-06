class Solution {
    public String longestDupSubstring(String S) {
        String ans = "";
        int left = 0, right = S.length() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            String dup = findDuplicateSubstring(S, mid + 1);
            if (dup.equals("")) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = dup;
            }
        }

        return ans;
    }

    private String findDuplicateSubstring(String S, int len) {// Rolling Hash
        long P = 1 << 61 - 1;// a big prime number
        long base = 26;
        Map<Long, List<Integer>> map = new HashMap();

        long hash = 0;
        for (int i = 0; i < len; i++) {
            hash = (S.charAt(i) + base * hash) % P;
        }
        map.put(hash, new ArrayList(Arrays.asList(0)));

        long a = 1;
        for (int i = 0; i < len; i++) {
            a = (a * base) % P;
        }

        for (int j = len; j < S.length(); j++) {
            hash = (S.charAt(j) + base * hash - a * S.charAt(j - len)) % P;

            List<Integer> idxes = map.getOrDefault(hash, new ArrayList());
            String target = S.substring(j - len + 1, j + 1);

            for (Integer idx : idxes) {
                if (target.equals(S.substring(idx, idx + len))) {
                    return target;
                }
            }

            idxes.add(j - len + 1);
            map.put(hash, idxes);
        }

        return "";
    }
}