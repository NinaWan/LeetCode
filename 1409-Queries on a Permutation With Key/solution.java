class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        List<Integer> P = new ArrayList();

        for (int i = 1; i <= m; i++) {
            P.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < P.size(); j++) {
                if (P.get(j) == queries[i]) {
                    result[i] = j;
                    P.remove(j);
                    P.add(0, queries[i]);
                    break;
                }
            }
        }

        return result;
    }
}