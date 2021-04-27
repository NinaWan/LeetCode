class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[] {-1, -1, -1, -1, -1};

        double sum = 0;
        int totalCount = 0;
        int maxCount = 0;
        for (int i = 0; i < count.length; i++) {
            sum += i * count[i];
            totalCount += count[i];
            if (count[i] != 0) {
                ans[1] = i;
                if (ans[0] == -1) {
                    ans[0] = i;
                }

                if (count[i] > maxCount) {
                    maxCount = count[i];
                    ans[4] = i;
                }
            }
        }
        ans[2] = sum / totalCount;

        int preCount = 0;
        int mid = totalCount % 2 == 0 ? totalCount / 2
                                      : totalCount / 2 + 1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                continue;
            }

            preCount += count[i];
            if (preCount >= mid) {
                if (totalCount % 2 == 1) {
                    ans[3] = i;
                } else if (preCount > mid) {
                    ans[3] = i;
                } else {
                    int j = i + 1;
                    while (count[j] == 0) {
                        j++;
                    }
                    ans[3] = (double) (i + j) / 2;
                }
                break;
            }
        }

        return ans;
    }
}