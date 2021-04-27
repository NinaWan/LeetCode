class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int giving = 1;

        while (candies > 0) {
            ans[(giving - 1) % num_people] += candies > giving ? giving
                                                               : candies;
            candies -= giving;
            giving++;
        }

        return ans;
    }
}