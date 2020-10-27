// 1630. Arithmetic Subarrays

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) 
    {
        List<Boolean> ans= new ArrayList<>();
        for(int i=0;i<l.length;i++)
        {
            int start= l[i];
            int last= r[i];
            
            int[] arr= new int[last-start+1];
            for(int j=0;j<arr.length;j++)
                arr[j]= nums[start+j];
            
            Arrays.sort(arr);
            int diff= arr[1]- arr[0];
            boolean ans_bool= true;
            for(int j=1;j<arr.length;j++)
                if(arr[j]- arr[j-1]!= diff)
                    ans_bool= false;
            
            ans.add(ans_bool);
        }
        
        return ans;
    }
}
