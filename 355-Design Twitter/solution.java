import java.util.stream.Collectors;

class Twitter {
    private static int timestamp;
    private Map<Integer, User> users;

    /** Initialize your data structure here. */
    public Twitter() {
        this.timestamp = 0;
        this.users = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        user.getTweets().add(new Tweet(tweetId,
                                       timestamp++));
        this.users.put(userId, user);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who
     * the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            return new ArrayList();
        }

        return users.get(userId).getFollowees().stream().flatMap(id -> users.get(id).getTweets().stream())
                .sorted((t1, t2) -> t2.getPostTime() - t1.getPostTime()).limit(10).map(Tweet::getId).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User follower = this.users.getOrDefault(followerId, new User(followerId));
        follower.getFollowees().add(followeeId);
        User followee = this.users.getOrDefault(followeeId, new User(followeeId));
        this.users.put(followerId, follower);
        this.users.put(followeeId, followee);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (this.users.containsKey(followerId) && followerId != followeeId) {
            this.users.get(followerId).getFollowees().remove(followeeId);
        }
    }

    private class Tweet {
        private int id;
        private int postTime;

        public Tweet(int id,
                     int postTime) {
            this.id = id;
            this.postTime = postTime;
        }

        public int getId() {
            return this.id;
        }

        public int getPostTime() {
            return this.postTime;
        }
    }

    private class User {
        private int id;
        private Set<Integer> followees;
        private List<Tweet> tweets;

        public User(int id) {
            this.id = id;
            this.followees = new HashSet();
            followees.add(id);
            this.tweets = new ArrayList();
        }

        public Set<Integer> getFollowees() {
            return this.followees;
        }

        public List<Tweet> getTweets() {
            return this.tweets;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */