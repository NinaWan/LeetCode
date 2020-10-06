class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);

            if (c == '(') {
                depth++;
            }
            ans[i] = depth % 2;
            if (c == ')') {
                depth--;
            }
        }

        return ans;
    }
}