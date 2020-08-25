class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int result = 0;

        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        while (left < text.length()) {
            char c = text.charAt(left);
            int count = 0;
            int count1 = 0;
            int count2 = 0;

            while (right < text.length() && text.charAt(right) == c) {
                count1++;
                right++;
            }

            count = count1;

            if (count1 < freq[c - 'a']) {//if still has same character left
                int p = right + 1;
                while (p < text.length() && text.charAt(p) != c) {
                    p++;
                }
                while (p < text.length() && text.charAt(p) == c) {
                    count2++;
                    p++;
                }

                if (count2 == 0) {// there is no block 2 after block 1
                    count = count1 + 1;
                } else if (text.charAt(right + 1) == c) {// there is only one other character between two blocks
                    count = count1 + count2;
                    if (count1 + count2 < freq[c - 'a']) {
                        count += 1;
                    }
                } else {// there are more than one other characters between two blocks
                    count = Math.max(count1, count2) + 1;
                }
            }

            result = Math.max(result, count);
            left = right;
        }

        return result;
    }
}