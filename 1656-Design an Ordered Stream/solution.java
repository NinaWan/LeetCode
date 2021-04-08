class OrderedStream {
    private String[] stream;
    private int ptr = 1;

    public OrderedStream(int n) {
        this.stream = new String[n + 1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> ans = new ArrayList();
        stream[idKey] = value;

        while (ptr < stream.length && stream[ptr] != null) {
            ans.add(stream[ptr]);
            ptr++;
        }

        return ans;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */