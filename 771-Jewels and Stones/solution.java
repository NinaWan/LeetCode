class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> jewels = new HashSet();

        for (char c : J.toCharArray()) {
            jewels.add(c);
        }

        for (char c : S.toCharArray()) {
            if (jewels.contains(c)) {
                ans++;
            }
        }

        return ans;
    }
}