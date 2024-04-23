import java.util.Comparator;

public class TaskByLengthStart implements Comparator<Task>{

    @Override
    public int compare(Task task1, Task task2) {
        if (task1.length != task2.length) {
            return task1.length - task2.length;
        } else {
            return task1.start - task2.start;
        }
    }
}
