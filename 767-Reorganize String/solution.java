class Solution {
    public String reorganizeString(String S) {
        String ans = "";
        Map<Character, Integer> freq = new HashMap();
        int n = S.length();

        for (char c : S.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            int th = n % 2 == 0 ? n / 2 : n / 2 + 1;
            if (freq.get(c) > th) {
                return "";
            }
        }

        PriorityQueue<Character> queue = new PriorityQueue((a, b) -> {
            return freq.get(b) - freq.get(a);
        });

        for (Character c : freq.keySet()) {
            queue.add(c);
        }

        while (!queue.isEmpty()) {
            Character c1 = queue.poll();
            Character c2 = null;
            ans += Character.toString(c1);
            freq.put(c1, freq.get(c1) - 1);

            if (!queue.isEmpty()) {
                c2 = queue.poll();
                ans += Character.toString(c2);
                freq.put(c2, freq.get(c2) - 1);
            }

            if (freq.get(c1) != 0) {
                queue.add(c1);
            }

            if (c2 != null && freq.get(c2) != 0) {
                queue.add(c2);
            }
        }

        return ans;
    }
}