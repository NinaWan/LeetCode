class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        char[] result = Arrays.copyOf(chars, chars.length);

        for (List<Integer> indexes : union(pairs, s.length())) {
            Queue<Character> q = getSortedChars(indexes, chars);
            for (int index : indexes) {
                result[index] = q.poll();
            }
        }

        return String.valueOf(result);
    }

    private Queue<Character> getSortedChars(List<Integer> indexes, char[] chars) {
        Queue q = new PriorityQueue();
        for (Integer index : indexes) {
            q.add(chars[index]);
        }
        return q;
    }

    private List<List<Integer>> union(List<List<Integer>> pairs, int length) {
        int[] chainedIndexes = new int[length];
        Map<Integer, List<Integer>> groupMap = new HashMap();

        for (int i = 0; i < length; i++) {
            chainedIndexes[i] = i;
        }

        for (List<Integer> pair : pairs) {
            union(chainedIndexes, pair);
        }

        for (int i = 0; i < length; i++) {
            int key = findNext(chainedIndexes, i);
            if (!groupMap.containsKey(key)) {
                groupMap.put(key, new ArrayList());
            }
            groupMap.get(key).add(i);
        }

        return groupMap.values().stream().collect(Collectors.toList());
    }

    private void union(int[] chainedIndexes, List<Integer> pair) {
        int nextPos1 = findNext(chainedIndexes, pair.get(0));
        int nextPos2 = findNext(chainedIndexes, pair.get(1));

        if (nextPos1 != nextPos2) {
            chainedIndexes[nextPos1] = nextPos2;
        }
    }

    private int findNext(int[] chainedIndexes, int target) {
        if (chainedIndexes[target] == target) {
            return target;
        }

        return chainedIndexes[target] = findNext(chainedIndexes, chainedIndexes[target]);
    }
}