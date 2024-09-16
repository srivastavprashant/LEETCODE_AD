#1615. Maximal Network Rank

// Approach 1 (13 ms runtime)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) 
    {
        int[] degree= new int[n]; 
        
        // to efficiently calculate the edge between two cities.
        ArrayList<HashSet<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new HashSet<>());
        
        // calculate the degree of each city
        for(int[] road: roads)
        {
            degree[road[0]]++;
            degree[road[1]]++;
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
        
        int max= -1;
        HashSet<Integer> max_set= new HashSet<>();
        for(int i=0;i<degree.length;i++)
        {
            if(max< degree[i])
            { 
                max= degree[i]; 
                max_set= new HashSet<>(); 
                max_set.add(i);
            }
            else if (max== degree[i])
                max_set.add(i);
        }
        
        if(max_set.size()!= 1)
        {
            for(int i: max_set)
            {
                for(int j: max_set)
                {
                    if(i!=j && !adj.get(i).contains(j))
                        return max*2;
                }
            }
            
            return max*2 -1;
        }
        else
        {
            int max_city= 0;
            for(int i: max_set)
                max_city= i;
            
            max= -1;
            for(int i=0;i<degree.length;i++)
            {
                if(max< degree[i] && degree[i]!= degree[max_city])
                { 
                    max= degree[i]; 
                    max_set= new HashSet<>(); 
                    max_set.add(i);
                }
                else if (max== degree[i])
                    max_set.add(i);
            }
            
            for(int i: max_set)
                if(!adj.get(max_city).contains(i))
                    return max+ degree[max_city];
            
            return max+ degree[max_city]-1;
        }
    }
}

// Approach 2 (4 ms runtime)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) 
    {
        int[] degree= new int[n];
        boolean[][] adjacency_matrix= new boolean[n][n];
        for(int[] road: roads)
        {
            degree[road[0]]++;
            degree[road[1]]++;
            adjacency_matrix[road[0]][road[1]]= true;
            adjacency_matrix[road[1]][road[0]]= true;
        }
        
        int max= -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i== j) continue;
                max= Math.max(max, degree[i]+ degree[j]+ (adjacency_matrix[i][j]? -1: 0));
            }
        }
        
        return max;
    }
}

// Approach 3 (3 ms runtime)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) 
    {
        int[] degree= new int[n];
        boolean[][] adjacency_matrix= new boolean[n][n];
        for(int[] road: roads)
        {
            degree[road[0]]++;
            degree[road[1]]++;
            adjacency_matrix[road[0]][road[1]]= true;
            adjacency_matrix[road[1]][road[0]]= true;
        }
        
        int max_degree= -1;
        for(int i=0;i<n;i++)
            max_degree= Math.max(max_degree, degree[i]);
        
        int max= -1;
        for(int i=0;i<n;i++)
        {
            if(degree[i]!= max_degree) continue;
            for(int j=0;j<n;j++)
            {
                if(i== j) continue;
                max= Math.max(max, degree[i]+ degree[j]+ (adjacency_matrix[i][j]? -1: 0));
            }
        }
        
        return max;
    }
}
