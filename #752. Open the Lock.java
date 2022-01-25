# 752. Open the Lock



class Solution {
    public int openLock(String[] deadends, String _target) 
    {
        boolean[] visited= new boolean[10000];
        int a= 0, b= 0, c= 0, d= 0;
        
        for(int i=0;i<deadends.length;i++)
        {
            int value= 1000, index= 0;
            for(char ch: deadends[i].toCharArray())
            {
                index+= (ch- 48)* value;
                value/= 10;
            }
            if(index==0)
                return -1;
            visited[index]= true;
        }
        
        int target= 0, value= 1000;
        for(int i=0;i<_target.length();i++, value/=10)
            target+= (_target.charAt(i)- 48)*value;
            
        
        Queue<Integer> q= new LinkedList<>();
        q.add(a); q.add(b); q.add(c); q.add(d);
        visited[0]= true;
        
        int steps= 0;
        while(!q.isEmpty())
        {
            int size= q.size();
            for(int i=0;i<size/4;i++)
            {
                a= q.poll()% 10;
                b= q.poll()% 10;
                c= q.poll()% 10;
                d= q.poll()% 10;
                
                int curr_index= find(a, b, c, d);  
                if(target== curr_index)
                    return steps; 
            
                if(!visited[find(a-1, b, c, d)])
                { q.add(a-1); q.add(b); q.add(c); q.add(d); visited[(find(a-1, b, c, d))]= true; }
                if(!visited[find(a+1, b, c, d)])
                { q.add(a+1); q.add(b); q.add(c); q.add(d); visited[(find(a+1, b, c, d))]= true; }
            
                if(!visited[find(a, b-1, c, d)])
                { q.add(a); q.add(b-1); q.add(c); q.add(d); visited[(find(a, b-1, c, d))]= true; }
                if(!visited[find(a, b+1, c, d)])
                { q.add(a); q.add(b+1); q.add(c); q.add(d); visited[(find(a, b+1, c, d))]= true; }
            
                if(!visited[find(a, b, c-1, d)])
                { q.add(a); q.add(b); q.add(c-1); q.add(d); visited[(find(a, b, c-1, d))]= true; }
                if(!visited[find(a, b, c+1, d)])
                { q.add(a); q.add(b); q.add(c+1); q.add(d); visited[(find(a, b, c+1, d))]= true; }
            
                if(!visited[find(a, b, c, d-1)])
                { q.add(a); q.add(b); q.add(c); q.add(d-1); visited[(find(a, b, c, d-1))]= true; }
                if(!visited[find(a, b, c, d+1)])
                { q.add(a); q.add(b); q.add(c); q.add(d+1); visited[(find(a, b, c, d+1))]= true; }
            }
            steps++;
        }
        
        return -1;
    }
    
    static int find(int a, int b, int c, int d)
    { return ((a+ 10)% 10)*1000+ ((b+ 10)% 10)*100+ ((c+ 10)% 10)*10+ ((d+ 10)% 10); }
}
