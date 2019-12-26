class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int[] result = new int[deck.length];
        Queue<Integer> indexQueue = new LinkedList();
        Arrays.sort(deck);

        for (int i = 0; i < deck.length; i++) {
            indexQueue.offer(i);
        }

        int index = 0;
        while (!indexQueue.isEmpty()) {
            result[indexQueue.poll()] = deck[index];
            index++;
            if (indexQueue.isEmpty()) {
                break;
            }
            indexQueue.offer(indexQueue.poll());
        }

        return result;
    }
}