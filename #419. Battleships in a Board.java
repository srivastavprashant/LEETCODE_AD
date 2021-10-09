// #419. Battleships in a Board



class Solution {
    int n;
    public int countBattleships(char[][] board) {
        n= board[0].length;
        UnionFind dsu= new UnionFind(board.length* board[0].length+1);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]!= 'X') { dsu.union(board.length* board[0].length, index(i, j)); continue; }
                if(i-1!= -1 && board[i-1][j]== 'X') dsu.union(index(i, j), index(i-1, j));
                if(j-1!= -1 && board[i][j-1]== 'X') dsu.union(index(i, j), index(i, j-1));
                if(i+1!= board.length && board[i+1][j]== 'X') dsu.union(index(i, j), index(i+1, j));
                if(j+1!= board[0].length && board[i][j+1]== 'X') dsu.union(index(i, j), index(i, j+1));
            }
        }
        
        Map<Integer, List<Integer>> map= dsu.map();
        return map.size()-1;
    }
    
    int index(int i, int j) {
        return i*n+ j;
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
