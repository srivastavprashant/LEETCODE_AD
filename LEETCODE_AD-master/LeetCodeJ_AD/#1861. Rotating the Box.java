package LeetCodeJ;// #1861. Rotating the Box


class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char[][] ans= new char[box[0].length][box.length];
        
        for(int i=box.length-1;i>=0;i--) {
            for(int j= 0;j<box[0].length;j++) {
                ans[j][box.length-i-1]= box[i][j];
            }
        }
        
        for(int j=0;j<ans[0].length;j++) {
            for(int i= ans.length-1;i>=0;i--) {
                if(ans[i][j]== '#') {
                    
                    int k= i+1;
                    while(k!= ans.length) {
                        if(ans[k][j]== '.') {
                            char temp= ans[k][j];
                            ans[k][j]= ans[k-1][j];
                            ans[k-1][j]= temp;
                        }
                        else {
                            break;
                        }
                        k++;
                    }
                    
                }
            }
        }
        
        return ans;
    }
}
