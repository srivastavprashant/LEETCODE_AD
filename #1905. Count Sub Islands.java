// #1905. Count Sub Islands


class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        UnionFind a= buildDSU(grid1);
        UnionFind b= buildDSU(grid2);
        Map<Integer, List<Integer>> map= b.map();
        
        int ans= 0;
        outer: for(int i: map.keySet()) {
            if(i== grid2.length*grid2[0].length) continue;
            else {
                Set<Integer> set= new HashSet<>();
                for(int j: map.get(i)) {
                    if(j== grid1.length*grid1[0].length || grid1[j/grid1[0].length][j%grid1[0].length]!= 1) continue outer;
                    set.add(a.parent(j));
                }
                
                if(set.size()== 1) ans++;
            }
        }
        
        return ans;
    }
    
    UnionFind buildDSU(int[][] arr) {
        int n= arr.length, m= arr[0].length;
        UnionFind dsu= new UnionFind(n*m+1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(arr[i][j]== 0) {
                    dsu.union(i*m+j, n*m);
                } else {
                    if(i-1!= -1 && arr[i-1][j]== 1) dsu.union(i*m+ j, (i-1)*m+ j);
                    if(j-1!= -1 && arr[i][j-1]== 1) dsu.union(i*m+ j, i*m+ j-1);
                    if(i+1!= arr.length && arr[i+1][j]== 1) dsu.union(i*m+ j, (i+1)*m+ j);
                    if(j+1!= arr[0].length && arr[i][j+1]== 1) dsu.union(i*m+ j, i*m+ j+1);
                }
            }
        }
        
        return dsu;
    }
    
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
        
        public int parent(int a) {
             while(par[a]!= a)
                a= par[a];
            return a;
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
