class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> freq = new HashMap();
        Map<Integer, List<String>> map = new HashMap();
        int n = 0;

        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                n++;
            }

            if (c >= 'A' && c <= 'Z') {
                char lc = (char) (c - 'A' + 'a');
                freq.put(lc, freq.getOrDefault(lc, 0) + 1);
                n++;
            }
        }

        for (String word : words) {
            List<String> list = map.getOrDefault(word.length(), new ArrayList());
            list.add(word);
            map.put(word.length(), list);
        }

        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            if (entry.getKey() < n) {
                continue;
            }

            for (String word : entry.getValue()) {
                int[] count = new int[26];
                for (char c : word.toCharArray()) {
                    count[c - 'a']++;
                }

                boolean isValid = true;
                for (Map.Entry<Character, Integer> e : freq.entrySet()) {
                    if (count[e.getKey() - 'a'] < e.getValue()) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    return word;
                }
            }
        }

        return "";
    }
}