// 1629. Slowest Key

class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) 
    {
        ArrayList<Character> ans= new ArrayList<>();
        int max= -1;
        for(int i=0;i<keysPressed.length();i++)
        {
            int time=0;
            if(i==0)
                time = releaseTimes[i];
            else
                time= releaseTimes[i]- releaseTimes[i-1];
            
            if(max< time)
            {
                max= time;
                ans= new ArrayList<>();
                ans.add(keysPressed.charAt(i));
            }
            else if(max== time)
                ans.add(keysPressed.charAt(i));
        }
        
        char min= 'A';
        for(Character c: ans)
            min= (char)Math.max(c, min);
        
        return (char)min;
    }
}
