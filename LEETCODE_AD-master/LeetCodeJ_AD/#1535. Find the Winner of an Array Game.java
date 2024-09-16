package LeetCodeJ;// #1535. Find the Winner of an Array Game

class Solution {
    public int getWinner(int[] arr, int k) 
    {
        Deque<Integer> q=new LinkedList<Integer>();
        int max=-1;
        for(int i: arr)
        {
            q.add(i);
            max= Math.max(max, i);
        }
        
        int count=0, winner= -1;
        while(count!=k && winner!=max)
        {
            //System.out.println(q);
            int val= q.pollFirst();
            int val2= q.pollFirst();
            int win= Math.max(val, val2);
        
            if(winner== win)
                count++;
            else
            {
                winner= win;
                count=1;
            }
            
            q.addFirst(win);
            q.addLast(win^val^val2);
        }
        return winner;
    }
}
