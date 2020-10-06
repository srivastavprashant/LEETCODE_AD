//986. Interval List Intersections

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) 
    {
        ArrayList<Integer[]> list= new ArrayList<>();
        
        int i=0, j=0;
        while(i< A.length && j< B.length)
        {
            int[] arr= A[i];
            int[] brr= B[j];
            
            if(arr[0]> brr[1])
                j++;
            else if(brr[0]> arr[1])
                i++;
            else
            {
                list.add(new Integer[]{Math.max(arr[0], brr[0]), Math.min(arr[1], brr[1])});
                if(arr[1]> brr[1])
                    j++;
                else if(brr[1]> arr[1])
                    i++;
                else
                { i++; j++;}
            }
        }
        
        int[][] c= new int[list.size()][2];
        for(i=0;i<c.length;i++)
            c[i]= new int[]{list.get(i)[0], list.get(i)[1]};
        
        return c;        
    }
}
