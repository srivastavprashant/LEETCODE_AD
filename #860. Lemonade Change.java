// 860. Lemonade Change


class Solution {
    public boolean lemonadeChange(int[] bills) 
    {
        int five=0, ten= 0;
        for(int i: bills)
        {
            if(i==5) 
                five++;
            else if(i==10)
            {
                if(five==0)
                    return false;
                else
                { ten++; five--; }
            }
            else
            {
                if(ten==0)
                {
                    if(five<3)
                        return false;
                    else
                        five-=3;
                }
                else
                {
                    if(five==0)
                        return false;
                    else
                    {
                        five--;
                        ten--;
                    }
                }
            }
        }
        
        return true;
    }
}
