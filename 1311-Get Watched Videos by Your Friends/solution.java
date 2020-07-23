class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> result = new ArrayList();
        Map<String, Integer> counter = new HashMap();
        Queue<Integer> queue = new LinkedList();
        queue.offer(id);
        int currLevel = 0;
        boolean[] isVisited = new boolean[friends.length];
        while (currLevel <= level) {
            if (queue.isEmpty()) {
                break;
            }

            int count = queue.size();
            while (count > 0) {
                int next = queue.poll();
                if (!isVisited[next]) {
                    if (currLevel == level) {
                        for (String v : watchedVideos.get(next)) {
                            counter.put(v, counter.getOrDefault(v, 0) + 1);
                        }
                    }

                    for (int friend : friends[next]) {
                        queue.offer(friend);
                    }
                }
                isVisited[next] = true;
                count--;
            }

            currLevel++;
        }

        Map<Integer, Set<String>> orderedCounter = new TreeMap();
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            Integer key = entry.getValue();
            if (!orderedCounter.containsKey(key)) {
                orderedCounter.put(key, new TreeSet());
            }

            orderedCounter.get(key).add(entry.getKey());
        }

        for (Map.Entry<Integer, Set<String>> entry : orderedCounter.entrySet()) {
            for (String s : entry.getValue()) {
                result.add(s);
            }
        }

        return result;
    }
}