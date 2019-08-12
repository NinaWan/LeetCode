public class Solution {
    public int distributeCandies(int[] candies) {
        if (null == candies || candies.length == 0) return 0;

        Set<Integer> kindCount = new HashSet<Integer>();
        for (int candy : candies) {
            if (!kindCount.contains(candy)) {
                kindCount.add(candy);
            }
        }

        if (kindCount.size() * 2 <= candies.length) return kindCount.size();

        return kindCount.size() - (2 * kindCount.size() - candies.length) / 2;
    }
}