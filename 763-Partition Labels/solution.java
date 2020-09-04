class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList();
        int[][] range = new int[26][2];// first and last index in the string for each letter, 1-based

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (range[c - 'a'][0] == 0) {// first occurrence
                range[c - 'a'][0] = i + 1;
            }
            range[c - 'a'][1] = i + 1;// last occurrence
        }

        Arrays.sort(range, (int[] a, int[] b) -> {// sort by the first index ascending
            return a[0] - b[0];
        });

        int start = 0;
        int end = 0;
        for (int i = 0; i < 26; i++) {// merge intervals
            if (range[i][0] == 0) {
                continue;
            }

            if (start == 0) {
                start = range[i][0];
                end = range[i][1];
            } else if (end >= range[i][0]) {// merge interval
                end = Math.max(end, range[i][1]);
            } else {// not merge interval
                ans.add(end - start + 1);
                start = range[i][0];
                end = range[i][1];
            }

            if (i == 25) {
                ans.add(end - start + 1);
            }
        }

        return ans;
    }
}