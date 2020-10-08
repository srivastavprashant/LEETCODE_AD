// 1566. Detect Pattern of Length M Repeated K or More Times

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) 
    {
        int count=0, ans=0;
        for(int i=m;i<arr.length;i++)
        {
            if(arr[i]== arr[i-m])
                count++;
            else
            {
                ans=0;
                count=0;
            }
            
            if(count== m)
            {
                ans++;
                count=0;
            }
            
            if(ans== k-1)
            {
                System.out.println(i);
                return true;
            }
        }
        
        return false;
    }
}
