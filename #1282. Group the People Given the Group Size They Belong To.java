// #1282. Group the People Given the Group Size They Belong To
class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) 
    {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<arr.length;i++)
        {
            int key= arr[i];
            if(map.containsKey(key))
            {
                List<Integer> value= map.get(key);
                if(value.size()== key)
                {
                    ans.add(new ArrayList<>(value));
                    value.clear();
                }
                
                value.add(i);
            }
            else
            {
                List<Integer> temp=new ArrayList<>();
                temp.add(i);
                
                map.put(key, temp);
            }
        }
        
        for(int i: map.keySet())
            ans.add(map.get(i));
        return ans;
    }
}
