import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode_355 {
    class Twitter {

        public class Pair implements Comparable<Pair> {
            int count;
            int tweetId;

            Pair(int count, int tweetId) {
                this.count = count;
                this.tweetId = tweetId;
            }

            public int compareTo(Pair o) {
                return Integer.compare(this.count, o.count);
            }
        }

        public class Triplet implements Comparable<Triplet> {
            int listIndex;
            int count;
            int tweetId;

            Triplet(int listIndex, int count, int tweetId) {
                this.listIndex = listIndex;
                this.count = count;
                this.tweetId = tweetId;
            }

            public int compareTo(Triplet o) {
                return Integer.compare(this.count, o.count);
            }
        }

        Map<Integer, HashSet<Integer>> followingMap;
        Map<Integer, PriorityQueue<Pair>> tweetMap;
        int count;

        public Twitter() {
            count = 0;
            followingMap = new HashMap<>();
            tweetMap = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            if (tweetMap.containsKey(userId)) {
                PriorityQueue<Pair> tweets = new PriorityQueue<>(Collections.reverseOrder());
                tweets = tweetMap.get(userId);
                tweets.add(new Pair(++count, tweetId));
                tweetMap.put(userId, tweets);
            } else {
                PriorityQueue<Pair> tweets = new PriorityQueue<>(Collections.reverseOrder());
                tweets.add(new Pair(++count, tweetId));
                tweetMap.put(userId, tweets);
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            int tweetsLeft = 10;
            HashSet<Integer> followers = followingMap.get(userId);
            ArrayList<PriorityQueue<Pair>> tweetsList = new ArrayList<>();
            if (tweetMap.get(userId) != null) {
                PriorityQueue<Pair> temp = new PriorityQueue<>(Collections.reverseOrder());
                temp.addAll(tweetMap.get(userId));
                tweetsList.add(temp);
            }
            if (followers != null) {
                for (Integer f : followers) {
                    if (tweetMap.get(f) != null) {
                        PriorityQueue<Pair> temp = new PriorityQueue<>(Collections.reverseOrder());
                        temp.addAll(tweetMap.get(f));
                        tweetsList.add(temp);
                    }
                }
            }
            PriorityQueue<Triplet> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            if (tweetsList.size() == 1) {
                while (tweetsList.get(0).size() > 0) {
                    Pair curr = tweetsList.get(0).poll();
                    maxHeap.add(new Triplet(0, curr.count, curr.tweetId));
                }
                tweetsList.remove(0);
            }
            for (int i = 0; i < tweetsList.size(); i++) {
                Pair curr = tweetsList.get(i).poll();
                maxHeap.add(new Triplet(i, curr.count, curr.tweetId));
            }
            ArrayList<Integer> ans = new ArrayList<>();
            while (maxHeap.size() > 0 && tweetsLeft > 0) {
                Triplet triplet = maxHeap.remove();
                ans.add(triplet.tweetId);
                tweetsLeft--;
                if (tweetsList.size() > 0 && tweetsList.get(triplet.listIndex).size() > 0) {
                    Pair curr = tweetsList.get(triplet.listIndex).poll();
                    maxHeap.add(new Triplet(triplet.listIndex, curr.count, curr.tweetId));
                }
            }
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            if (followingMap.containsKey(followerId)) {
                HashSet<Integer> followings = followingMap.get(followerId);
                followings.add(followeeId);
                followingMap.put(followerId, followings);
            } else {
                HashSet<Integer> followings = new HashSet<Integer>();
                followings.add(followeeId);
                followingMap.put(followerId, followings);
            }
        }

        public void unfollow(int followerId, int followeeId) {
            if (followingMap.containsKey(followerId)) {
                HashSet<Integer> followings = followingMap.get(followerId);
                followings.remove(followeeId);
                followingMap.put(followerId, followings);
                if (followings.size() == 0) {
                    followingMap.remove(followerId);
                }
            }
        }
    }
}
/*
### Twitter Class Explanation:

The `Twitter` class is designed to simulate a simplified version of the Twitter social media platform, allowing users to post tweets, follow other users, unfollow users, and retrieve a personalized news feed.

### Data Structures Used:

1. **Pair Class:**
   - A custom `Pair` class is defined to represent a tweet along with its count (timestamp).
   - Implements `Comparable` to allow sorting based on the count.

2. **Triplet Class:**
   - A custom `Triplet` class is defined to represent a tweet along with its count and the index of the user's tweet list.
   - Implements `Comparable` to allow sorting based on the count.

3. **Data Structures for Tweet Storage:**
   - `tweetMap`: A HashMap where the key is the user ID, and the value is a PriorityQueue of pairs representing the tweets. The PriorityQueue is in reverse order to facilitate getting the latest tweets efficiently.

4. **Data Structures for Follower-Followee Relationship:**
   - `followingMap`: A HashMap where the key is the follower's user ID, and the value is a HashSet containing the IDs of users they are following.

### Class Initialization:

- In the constructor (`Twitter()`):
  - Initializes the necessary data structures, including `count` for timestamp management.
  - `tweetMap`: To store tweets for each user.
  - `followingMap`: To store the following relationship between users.

### Post Tweet (`postTweet` Method):

- Adds a tweet to a user's tweet list.
- If the user already has tweets, retrieves the existing PriorityQueue, adds the new tweet, and updates the map.
- If the user does not have tweets, creates a new PriorityQueue, adds the tweet, and updates the map.

### Get News Feed (`getNewsFeed` Method):

- Retrieves the latest tweets from the user and their followers.
- Uses a max heap (`maxHeap`) to efficiently select the tweet with the highest timestamp.
- Iterates through the tweets of each user and their followers, populating the `maxHeap`.
- Retrieves the top tweets from the heap to build the news feed.

### Follow (`follow` Method):

- Adds a followee to the follower's following set.

### Unfollow (`unfollow` Method):

- Removes a followee from the follower's following set.
- Removes the follower from the map if they have no more followees.

### Time and Space Complexity:

- **Time Complexity:**
  - Posting a tweet (`postTweet`): O(log n), where n is the number of tweets by the user.
  - Getting the news feed (`getNewsFeed`): O(m log m), where m is the total number of tweets from the user and their followers.
  - Following a user (`follow`): O(1).
  - Unfollowing a user (`unfollow`): O(1).

- **Space Complexity:**
  - `tweetMap`: O(t), where t is the total number of tweets.
  - `followingMap`: O(f), where f is the total number of following relationships.
  - `maxHeap`: O(k), where k is the number of tweets in the news feed.

### Summary:

The `Twitter` class efficiently manages tweets, followers, and news feed retrieval using priority queues and hash maps. It ensures fast access to the latest tweets and follows good practices for time and space complexity. The use of custom classes (`Pair` and `Triplet`) simplifies the code and enhances readability.
 */