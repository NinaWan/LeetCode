class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Integer, TreeSet<Integer>> map = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char from = s.charAt(i);
            char to = t.charAt(i);

            if (from == to) {
                continue;
            }

            int key = to > from ? to - from : 26 - (from - to);

            if (key > k) {
                return false;
            }

            TreeSet<Integer> moves = map.getOrDefault(key, new TreeSet());

            if (moves.isEmpty()) {
                moves.add(key);
            } else {
                int move = moves.last() + 26;
                if (move > k) {
                    return false;
                } else {
                    moves.add(move);
                }
            }

            map.put(key, moves);
        }

        return true;
    }
}