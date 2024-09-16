package LeetCodeJ;// #638. Shopping Offers



class Solution 
{
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) 
    {
        ans= cost_cal(price, needs);
        call(price, special, needs, 0);
        return ans;
    }
    
    int ans;
    void call(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int cost)
    {
        if(cost>= ans) return;
        else if(empty(needs)) ans= Math.min(ans, cost);
        else
        {
            boolean found= false;
            for(List<Integer> i: special)
            {
                if(possible(i, needs))
                {
                    found= true;
                    call(price, special, needs, cost+ i.get(price.size()));
                    restore(i, needs);
                }
            }
            
            if(!found) ans= Math.min(ans, cost+ cost_cal(price, needs));
        }
    }
    
    int cost_cal(List<Integer> price, List<Integer> needs)
    {
        int ret= 0;
        for(int i=0;i<needs.size();i++)
            ret+= needs.get(i)* price.get(i);
        return ret;
    }
    
    boolean possible(List<Integer> offer, List<Integer> needs)
    {
        for(int i=0;i<needs.size();i++)
            if(needs.get(i)- offer.get(i)< 0) return false;
        
        for(int i=0;i<needs.size();i++)
            needs.set(i, needs.get(i)- offer.get(i));
        return true;
    }
    
    void restore(List<Integer> offer, List<Integer> needs)
    {
        for(int i=0;i<needs.size();i++)
            needs.set(i, needs.get(i)+ offer.get(i));
    }
    
    boolean empty(List<Integer> needs)
    {
        int sum= 0;
        for(int i: needs)
            sum+=i;
        return sum== 0;
    }
}
