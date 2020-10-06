class TopVotedCandidate {
    TreeMap<Integer, Integer> voteMap;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.voteMap = new TreeMap();
        int mostVoted = persons[0];
        this.voteMap.put(times[0], mostVoted);

        Map<Integer, Integer> freq = new HashMap();
        freq.put(persons[0], 1);

        for (int i = 1; i < persons.length; i++) {
            int currFreq = freq.getOrDefault(persons[i], 0) + 1;
            freq.put(persons[i], currFreq);
            if (persons[i] != mostVoted && currFreq >= freq.get(mostVoted)) {
                mostVoted = persons[i];
            }
            this.voteMap.put(times[i], mostVoted);
        }
    }

    public int q(int t) {
        return this.voteMap.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */