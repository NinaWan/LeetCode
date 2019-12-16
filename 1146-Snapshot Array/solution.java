class SnapshotArray {
    private int nextSnapId = 0;
    private List<Integer>[] snapshots;

    public SnapshotArray(int length) {
        snapshots = new List[length];
        for (int i = 0; i < length; i++) {
            snapshots[i] = new ArrayList();
            snapshots[i].add(0);
        }
    }

    public void set(int index, int val) {
        List<Integer> numSnapshots = snapshots[index];
        int complement = numSnapshots.get(numSnapshots.size() - 1);
        for (int i = numSnapshots.size() - 1; i < nextSnapId; i++) {//
            numSnapshots.add(complement);
        }
        numSnapshots.set(numSnapshots.size() - 1, val);
    }

    public int snap() {
        return nextSnapId++;
    }

    public int get(int index, int snap_id) {
        return snapshots[index].get(Math.min(snapshots[index].size() - 1, snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */