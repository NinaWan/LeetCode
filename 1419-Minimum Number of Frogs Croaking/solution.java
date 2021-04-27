class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() < 5 || !croakOfFrogs.endsWith("k") || !croakOfFrogs.startsWith("c")) {
            return -1;
        }

        int result = 0;
        int frogs = 0;
        Map<Character, Integer> freq = new HashMap();

        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char curr = croakOfFrogs.charAt(i);
            freq.put(curr, freq.getOrDefault(curr, 0) + 1);

            if (curr == 'c') {
                frogs++;
            } else {
                char key = "croak".charAt("croak".indexOf(curr) - 1);
                int count = freq.get(key);
                if (count == 0) {
                    return -1;
                } else {
                    freq.put(key, count - 1);
                }

                if (curr == 'k') {
                    frogs--;
                }
            }

            result = Math.max(result, frogs);
        }

        return frogs == 0 ? result
                          : -1;
    }
}