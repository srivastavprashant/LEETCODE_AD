// 1598. Crawler Log Folder
class Solution {
    public int minOperations(String[] logs) 
    {
        Stack<String> stack= new Stack<>();
        
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("../"))
            {
                if(!stack.isEmpty())
                    stack.pop();
            }
            else if(!logs[i].equals("./"))
                stack.add("a");
            
            //System.out.println(stack);
        }
        return stack.size();
    }
}
