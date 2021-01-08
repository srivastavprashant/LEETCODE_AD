/**
 * Approach 1:
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


// memoization
class Solution 
{
    int[][] memo;
    HashMap<Integer, ArrayList<Integer>> map;
    int call(int[] a, int[] b, int indexA, int indexB)
    {
        if(indexA== a.length|| indexB== b.length) return 0;
        else if(memo[indexA][indexB]!= -1) return memo[indexA][indexB];
        
        ArrayList<Integer> arr= map.getOrDefault(a[indexA], new ArrayList<>());
        int index= binarySearch(arr, 0, arr.size()-1, indexB);
        
        int max= call(a, b, indexA+1, indexB);
        if(index<arr.size())
            max= Math.max(max, 1+call(a, b, indexA+1, arr.get(index)+1));
        
        memo[indexA][indexB]= max;
        return max;
    }
    
    int binarySearch(ArrayList<Integer> arr, int start, int last, int find)
    {
        if(start>last) return 1;
        while(start<= last)
        {
            int mid= start+ (last- start)/2;
            
            if(arr.get(mid)>= find)
                last= mid-1;
            else
                start= mid+1;
        }
        
        return start;
    }
    
    public int maxUncrossedLines(int[] A, int[] B) 
    {
        map= new HashMap<>();
        memo= new int[A.length][B.length];
        for(int i=0;i<A.length;i++)
            Arrays.fill(memo[i], -1);
        
        for(int i=0;i<B.length;i++)
        {
            if(map.containsKey(B[i]))
                map.get(B[i]).add(i);
            else
            {
                ArrayList<Integer> arr= new ArrayList<>();
                arr.add(i);
                map.put(B[i], arr);
            }
        }
        
        return call(A, B, 0, 0);
    }
}
