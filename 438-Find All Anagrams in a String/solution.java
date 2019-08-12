public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (null == s || s.length() == 0 || s.length() < p.length()) return result;

        Map<Character, Integer> pMap = new HashMap<Character, Integer>();
        // Construct hashmap
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), (pMap.get(p.charAt(i)) == null ? 0 : pMap.get(p.charAt(i))) + 1);
        }

        int left = 0;
        int right = -1;
        int count = pMap.keySet().size();

        while (right < s.length() - 1) {
            right += 1;
            if (pMap.containsKey(s.charAt(right))) {// If character exists in p
                pMap.put(s.charAt(right), pMap.get(s.charAt(right)) - 1);
                if (pMap.get(s.charAt(right)) == 0) {
                    count--;
                }
            }

            if (count == 0) {
                result.add(left);
            }

            if (right - left + 1 == p.length()) {
                if (pMap.containsKey(s.charAt(left))) {// If character exists in p
                    if (pMap.get(s.charAt(left)) == 0) {
                        count++;
                    }
                    pMap.put(s.charAt(left), pMap.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        return result;
    }
}