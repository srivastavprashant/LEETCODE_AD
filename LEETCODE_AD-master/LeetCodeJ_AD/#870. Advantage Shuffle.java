package LeetCodeJ;// 870. Advantage Shuffle


class Solution {
    public int[] advantageCount(int[] A, int[] B) 
    {
        TreeMap<Integer, Integer> map= new TreeMap<>();
        for(int i: A)
            map.put(i, (map.containsKey(i)? map.get(i)+1: 1));
        
        for(int i=0;i<B.length;i++)
        {
            Integer val= map.higherKey(B[i]);
            if(val== null)
            {
                A[i]= map.firstKey();
                val= A[i];
            }
            else
                A[i]= val;
            
            int freq= map.get(val);
            if(freq==1)
                map.remove(val);
            else
                map.put(val, map.get(val)-1);
        }
        
        return A;
    }
}
