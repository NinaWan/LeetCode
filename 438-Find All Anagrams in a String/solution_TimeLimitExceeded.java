public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() == 0 || s.length() < p.length()) return result;
        if (s.equals(p)) {
            result.add(0);
            return result;
        }

        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String sub = s.substring(i, i + p.length());
            if (isAnagramOf(sub, p)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagramOf(String s, String p) {
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> pMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        if (sMap.size() != pMap.size()) return false;
        Iterator<Map.Entry<Character, Integer>> iterP = pMap.entrySet().iterator();
        while (iterP.hasNext()) {
            Map.Entry<Character, Integer> entryP = iterP.next();
            int pValue = entryP.getValue();
            if (pValue != (int) sMap.getOrDefault(entryP.getKey(), -1)) return false;
        }
        return true;
    }
}