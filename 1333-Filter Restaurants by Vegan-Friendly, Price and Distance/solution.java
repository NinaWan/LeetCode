class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList();
        Map<Integer, Set<Integer>> map = new TreeMap(Collections.reverseOrder());
        for (int i = 0; i < restaurants.length; i++) {
            if ((veganFriendly == 0 || restaurants[i][2] == 1) && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                int rating = restaurants[i][1];
                Set<Integer> ids = map.getOrDefault(rating, new TreeSet(Collections.reverseOrder()));
                ids.add(restaurants[i][0]);
                map.put(rating, ids);
            }
        }

        for (Set<Integer> ids : map.values()) {
            result.addAll(ids);
        }

        return result;
    }
}