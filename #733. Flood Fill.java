// 733. Flood Fill

class Solution 
{
    static boolean[][] seen;
    static void call(int[][] image, int sr, int sc, int newColor)
    {
        if(sr-1>-1 && image[sr-1][sc]== image[sr][sc] && !seen[sr-1][sc])
        { seen[sr-1][sc]= true; call(image, sr-1, sc, newColor); }
        
        if(sr+1<image.length && image[sr+1][sc]== image[sr][sc] && !seen[sr+1][sc])
        { seen[sr+1][sc]= true; call(image, sr+1, sc, newColor); }
        
        if(sc-1>-1 && image[sr][sc-1]== image[sr][sc] && !seen[sr][sc-1])
        { seen[sr][sc-1]= true; call(image, sr, sc-1, newColor); }
        
        if(sc+1<image[0].length && image[sr][sc+1]== image[sr][sc] && !seen[sr][sc+1])
        { seen[sr][sc+1]= true; call(image, sr, sc+1, newColor); }
        
        image[sr][sc]= newColor;        
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) 
    {
        seen= new boolean[image.length][image[0].length];
        seen[sr][sc]= true;
        call(image, sr, sc, newColor);
        
        return image;
    }
}
