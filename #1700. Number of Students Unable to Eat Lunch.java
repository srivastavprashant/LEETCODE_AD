// #1700. Number of Students Unable to Eat Lunch



class Solution {
    public int countStudents(int[] students, int[] sandwiches) 
    {
        Deque<Integer> q= new LinkedList<>();
        for(int i=0;i<students.length;i++)
            q.addLast(i);
        
        int curr= 0, iter= 0;
        while(!q.isEmpty())
        {
            int st= q.pollFirst();
            if(sandwiches[curr]== students[st])
                curr++;
            else
                q.addLast(st);
            
            iter++;
            if(iter== 1000)
                return q.size();
        }
        
        return 0;
    }
}
