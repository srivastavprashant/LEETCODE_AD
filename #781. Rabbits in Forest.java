// 781. Rabbits in Forest

class Solution {
    public int numRabbits(int[] answers) 
    {
        int[] map= new int[1000];
        int ans=0;
        for(int i: answers)
        {
            if(map[i]!=0)
            { map[i]--;}
            else
                map[i]= i;
            
            ans++;
        }
        
        for(int i: map)
            ans+= i;
        
        return ans;        
    }
}
