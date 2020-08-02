// #763. Partition Labels
class Solution {
    public List<Integer> partitionLabels(String S) 
    {
        int[] index=new int[26];
        char[] arr= S.toCharArray();
        List<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++) 
            index[arr[i]-'a']= i; 
            
        int last=-1, count=1;     
        for(int i=0;i<arr.length;i++, count++)
        {
            if(index[arr[i]-'a']>last)
                last= index[arr[i]-'a'];
            if(i==last)
            {
                //System.out.println(last);
                ans.add(count);
                count=0;
            }
        }
             
        return ans;
    }
}
