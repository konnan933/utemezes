import java.util.Comparator;

public class TaskByLength implements Comparator<Task>{

    @Override
    public int compare(Task o1, Task o2) {  
        return Integer.compare(o1.length, o2.length);
    }}
