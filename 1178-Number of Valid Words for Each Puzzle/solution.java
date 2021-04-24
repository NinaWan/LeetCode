class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList();
        Map<Integer, Integer> freq = new HashMap();

        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }

        for (String puzzle : puzzles) {
            int mask = 0;
            for (char c : puzzle.toCharArray()) {
                mask |= 1 << (c - 'a');
            }

            int count = 0;
            int sub = mask, first = 1 << (puzzle.charAt(0) - 'a');
            while (true) {
                if (sub == 0) {
                    break;
                }

                if ((sub & first) == first && freq.containsKey(sub)) {
                    count += freq.get(sub);
                }

                sub = (sub - 1) & mask;
            }

            ans.add(count);
        }

        return ans;
    }
}