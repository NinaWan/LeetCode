class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        if (null != secret && null != guess) {
            int l = secret.length();
            Map<String, Integer> sMapping = new HashMap<>();
            Map<String, Integer> gMapping = new HashMap<>();
            Map<String, Integer> bMapping = new HashMap<>();

            for (int i = 0; i < l; i++) {
                String s = String.valueOf(secret.charAt(i));
                String g = String.valueOf(guess.charAt(i));

                if (secret.charAt(i) == guess.charAt(i)) {
                    bulls++;
                    bMapping.put(s, bMapping.getOrDefault(s, 0) + 1);
                }

                sMapping.put(s, sMapping.getOrDefault(s, 0) + 1);
                gMapping.put(g, gMapping.getOrDefault(g, 0) + 1);
            }

            for (Map.Entry current : gMapping.entrySet()) {
                int sNum = sMapping.getOrDefault(current.getKey(), 0);
                int gNum = (Integer) current.getValue();
                int bNum = bMapping.getOrDefault(current.getKey(), 0);

                if (sNum == 0) {
                    continue;
                }

                cows += Math.min(sNum, gNum) - bNum;
            }
        }

        return bulls + "A" + cows + "B";
    }
}