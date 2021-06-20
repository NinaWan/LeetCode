class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();

        if (s.length() < p.length()) {
            return ans;
        }

        Map<Character, Integer> freqP = new HashMap();
        Map<Character, Integer> freqS = new HashMap();

        for (char c : p.toCharArray()) {
            freqP.put(c, freqP.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            while (i <= s.length() - p.length() && !freqP.containsKey(s.charAt(i))) {
                i++;
            }

            for (int j = i; j < i + p.length() && j < s.length(); j++) {
                char c = s.charAt(j);

                if (!freqP.containsKey(c)) {
                    i = j;
                    freqS.clear();
                    break;
                } else {
                    freqS.put(c, freqS.getOrDefault(c, 0) + 1);
                }
            }

            if (!freqS.isEmpty()) {
                boolean isValid = true;
                for (Map.Entry<Character, Integer> entry : freqP.entrySet()) {
                    if (!freqS.containsKey(entry.getKey()) || !freqS.get(entry.getKey()).equals(entry.getValue())) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    ans.add(i);
                }

                freqS.clear();
            }
        }

        return ans;
    }
}