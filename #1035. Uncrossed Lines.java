/**
 * Approach 1:
 * Basically we have two choices at each step to connect the value with
 * corresponding value or not.
 *
 * Just make a recursive function and do a exhaustive search and find the
 * max connections possible.
 *
 * Optimization:
 * Use a data structure to find the first index greater than a particular
 * index given.
 * We will use a HashMap that will map the value to its indexes.
 * for storing index of a particular value we will use TreeSet or a
 * red black tree that can efficiently tell the ceil index closer to a
 * provided index.
 *
 * (Time limit Exceeded)
 *
 * Optimization using Dynamic Programming. (Memoization)
 * TODO: 
 */

class Solution 
{
    static int max;
    static void call(int[] arr, int[] arr2, HashMap<Integer, TreeSet<Integer>> map, int index, int curr_pos, int lines)
    {
        if(index<arr.length)
        {
            Integer val= map.getOrDefault(arr[index], new TreeSet<>()).ceiling(curr_pos);
            if(val!= null)
                call(arr, arr2, map, index+1, val+1, lines+1);
            
            call(arr, arr2, map, index+1, curr_pos, lines);
        }
        else
            max= Math.max(max, lines);
    }
    
    public int maxUncrossedLines(int[] A, int[] B) 
    {
        HashMap<Integer, TreeSet<Integer>> map= new HashMap<>();
        for(int i=0;i<B.length;i++)
        {
            if(map.containsKey(B[i]))
                map.get(B[i]).add(i);
            else
            {
                TreeSet<Integer> set= new TreeSet<>();
                set.add(i);
                map.put(B[i], set);
            }
        }
        
        max=0;
        call(A, B, map, 0, 0, 0);
        
        return max;
    }
}
