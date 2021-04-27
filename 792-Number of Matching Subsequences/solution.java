class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;

        List<Integer>[] charIndexes = new List[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (charIndexes[chars[i] - 'a'] == null) {
                charIndexes[chars[i] - 'a'] = new ArrayList();
            }
            charIndexes[chars[i] - 'a'].add(i);
        }

        for (String word : words) {
            char[] letters = word.toCharArray();
            int i = 0;
            int preIndex = 0;
            for (; i < letters.length; i++) {
                if (charIndexes[letters[i] - 'a'] == null) {
                    break;
                }

                List<Integer> currIndexes = charIndexes[letters[i] - 'a'];

                if (i == 0) {
                    preIndex = currIndexes.get(0);
                } else {
                    if (currIndexes.get(currIndexes.size() - 1) <= preIndex) {
                        break;
                    }

                    int start = 0, end = currIndexes.size() - 1;
                    while (start < end) {
                        int mid = start + (end - start) / 2;
                        if (currIndexes.get(mid) > preIndex) {
                            end = mid;
                        } else {
                            start = mid + 1;
                        }
                    }

                    preIndex = currIndexes.get(start);
                }
            }

            result += i == letters.length ? 1
                                          : 0;
        }

        return result;
    }
}