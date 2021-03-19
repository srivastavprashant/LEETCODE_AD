// #96. Unique Binary Search Trees



// dynamic programming (tabulation).  O(n^2) time complexity
class Solution 
{
    public int numTrees(int n) 
    {
        int[] tab= new int[n+1];
        tab[0]= 1;tab[1]= 1;
        for(int i=2;i<=n;i++)
        {
            for(int j= 0; j< i;j++)
                tab[i]+= tab[i-1-j]*tab[j];
        }
        
        return tab[n];
    }
}

// catalan number= (1/(n+1))* ncr(2*n, n);  O(n) time complexity
class Solution 
{
    public int numTrees(int n) 
    {
        return catalan(n);
    }
    
    int catalan(int n)
    {
        double fact= 1.0d;
        for(int i= n+1;i<=2*n;i++) fact= (fact*i)/(i-n);
        
        return (int )(fact/(n+1));
    }
}
