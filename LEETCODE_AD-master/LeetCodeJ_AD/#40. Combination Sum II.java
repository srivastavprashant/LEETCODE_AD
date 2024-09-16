package LeetCodeJ;// 40. Combination Sum II


class Solution 
{
    static List<List<Integer>> ans;
    static void call(int[] candidates, int target, int index, List<Integer> list)
    {
        //System.out.println(list+" "+target+" "+index);
        if(target==0)
            ans.add(new ArrayList<>(list));
        else if(index< candidates.length && target>0)
        {
            int val= Search(candidates, candidates[index]+1, index, candidates.length-1);
            list.add(candidates[index]);
            call(candidates, target- candidates[index], index+1, list);
            
            list.remove(list.size()-1);
            call(candidates, target, val, list);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        ans= new ArrayList<>();
        Arrays.sort(candidates);
        call(candidates, target, 0, new ArrayList<>());
        
        return ans;
    }
    
    static int Search(int[] candidates, int find, int start, int last)
    {
        for(int i=start+1;i<=last;i++)
            if(candidates[i]>= find)
                return i;
        
        return last+1;
    }
}
