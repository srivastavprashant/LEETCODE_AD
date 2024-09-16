package LeetCodeJ;// #1105. Filling Bookcase Shelves



class Solution 
{
    int[][] memo;
    int dfs(int[][] books, int width, int curr_width, int index, int curr_height)
    {
        if(curr_width> width) return 10000000;
        else if(index== books.length) return curr_height;
        else if(memo[index][curr_width]!= 0) return memo[index][curr_width];
        else
        {
            int height= Integer.MAX_VALUE;
            if(curr_height< books[index][1] || curr_width+ books[index][0]> width)
                height= curr_height+ dfs(books, width, books[index][0], index+1, books[index][1]);
            
            curr_height= Math.max(curr_height, books[index][1]);
            height= Math.min(height, dfs(books, width, curr_width+ books[index][0], index+1, curr_height));
            memo[index][curr_width]= height;
            
            return height;
        }
    }
    
    public int minHeightShelves(int[][] books, int shelf_width) {
        memo= new int[books.length][shelf_width+1];
        return dfs(books, shelf_width, 0, 0, books[0][1]);
    }
}
