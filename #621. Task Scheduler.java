// My approach required constant updations in the data still i choose priority queue which was a mistake. Still the code works fine but is
// inefficient. 

class Task
{
    int cool_down_time;
    char key;
    int instance;

    Task(char key, int instance)
    {
        cool_down_time=0;
        this.key= key;
        this.instance= instance;
    }
}

class Solution
{
    public int leastInterval(char[] tasks, int n)
    {
        int time=0;
        Comparator<Task> comp= new Comparator<Task>()
        {
            public int compare(Task t1, Task t2)
            {
                if(t1.cool_down_time- t2.cool_down_time!=0)
                    return t1.cool_down_time- t2.cool_down_time;
                else
                    return t2.instance- t1.instance;
            }
        };

        PriorityQueue<Task> q= new PriorityQueue<>(comp);
        int[] map=new int[26];

        for(char c: tasks)
            map[c- 'A']++;

        for(int i=0;i<map.length;i++)
        {
            if(map[i]==0)
                continue;
            else
            {
                Task temp= new Task((char)(i+'A'), map[i]);
                q.add(temp);
            }
        }

        while(!q.isEmpty())
        {
            Task t= q.poll();
            //System.out.println(t.key);
            if(t.cool_down_time==0)
            {
                t.cool_down_time= n;
                t.instance--;
                //System.out.println("reduced\n");
            }
            else
                t.cool_down_time--;
            
            for(Task i: q)
            {
                if(i.cool_down_time>0)
                    i.cool_down_time--;
            }
            
            PriorityQueue<Task> temp= new PriorityQueue<>(comp);
            temp.addAll(q);
            
            q= new PriorityQueue<Task>(comp);
            q.addAll(temp);
            
            if(t.instance>0)q.add(t);
            time++;
        }

        return time;
    }
}
