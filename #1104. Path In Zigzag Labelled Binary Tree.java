// 1104. Path In Zigzag Labelled Binary Tree


class Solution 
{
    public List<Integer> pathInZigZagTree(int label)
    {
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        boolean reverse= false, bool= true;
        HashMap<Integer, Integer> map= new HashMap<>();
        
        while(bool)
        {
            int size= q.size();
            List<Integer> list= new ArrayList<>();
            
            for(int i=0;i<size;i++)
            {
                int curr= q.poll();
                list.add(curr);
                
                if(curr== label)
                    bool= false;
                
                q.add(curr*2);
                q.add(curr*2+1);
            }
            
            if(reverse)
            { 
                int n= list.size()-1;
                for(int i=0;i<list.size();i++)
                    map.put(list.get(i), list.get(n-i)); 
            }
            reverse= !reverse;
        }
        
        List<Integer> list= new ArrayList<>();
        label= map.getOrDefault(label, label);
        
        while(label>=1)
        {
            if(map.containsKey(label))
                list.add(map.get(label));
            else
                list.add(label);
            
            label/=2;
        }
        Collections.reverse(list);
        //System.out.println(map);
        return list;
    }
}
