// #1701. Average Waiting Time



class Solution {
    public double averageWaitingTime(int[][] customers) 
    {
        long chef_free= 0, wait= 0;
        for(int i=0;i<customers.length;i++)
        {
            if(chef_free>= customers[i][0])
            {
                wait+= chef_free-customers[i][0]+ customers[i][1];
                chef_free+= customers[i][1];
            }
            else
            {
                wait+= customers[i][1];
                chef_free= customers[i][0]+ customers[i][1];
            }
        }
        
        return wait*1.0/customers.length;        
    }
}
