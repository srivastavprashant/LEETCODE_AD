// 1640. Check Array Formation Through Concatenation
 

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) 
    {
        int i=0;
        while(i<arr.length)
        {
            boolean matched= true;
            for(int j=0;j<pieces.length && i<arr.length;j++)
            {
                if(pieces[j].length> arr.length-i) continue;
                
                matched= true;
                int curr= i;
                for(int k=0;k<pieces[j].length && matched;k++, curr++)
                    if(arr[curr]!= pieces[j][k])
                        matched= false;
                
                if(matched) 
                {
                    i= curr;
                    break;
                }
            }
            
            if(!matched)
                return false;
        }
        
        return true;
    }
}
