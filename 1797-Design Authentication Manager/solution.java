class AuthenticationManager {
    private int timeToLive;
    private Map<String, Long> expiry;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        expiry = new HashMap();
    }

    public void generate(String tokenId, int currentTime) {
        expiry.put(tokenId, Long.valueOf(currentTime + timeToLive));
    }

    public void renew(String tokenId, int currentTime) {
        if (expiry.containsKey(tokenId) && expiry.get(tokenId) > currentTime) {
            expiry.put(tokenId, Long.valueOf(currentTime + timeToLive));
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) expiry.values().stream().filter(t -> t > currentTime).count();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */