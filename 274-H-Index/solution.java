class Solution {
    public int hIndex(int[] citations) {
        int H = citations.length;

        Arrays.sort(citations);

        for (int i = 0; i < H; i++) {
            int h = H - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}