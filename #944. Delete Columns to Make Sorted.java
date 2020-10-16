// 944. Delete Columns to Make Sorted


class Solution {
    public int minDeletionSize(String[] A) 
    {
        HashSet<Integer> set= new HashSet<>();
        
        for(int i=0;i<A[0].length();i++)
        {
            int last= 'a';
            for(int j=0; j<A.length;j++)
            {
                char c= A[j].charAt(i);
                if(c<last)
                    set.add(i);
                last= c;
            }
        }
        
        //System.out.println(set);
        return set.size();
    }
}
