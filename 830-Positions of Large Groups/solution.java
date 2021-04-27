class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList();

        for (int i = 0; i < S.length();) {
            int start = i;
            while (i < S.length() && S.charAt(i) == S.charAt(start)) {
                i++;
            }

            if (i - start >= 3) {
                result.add(Arrays.asList(start, i - 1));
            }
        }

        return result;
    }
}