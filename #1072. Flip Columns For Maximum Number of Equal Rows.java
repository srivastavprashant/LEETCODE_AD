// 1072. Flip Columns For Maximum Number of Equal Rows

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix)
    {
        HashMap<String, Integer> map= new HashMap<>();
        ArrayList<String> str= new ArrayList<>();
        ArrayList<String> opp= new ArrayList<>();
        int[] val={1, 0};
        
        for(int i=0;i<matrix.length;i++)
        {
            StringBuilder br= new StringBuilder("");
            StringBuilder br2= new StringBuilder("");
            for(int j=0;j<matrix[i].length;j++)
            {
                br.append(matrix[i][j]);
                br2.append(val[matrix[i][j]]);
            }
            
            String s= br.toString();
            str.add(s);
            opp.add(br2.toString());
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        //System.out.println(str+"\n"+opp+"\n"+map);
        
        int ans=0;
        for(int i=0;i<str.size();i++)
            ans= Math.max(ans, map.getOrDefault(str.get(i), 0)+ map.getOrDefault(opp.get(i), 0));
        
        return ans;
    }
}
