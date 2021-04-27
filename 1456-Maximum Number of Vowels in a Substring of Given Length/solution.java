class Solution {
    public int maxVowels(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int result = 0;
        int[] counts = new int[s.length()];
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (int i = 0; i < k; i++) {
            Character c = s.charAt(i);
            if (i == 0) {
                counts[i] = vowels.contains(c) ? 1
                                               : 0;
            } else if (vowels.contains(c)) {
                counts[i] = counts[i - 1] + 1;
            } else {
                counts[i] = counts[i - 1];
            }

            result = Math.max(result, counts[i]);
        }

        for (int i = k; i < s.length(); i++) {
            Character c = s.charAt(i);
            counts[i] = counts[i - 1];

            if (vowels.contains(c)) {
                counts[i] += 1;
            }

            if (vowels.contains(s.charAt(i - k))) {
                counts[i] -= 1;
            }

            result = Math.max(result, counts[i]);
        }

        return result;
    }
}