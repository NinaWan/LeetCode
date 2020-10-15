class Solution {
    public boolean isTransformable(String s, String t) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            PriorityQueue<Integer> queue = map.getOrDefault(digit, new PriorityQueue());
            queue.offer(i);
            map.put(digit, queue);
        }

        for (char c : t.toCharArray()) {
            int digit = c - '0';
            PriorityQueue<Integer> idxes = map.get(digit);
            if (idxes == null || idxes.size() == 0) {
                return false;
            }

            int idx = idxes.poll();
            for (int n = 0; n < digit; n++) {
                PriorityQueue<Integer> nidxes = map.get(n);
                if (nidxes != null && nidxes.size() != 0 && nidxes.peek() < idx) {
                    return false;
                }
            }
        }

        return true;
    }
}