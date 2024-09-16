package LeetCodeJ;// #17. Letter Combinations of a Phone Number



class Solution 
{
    List<String> ans;
    int[][] code= new int[][]{{}, {}, {97, 98, 99}, {100, 101, 102},
                              {103, 104, 105}, {106, 107, 108}, {109, 110, 111}, 
                              {112, 113, 114, 115}, {116, 117, 118}, {119, 120, 121, 122}};
    void call(char[] arr, int index, char[] combination, int cindex)
    {
        if(index>= arr.length)
        {
            ans.add(new String(combination));
            return;
        }
        for(int i: code[arr[index]-48])
        {
            combination[cindex]= (char)i;
            call(arr, index+1, combination, cindex+1);
        }
    }
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0) return new ArrayList<>();
        ans= new ArrayList<>();
        char[] combination= new char[digits.length()];
        call(digits.toCharArray(), 0, combination, 0);
        
        return ans;
    }
}
