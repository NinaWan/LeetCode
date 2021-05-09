class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int ans = 0;
        for (String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                if (!allowedSet.contains(word.charAt(i))) {
                    break;
                }
            }

            if (i == word.length()) {
                ans++;
            }
        }

        return ans;
    }
}