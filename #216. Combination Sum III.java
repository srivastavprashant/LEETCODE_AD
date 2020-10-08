// 216. Combination Sum III

class Solution 
{
    static List<List<Integer>> ans= new ArrayList<>();
    static void call(int n, int k, List<Integer> list, int prev)
    {
        if(n==0)
            ans.add(new ArrayList<>(list));
        else if(n<= 45- (9-k)*(9-k+1)/2)
        {
            //System.out.println(list);
            int i= n- k*(k-1)/2;
            i= Math.min(i, prev-1);
            
            for( ;i>=1 && (i*(i-1)/2)>=n-i ;i--)
            {
                
                list.add(i);
                call(n-i, k-1, list, i);
                list.remove(list.size()-1);
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        ans= new ArrayList<>();
        call(n, k, new ArrayList<>(), 10);
            
        return ans;

    }
}
