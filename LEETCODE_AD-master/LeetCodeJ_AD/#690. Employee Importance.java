package LeetCodeJ;// BFS

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) 
    {
        Queue<Employee> q=new LinkedList<>();
        HashMap<Integer, Employee> map=new HashMap<>();
        
        for(Employee i: employees)
            map.put(i.id, i);
        
        q.add(map.get(id));
        
        int total_importance=0;
        while(!q.isEmpty())
        {
            Employee curr= q.poll();
            
            total_importance+= curr.importance;
            
            for(int i: curr.subordinates)
                q.add(map.get(i));
        }
        return total_importance;
    }
}
