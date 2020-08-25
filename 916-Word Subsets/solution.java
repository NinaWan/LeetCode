class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList();

        int[] bmax = new int[26];
        for (String b : B) {
            int[] bcount = new int[26];
            for (char c : b.toCharArray()) {
                bcount[c - 'a']++;
                bmax[c - 'a'] = Math.max(bmax[c - 'a'], bcount[c - 'a']);
            }
        }

        for (String a : A) {
            int[] acount = new int[26];
            for (char c : a.toCharArray()) {
                acount[c - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (bmax[i] > acount[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(a);
            }
        }

        return result;
    }
}