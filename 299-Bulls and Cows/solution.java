class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> freq = new HashMap();
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            char sec = secret.charAt(i);
            if (sec == guess.charAt(i)) {
                bull++;
            } else {
                freq.put(sec, freq.getOrDefault(sec, 0) + 1);
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            char gue = guess.charAt(i);
            if (gue != secret.charAt(i) && freq.getOrDefault(gue, 0) != 0) {
                cow++;
                freq.put(gue, freq.get(gue) - 1);
            }
        }

        return bull + "A" + cow + "B";
    }
}