class Solution {
    public String rankTeams(String[] votes) {
        String result = "";
        int sl = votes[0].length();
        Map<Character, int[]> map = new HashMap();
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < sl; j++) {
                char v = votes[i].charAt(j);
                int[] rank = map.getOrDefault(v, new int[sl]);
                rank[j]++;
                map.put(v, rank);
            }
        }

        List<Character> teams = new ArrayList(map.keySet());
        Collections.sort(teams, (a, b) -> {
            for (int i = 0; i < sl; i++) {
                if (map.get(a)[i] != map.get(b)[i]) {
                    return map.get(b)[i] - map.get(a)[i];
                }
            }

            return a - b;
        });

        for (Character t : teams) {
            result += t;
        }

        return result;
    }
}