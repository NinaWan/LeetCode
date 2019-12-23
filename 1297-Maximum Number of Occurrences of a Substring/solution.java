class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int result = 0;
        char[] chars = s.toCharArray();

        for (int size = minSize; size <= maxSize; size++) {
            int left = 0;
            int right = 0;
            int[] counts = new int[26];
            int uniqueCount = 0;
            Map<String, Integer> subStringCounts = new HashMap();

            while (right - left < size) {
                if (counts[chars[right] - 'a'] == 0) {
                    uniqueCount++;
                }
                counts[chars[right] - 'a']++;
                right++;
            }

            if (uniqueCount <= maxLetters) {
                String subString = s.substring(left, right);
                int updatedCount = subStringCounts.getOrDefault(subString, 0) + 1;
                subStringCounts.put(subString, updatedCount);
                result = Math.max(result, updatedCount);
            }

            right--;

            while (right < chars.length - 1) {
                right++;

                if (counts[chars[right] - 'a'] == 0) {
                    uniqueCount++;
                }
                counts[chars[right] - 'a']++;

                if (counts[chars[left] - 'a'] == 1) {
                    uniqueCount--;
                }
                counts[chars[left] - 'a']--;
                left++;

                if (uniqueCount <= maxLetters) {
                    String subString = s.substring(left, right + 1);
                    int updatedCount = subStringCounts.getOrDefault(subString, 0) + 1;
                    subStringCounts.put(subString, updatedCount);
                    result = Math.max(result, updatedCount);
                }
            }
        }

        return result;
    }
}