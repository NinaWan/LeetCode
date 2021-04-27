class Solution {
    public int numFriendRequests(int[] ages) {
        int result = 0;

        // <age, count>
        Map<Integer, Integer> ageCounts = new TreeMap();
        for (int age : ages) {
            ageCounts.put(age, ageCounts.getOrDefault(age, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : ageCounts.entrySet()) {
            int currAge = entry.getKey();
            int currCount = entry.getValue();
            double floor = 0.5 * currAge + 7;

            if (floor < currAge) {
                result += currCount * (currCount - 1);

                for (Map.Entry<Integer, Integer> ageCount : ageCounts.entrySet()) {
                    if (ageCount.getKey() > floor && ageCount.getKey() < currAge) {
                        result += ageCount.getValue() * currCount;
                    }
                }
            }
        }

        return result;
    }
}