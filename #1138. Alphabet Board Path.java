// 1138. Alphabet Board Path
class Solution {
    public String alphabetBoardPath(String target) 
    {
        StringBuilder br=new StringBuilder("");
        int curr_row=0, curr_col=0, z=0;
    
        for(char c: target.toCharArray())
        {
            if(curr_row== 5 && c=='z')
            {
                br.append('!');
                continue;
            }
            if(c=='z') 
            {
                z=1;
                c='u';
            }
            
            int row= (c-'a')/5;
            char add= curr_row> row? 'U': 'D';
        
            while(row!= curr_row)
            {
                br.append(add);
                if(row< curr_row)
                    curr_row--;
                else
                    curr_row++;
            }
            
            row= (c-'a')%5;
            add= curr_col> row? 'L': 'R';
        
            while(row!= curr_col)
            {
                br.append(add);
                if(row< curr_col)
                    curr_col--;
                else 
                    curr_col++;
            }
            
            if(1==z)
            {
                br.append('D');
                z=0;
                curr_row++;
            }
            br.append('!');
        }
        
        return br.toString();
    }
}
