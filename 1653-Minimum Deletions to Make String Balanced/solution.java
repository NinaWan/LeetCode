class Solution {
    public int minimumDeletions(String s) {
        int ans = 0, countb = 0, pre = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {// just append b, no need for deletion
                countb++;
            } else {
                // case 1: keep current a, remove all previous b's
                // case 2: remove current a, one more deletion
                ans = Math.min(countb, pre + 1);
                pre = ans;
            }
        }

        return ans;
    }
}