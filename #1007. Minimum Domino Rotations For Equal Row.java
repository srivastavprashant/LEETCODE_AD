/*
    Approach : Question was a adhoc (as far as i think, it can be wrong) as there was no specific algo that came to my mind.
    ALGORITHM:
               1. A possible soln needs to be present in either of the array possibly both, given for every valid pos i. So arr1[0] and arr2[0] are valid candidates.
               2. As we need to give the minimun rotations we will store the counts that the candidate has occured in the array 1: arr1 and array 2: arr2.
               3. There is a possibility that there is no correct ans in that case we have taken two booleans that are true till there candidate remains a possible ans.
               4. If one of the candidate is in both the array at same location then obvious thing is that candidate two is no longer a soln. Moreover we will not increase the 
                  count of any array as both has the candidate so we wont require a rotation in any case.
                  
               Time complexity O(N)
               Space Complexity O(1)

*/
class Solution {
    public int minDominoRotations(int[] arr1, int[] arr2) 
    {
        int candidate1= arr1[0], candidate2= arr2[0];

        int[] count1= new int[]{candidate2==candidate1?0:1, 0};
        int[] count2= new int[]{0, candidate2==candidate1?0:1};
        
        boolean bool1= true, bool2= true;
        
        for(int i=1;i<arr1.length && (bool1 || bool2);i++)
        {
            if(bool1 && arr1[i]==candidate1 && arr2[i]==candidate1);
            else if(bool1 && arr1[i]==candidate1)
                count1[0]++;
            else if(bool1 && arr2[i]==candidate1)
                count1[1]++;
            else
                bool1= false;
            
            if(bool2 && arr1[i]==candidate2 && arr2[i]==candidate2);
            else if(bool2 && arr1[i]==candidate2)
                count2[0]++;
            else if(bool2 && arr2[i]==candidate2)
                count2[1]++;
            else
                bool2= false;
        }
        
        //System.out.println(bool1+" "+count1[0]+" "+count1[1]);
        if(bool1) return Math.min(count1[0], count1[1]);
        if(bool2) return Math.min(count2[0], count2[1]);
        return -1;
    }
}
