import java.util.Comparator;

public class TaskByStart implements Comparator<Task>{

    @Override
    public int compare(Task o1, Task o2) {  
        return Integer.compare(o1.start, o2.start);
    }}
