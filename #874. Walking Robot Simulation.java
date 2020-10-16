//874. Walking Robot Simulation


class Solution {
    public int robotSim(int[] commands, int[][] obstacles) 
    {
        int x=0, y=0, direction= 0, ans=0;
        HashMap<Integer, HashSet<Integer>> map= new HashMap<>();
        for(int[] i: obstacles)
        {
            if(map.containsKey(i[0]))
                map.get(i[0]).add(i[1]);
            else
            {
                HashSet<Integer> temp= new HashSet<>();
                temp.add(i[1]);
                map.put(i[0], temp);
            }
        }
        
        for(int i: commands)
        {
            if(i== -2)
            { direction= (direction+4-1)%4; }
            else if(i== -1)
            { direction= (direction+1)%4; }
            else
            {
                if(direction==0)
                    while(i--!=0)
                    { if(map.containsKey(x) && map.get(x).contains(y+1)) break; y+=1; }
                else if(direction==1)
                    while(i--!=0)
                    { if(map.containsKey(x+1) && map.get(x+1).contains(y)) break; x+=1; }
                else if(direction==2)
                    while(i--!=0)
                    { if(map.containsKey(x) && map.get(x).contains(y-1)) break; y-= 1;}
                else
                    while(i--!=0)
                    { if(map.containsKey(x-1)&& map.get(x-1).contains(y)) break; x-=1; }
                
                ans= Math.max(ans, x*x+y*y);
            }
        }
        return ans;
    }
}
