class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int current = 1;
        int remaining = candies;
        int index = 0;

        for (int i = 0; remaining > 0; i++, i %= num_people) {
            result[i] += Math.min(current, remaining);
            remaining -= current;
            current++;
        }

        return result;
    }
}