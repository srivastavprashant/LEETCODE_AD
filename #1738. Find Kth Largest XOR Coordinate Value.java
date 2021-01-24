// #1738. Find Kth Largest XOR Coordinate Value


class Solution {
    public int kthLargestValue(int[][] matrix, int k) 
    {
        int[][] prefix= new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<prefix.length;i++)
        {
            for(int j=1;j<prefix[0].length;j++)
            {
                prefix[i][j]= matrix[i-1][j-1]^ prefix[i-1][j]^ prefix[i][j-1]^ prefix[i-1][j-1];
            }
        }
        
        
        PriorityQueue<Integer> arr= new PriorityQueue<>(Collections.reverseOrder());
        for(int[] i: prefix)
            for(int j: i)
                arr.add(j);
        
        while(--k!= 0)
            arr.poll();
        
        return arr.poll();
    }
}
