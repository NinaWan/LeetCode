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
        users.computeIfAbsent(userId, x -> new User(userId)).postTweet(tweetId);
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
        users.computeIfAbsent(followeeId, x -> new User(followeeId));
        users.computeIfAbsent(followerId, x -> new User(followerId)).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && followerId != followeeId) {
            users.get(followerId).unfollow(followeeId);
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
        private Set<Integer> followed;
        private LinkedList<Tweet> tweets;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet();
            this.tweets = new LinkedList();
            follow(id);
        }

        public void follow(int followeeId) {
            followed.add(followeeId);
        }

        public void unfollow(int followeeId) {
            followed.remove(followeeId);
        }

        public void postTweet(int tweetId) {
            tweets.addFirst(new Tweet(tweetId,
                                      timestamp++));
        }

        public Set<Integer> getFollowees() {
            return followed;
        }

        public LinkedList<Tweet> getTweets() {
            return tweets;
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