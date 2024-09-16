#1801. Number of Orders in the Backlog


class Solution 
{
    int price= 0, amount= 1, type= 2;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> sell_backlog= new PriorityQueue<>((a, b)-> (a[price]- b[price]));
        PriorityQueue<int[]> buy_backlog= new PriorityQueue<>((a, b)-> (b[price]- a[price]));
        
        for(int i=0;i<orders.length;i++)
        {
            if(orders[i][type]== 0) // buy
            {
                while(orders[i][amount]!= 0 && !sell_backlog.isEmpty())
                {
                    if(sell_backlog.peek()[price]<= orders[i][price])
                    {
                        int[] curr= sell_backlog.poll();
                        if(orders[i][amount]>= curr[amount])
                            orders[i][amount]-= curr[amount];
                        else
                        {
                            curr[amount]-= orders[i][amount];
                            sell_backlog.add(curr);
                            orders[i][amount]= 0;
                        }
                    }
                    else
                        break;
                }
            }
            else
            {
                while(orders[i][amount]!= 0 && !buy_backlog.isEmpty())
                {
                    if(buy_backlog.peek()[price]>= orders[i][price])
                    {
                        int[] curr= buy_backlog.poll();
                        if(orders[i][amount]>= curr[amount])
                            orders[i][amount]-= curr[amount];
                        else
                        {
                            curr[amount]-= orders[i][amount];
                            buy_backlog.add(curr);
                            orders[i][amount]= 0;
                        }
                    }
                    else
                        break;
                }
            }
                
            if(orders[i][amount]!= 0 && orders[i][type]== 1)
                sell_backlog.add(orders[i]);
            else if(orders[i][amount]!= 0)
                buy_backlog.add(orders[i]);
        }
                    
        int ans= 0;
        while(!buy_backlog.isEmpty())
        { ans+= buy_backlog.poll()[amount]; if(ans>= 1e9+7) ans%= 1e9+7; }
        
        while(!sell_backlog.isEmpty())
        { ans+= sell_backlog.poll()[amount]; if(ans>= 1e9+7) ans%= 1e9+7; }
        
        return ans;
    }
}
