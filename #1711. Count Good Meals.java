// #1711. Count Good Meals


class Solution {
    public int countPairs(int[] deliciousness) 
    {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i: deliciousness)
            map.put(i,map.getOrDefault(i, 0)+1);
        
        List<Integer> arr= new ArrayList<>(map.keySet());
        Collections.sort(arr);
        
        long ans= 0;
        for(int i=0;i<arr.size();i++, ans= ans%1000000007)
        {
            int key= arr.get(i);
            int value= map.get(key);
            
            int temp= 1;
            for(int j=0;j<=21;j++)
            {
                int to_find= (temp<<=(j== 0? 0: 1))- key;
                if(to_find< key)
                    continue;
                
                if(to_find!= key)
                    ans+= (value* map.getOrDefault(to_find, 0))%1000000007;
                else
                    ans+= ((value-1)*1l*value/2)%1000000007;
            }
        }
        
        return (int)(ans%1000000007);
    }
}
