package LeetCodeJ;// #355. Design Twitter



class Twitter {
    class Person {
        int userId;
        Queue<Integer> tweets;
        Set<Integer> following;
        Person(int userId, Queue<Integer> tweets, Set<Integer> following) {
            this.userId= userId;
            this.tweets= tweets;
            this.following= following;
        }
    }
    Map<Integer, Person> map_user;
    Map<Integer, Integer> map_post;
    int counter;
    
    public Twitter() {
        map_user= new HashMap<>();
        map_post= new HashMap<>();
        counter= 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        map_post.put(tweetId, counter++);
        createUser(userId);
        Person curr= map_user.get(userId);
        if(curr.tweets.size()== 10) curr.tweets.poll(); 
        curr.tweets.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!map_user.containsKey(userId)) return new ArrayList<>();
        Person curr= map_user.get(userId);
        TreeSet<Integer> set= new TreeSet<>((i, j)-> (map_post.get(j)- map_post.get(i)));
        for(int i: curr.following) {
            for(int j: map_user.get(i).tweets) set.add(j);
        }
        
        for(int i: curr.tweets) set.add(i);
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<10 && !set.isEmpty();i++) ans.add(set.pollFirst());
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        createUser(followerId); createUser(followeeId);
        map_user.get(followerId).following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        createUser(followerId); createUser(followeeId);
        map_user.get(followerId).following.remove(followeeId);
    }
    
    public void createUser(int userId) {
        if(map_user.containsKey(userId)) return ;
        Person p= new Person(userId, new LinkedList<>(), new HashSet<>());
        map_user.put(userId, p);
    }
}
