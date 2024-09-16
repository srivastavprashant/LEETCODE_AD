package LeetCodeJ;// #1424. Diagonal Traverse II


class Solution 
{
    public int[] findDiagonalOrder(List<List<Integer>> nums) 
    {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        int size= 0, max= 0;
        for(int i=0;i<nums.size();i++)
        {
            for(int j= 0;j<nums.get(i).size();j++)
            {
                size++;
                max= Math.max(i+j, max);
                if(map.containsKey(i+j))
                    map.get(i+j).add(nums.get(i).get(j));
                else
                    map.put(i+j, new ArrayList<>(Arrays.asList(nums.get(i).get(j))));
            }
        }
        
        int[] ans= new int[size];
        int c= 0;
        for(int i=0;i<=max;i++)
        {
            List<Integer> arr= map.get(i);
            
            for(int j=arr.size()-1;j>=0;j--)
                ans[c++]= arr.get(j);
        }

        return ans;
    }
}
