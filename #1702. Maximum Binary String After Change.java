// #1702. Maximum Binary String After Change



class Solution 
{
    public String maximumBinaryString(String binary)
    {
        char[] arr= binary.toCharArray();
        
        int count= 0;
        for(char c: arr)
            if(c== '0')
                count++;
        
        if(count== 1 || count== 0)
            return new String(arr);
        else
        {
            int index= -1;
            for(int i=0;i<arr.length;i++)
                if(arr[i]== '0')
                { index= i; break; }
            
            for(int i=0;i<arr.length;i++)
                arr[i]= '1';
            
            arr[index+ count-1]= '0';
            return new String(arr);
        }
    }
}
