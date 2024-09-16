package LeetCodeJ;// 838. Push Dominoes



class Solution {
    public String pushDominoes(String dominoes) 
    {
        char[] arr= dominoes.toCharArray();
        boolean[] visited= new boolean[arr.length];
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<arr.length;i++)
            if(arr[i]!= '.')
            { q.add(i); visited[i]= true; }
        
        while(!q.isEmpty())
        {
            int size= q.size();
            HashSet<Integer> set= new HashSet<>();
            for(int ii=0;ii<size;ii++)
            {
                int i= q.poll();
                if(arr[i]== '.' ) continue;
                
                if(arr[i]== 'L' && i!= 0)
                { 
                    if(set.contains(i-1)) arr[i-1]= '.';
                    else if(!visited[i-1])
                    { arr[i-1]= 'L'; q.add(i-1); set.add(i-1); visited[i-1]= true; }
                }
                else if(arr[i]== 'R' && i!= arr.length-1)
                { 
                    if(set.contains(i+1)) arr[i+1]= '.';
                    else if(!visited[i+1]) 
                    { arr[i+1]= 'R'; q.add(i+1); set.add(i+1); visited[i+1]= true; }
                }
            }
        }
        
        return new String(arr);
    }
}
