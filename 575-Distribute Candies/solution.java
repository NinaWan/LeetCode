class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet();
        int n = candies.length / 2;

        for (int candy : candies) {
            set.add(candy);
        }

        return set.size() >= n ? n
                               : set.size();
    }
}