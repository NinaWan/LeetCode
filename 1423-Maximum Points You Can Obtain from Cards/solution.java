class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int result = 0;
        int sum = 0;

        int left = 0;
        int right = left + cardPoints.length - k;

        // initialize sum
        for (int i = right; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }

        result = sum;

        // moving window
        while (left < right && right < cardPoints.length) {

            sum -= cardPoints[right];
            sum += cardPoints[left];
            result = Math.max(result, sum);

            right++;
            left++;
        }

        return result;
    }
}