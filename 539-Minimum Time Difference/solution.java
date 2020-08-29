class Solution {
    public int findMinDifference(List<String> timePoints) {
        int min = Integer.MAX_VALUE;

        Collections.sort(timePoints);
        String[] pre = timePoints.get(0).split(":");

        for (int i = 0; i < timePoints.size(); i++) {
            String[] curr = timePoints.get(i).split(":");
            if (i == 0) {
                pre = curr;
                curr = timePoints.get(timePoints.size() - 1).split(":");
            }

            int currM = 60 * Integer.valueOf(curr[0]) + Integer.valueOf(curr[1]);
            int preM = 60 * Integer.valueOf(pre[0]) + Integer.valueOf(pre[1]);
            int diff = Math.min(1440 - currM + preM, currM - preM);

            min = Math.min(min, diff);
            pre = i == 0 ? timePoints.get(0).split(":") : curr;
        }

        return min;
    }
}