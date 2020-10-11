// 39. Combination Sum


class Solution 
{
    static List<List<Integer>> ans;
    static void call(int[] candidate, int target, List<Integer> list, int index)
    {
        if(target==0)
        { ans.add(new ArrayList<>(list)); return; }
        for(int i= index;i<candidate.length;i++)
        {
            if(candidate[i]<= target)
            {
                list.add(candidate[i]);
                call(candidate, target-candidate[i], list, i);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        ans= new ArrayList<>();
        call(candidates, target, new ArrayList<>(), 0);
        
        return ans;
    }
}
