// 1311. Get Watched Videos by Your Friends

class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) 
    {   
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[friends.length];
        q.add(id); visited[id]= true;
        
        while(!q.isEmpty())
        {
            int size= q.size();
            
            for(int i=0;i<size;i++)
            {
                int index= q.poll();
                
                for(int ii: friends[index])
                    if(!visited[ii])
                    {
                        visited[ii]= true;
                        q.add(ii);
                    }
            }
            
            if(--level==0)
                break;
        }
        
        HashMap<String, Integer> map=new HashMap<>();
        while(!q.isEmpty())
        {
            int index= q.poll();
            
            for(String s: watchedVideos.get(index))
                map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        List<String> ans=new ArrayList<>(map.keySet());
        Comparator<String> comp=new Comparator<String>()
        {
            @Override
            public int compare(String a, String b)
            {
                if(map.get(a)!= map.get(b))
                    return map.get(a)- map.get(b);
                return a.compareTo(b);
            }
        };
        
        Collections.sort(ans, comp);
        return ans;
    }
}
