package LeetCodeJ;// #1673. Find the Most Competitive Subsequence


class Solution {
    public int[] mostCompetitive(int[] nums, int k) 
    {
        int[] ans= new int[k];
        Arrays.fill(ans, -1);
        ArrayList<Integer> arr= new ArrayList<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            arr.add(i);
            map.put(i, nums[i]);
        }
        
        Comparator<Integer> comp= new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            { return nums[a]- nums[b]; }
        };
        
        Collections.sort(arr, comp);
        //System.out.println(arr);
        //System.out.println(map);
        int i, c=0, prev= -1;
        for(i=0;i<arr.size() && c!= ans.length;i++)
        {
            if(ans[c]!= -1)
            {
                prev= ans[c];
                c++;
                i--;
            }
            
            else if((nums.length- arr.get(i))>= k && prev< arr.get(i))
            {       
                ans[c++]= arr.get(i);
                k--;
                prev= arr.get(i);
            }
            else if(prev< arr.get(i))
            {
                int index= ans.length- nums.length+ arr.get(i);
                ans[index]= arr.get(i);
            }

        }
        
        for(i=0;i<ans.length;i++)
            ans[i]= nums[ans[i]];
        
        //System.out.println(i);
        
        return ans;
    }
}
