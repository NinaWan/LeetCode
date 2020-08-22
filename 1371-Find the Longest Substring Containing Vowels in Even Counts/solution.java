class Solution {
    public int findTheLongestSubstring(String s) {
        int result = 0;
        Map<Integer, Integer> masks = new HashMap(); // <mask, first occurrence position>
        masks.put(0, -1);
        int mask = 0;

        for (int i = 0; i < s.length(); i++) {
            int p = "aeiou".indexOf(s.charAt(i));
            if (p != -1) {
                mask = mask ^ (1 << p);
            }

            masks.putIfAbsent(mask, i);
            result = Math.max(result, i - masks.get(mask));
        }

        return result;
    }
}