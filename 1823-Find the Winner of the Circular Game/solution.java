class Solution {
    public int findTheWinner(int n, int k) {
        int[] circle = new int[n];
        int left = n, p = 0;

        while (left > 1) {
            for (int i = 0; i < k;) {
                if (circle[p % n] == 0) {
                    i++;
                    if (i == k) {
                        circle[p % n] = 1;
                    }
                }

                p++;
            }

            left--;
        }

        for (int i = 0; i < circle.length; i++) {
            if (circle[i] == 0) {
                return i + 1;
            }
        }

        return 1;
    }
}