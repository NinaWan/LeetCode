class Solution {
    public int minStickers(String[] stickers, String target) {
        Map<String, Integer> dp = new HashMap();
        dp.put("", 0);
        int[][] freqs = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                freqs[i][c - 'a']++;
            }
        }

        return minStickers(freqs, target, dp);
    }

    private int minStickers(int[][] freqs, String target, Map<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int[] tarFreq = new int[26];
        for (char c : target.toCharArray()) {
            tarFreq[c - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < freqs.length; i++) {// for each sticker
            if (freqs[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 26; j++) {// for each letter
                if (tarFreq[j] - freqs[i][j] > 0) {
                    for (int k = 0; k < tarFreq[j] - freqs[i][j]; k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }

            int next = minStickers(freqs, sb.toString(), dp);
            if (next != -1) {
                ans = Math.min(ans, next + 1);
            }
        }

        dp.put(target, ans == Integer.MAX_VALUE ? -1
                                                : ans);
        return dp.get(target);
    }
}