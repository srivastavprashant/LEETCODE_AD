package LeetCodeJ;// #1992. Find All Groups of Farmland



class Solution {
    int n, m;
    public int[][] findFarmland(int[][] land) {
        n= land.length; m= land[0].length;
        UnionFind dsu= new UnionFind(n*m+1);
        List<int[]> ans= new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(land[i][j]== 0) {
                    dsu.union(n*m, index(i, j));
                } else {
                    if(i-1!= -1 && land[i-1][j]== 1) dsu.union(index(i, j), index(i-1, j));
                    if(j-1!= -1 && land[i][j-1]== 1) dsu.union(index(i, j), index(i, j-1));
                    if(i+1!= land.length && land[i+1][j]== 1) dsu.union(index(i, j), index(i+1, j));
                    if(j+1!= land[0].length && land[i][j+1]== 1) dsu.union(index(i, j), index(i, j+1));
                }    
            }
        }
        
        Map<Integer, List<Integer>> map= dsu.map();
        // System.out.println(map);
        for(int parent: map.keySet()) {
            if(parent== n*m) continue;
            else {
                int[] min= new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
                int[] max= new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
                for(int i: map.get(parent)) {
                    int row= i/m, col= i%m;
                    if(min[0]>= row && min[1]>= col) min= new int[]{row, col};
                    if(max[0]<= row && max[1]<= col) max= new int[]{row, col};
                }
                ans.add(new int[]{min[0], min[1], max[0], max[1]});
            }
        }
        
        int c= 0;
        int[][] ret= new int[ans.size()][];
        for(int[] i: ans) ret[c++]= i;
        return ret;
    }
    
    int index(int i, int j) { return i*m+ j; }
    
    class UnionFind {
        int[] rank;
        int[] par;
        UnionFind(int n) {
            par= new int[n];
            rank= new int[n];
            for(int i=0;i<n;i++) par[i]= i;
        }
        
        public void union(int a, int b) {
            while(par[a]!= a)
                a= par[a];
            
            while(par[b]!= b)
                b= par[b];
            
            if(rank[a]> rank[b])
                par[b]= a;
            else if(rank[a]< rank[b])
                par[a]= b;
            else
            { par[b]= a; rank[a]++; }
        }
        
        public Map<Integer, List<Integer>> map() {
            Map<Integer, List<Integer>> map= new HashMap<>();
            for(int i=0;i<par.length;i++) {
                int temp= i;
                while(temp!= par[temp]) temp= par[temp];
                
                if(!map.containsKey(temp)) map.put(temp, new ArrayList<>());
                map.get(temp).add(i);
            }
            
            return map;
        }
    }
}
