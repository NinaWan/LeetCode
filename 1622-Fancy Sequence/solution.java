class Fancy {
    private int mod = (int) 1e9 + 7;
    private List<Integer> sequence;
    private long mul;
    private long add;
    private long rmul;

    public Fancy() {
        this.sequence = new ArrayList();
        this.mul = 1;
        this.rmul = 1;
        this.add = 0;
    }

    public void append(int val) {
        // newval-=increment, then newval/=mult. But as these are in modulo arthematic, the division changes to newval *=
        // moduloInverse(mult)
        sequence.add((int) (((mod - add + val) * rmul) % mod));
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        // rmul = (rmul * BigInteger.valueOf(m).modInverse(BigInteger.valueOf(mod)).intValue()) % mod;
        rmul = BigInteger.valueOf(mul).modInverse(BigInteger.valueOf(mod)).intValue() % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {
        if (sequence.size() <= idx) {
            return -1;
        }

        return (int) (((sequence.get(idx) * mul) + add) % mod);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */