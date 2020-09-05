class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);

        for (int left = 0, right = people.length - 1; left <= right; right--) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            ans++;
        }

        return ans;
    }
}