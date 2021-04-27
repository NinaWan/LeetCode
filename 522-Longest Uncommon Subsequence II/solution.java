class Solution {
    public int findLUSlength(String[] strs) {
        int ans = -1;
        Map<String, Integer> freq = new HashMap();

        for (String str : strs) {
            freq.put(str, freq.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList(freq.keySet());

        Collections.sort(list, (String a, String b) -> {
            return b.length() - a.length();
        });

        for (String s : list) {
            if (freq.get(s) == 1) {
                boolean isSub = false;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals(s)) {
                        break;
                    }

                    if (isSubsequenceOf(s, list.get(i))) {
                        isSub = true;
                        break;
                    }
                }

                if (!isSub) {
                    ans = s.length();
                    break;
                }
            }
        }

        return ans;
    }

    private boolean isSubsequenceOf(String a, String b) {
        int i = 0, j = 0;

        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == a.length() ? true
                               : false;
    }
}