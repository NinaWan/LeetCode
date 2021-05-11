class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int n = rooms.length, m = queries.length;
        Integer[] queryIdxes = new Integer[m];
        for (int i = 0; i < m; i++) {
            queryIdxes[i] = i;
        }

        Arrays.sort(rooms, (a, b) -> b[1] - a[1]);// sort rooms by descending order of room size
        Arrays.sort(queryIdxes, (i, j) -> queries[j][1] - queries[i][1]);// sort queryIdxes by descending order of minSize of queries

        TreeSet<Integer> roomIds = new TreeSet();
        int p = 0;
        int[] ans = new int[m];
        for (int i : queryIdxes) {// for each query
            while (p < n && rooms[p][1] >= queries[i][1]) {
                roomIds.add(rooms[p++][0]);
            }

            ans[i] = findClosest(roomIds, queries[i][0]);
        }

        return ans;
    }

    private int findClosest(TreeSet<Integer> roomIds, int preferred) {
        Integer floor = roomIds.floor(preferred);
        Integer ceiling = roomIds.ceiling(preferred);

        if (floor != null && ceiling != null) {
            return preferred - floor <= ceiling - preferred ? floor
                                                            : ceiling;
        } else if (floor != null) {
            return floor;
        } else if (ceiling != null) {
            return ceiling;
        }

        return -1;
    }
}