class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int curr = 0;
        int left = 0;
        int right = 0;

        for (int i = 0, j = 0; j < seats.length; j++) {
            if (seats[j] == 0) {
                if (i == 0 || j == seats.length - 1) {
                    max = Math.max(max, j - i + 1);
                }

                max = Math.max(max, (j - i + 1) / 2 + (j - i + 1) % 2);
            } else {
                i = j + 1;
            }
        }

        return max;
    }
}