public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Assume s and t always have same length
        Map<Character, Character> sTot = new HashMap<Character, Character>();
        Set<Character> tSet = new HashSet<Character>();

        for (int i = 0; i < t.length(); i++) {
            if (sTot.get(s.charAt(i)) == null) {
                if (tSet.contains(t.charAt(i))) return false;
                sTot.put(s.charAt(i), t.charAt(i));
                tSet.add(t.charAt(i));
            } else {
                if (sTot.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }
}