package LeetCodeJ;// 90. Subsets II


class Solution 
{
    static List<List<Integer>> ans;
    static void call(int[] arr, int index, List<Integer> list, HashMap<Integer, Integer[]> map)
    {
        if(index< arr.length)
        {
            call(arr, map.get(arr[index])[1]+1, list, map);
            
            list.add(arr[index]);
            call(arr, index+1, list, map);
            list.remove(list.size()-1);
        }
        else
            ans.add(new ArrayList<>(list));
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        ans= new ArrayList<>();
        HashMap<Integer, Integer[]> map= new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
                map.get(nums[i])[1]= i;
            else
                map.put(nums[i], new Integer[]{i, i});
        }
        
        call(nums, 0, new ArrayList<>(), map);
        
        return ans;
    }
}
