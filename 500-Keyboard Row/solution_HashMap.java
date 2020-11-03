class Solution {
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList();
        Map<Integer, Set<Character>> map = new HashMap() {
            {
                put(1, new HashSet(Arrays.asList('Q', 'q', 'W', 'w', 'E', 'e', 'R', 'r', 'T', 't', 'Y', 'y', 'U', 'u', 'I', 'i', 'O', 'o', 'P',
                        'p')));
                put(2, new HashSet(Arrays.asList('A', 'a', 'S', 's', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h', 'J', 'j', 'K', 'k', 'L', 'l')));
                put(3, new HashSet(Arrays.asList('Z', 'z', 'X', 'x', 'C', 'c', 'V', 'v', 'B', 'b', 'N', 'n', 'M', 'm')));
            }
        };

        for (String word : words) {
            if (word == null || word.equals("")) {
                continue;
            }

            int row = 0;
            for (int i = 1; i < 4; i++) {
                if (map.get(i).contains(word.charAt(0))) {
                    row = i;
                    break;
                }
            }

            boolean inOneRow = true;
            for (char c : word.toCharArray()) {
                if (!map.get(row).contains(c)) {
                    inOneRow = false;
                    break;
                }
            }

            if (inOneRow) {
                list.add(word);
            }
        }

        return list.toArray(new String[list.size()]);
    }
}