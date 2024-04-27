import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RR extends Utemezo {

    static int timeSlice;
    private ArrayList<Task> runningTaskok = new ArrayList<>();
    public RR(ArrayList<Task> taskok, int timeSlice) {
        super(taskok);
        this.runningTaskok =(ArrayList<Task>) taskok.clone();
        this.timeSlice = timeSlice;
    }

    @Override
    public String utemez() {
        String sorrend = "RR:\n";
        int waitTime = 0;
        while (!allTasksDone(taskok)) {
            Task currentTask = runningTaskok.remove(0);
            sorrend += currentTask.name;
            setWaitTime(runningTaskok, currentTask);
            currentTask.length -= decideTime(currentTask);
            waitTime += 2;
            if (currentTask.length > 0) {
                runningTaskok.add(whereToAdd(waitTime),currentTask);
            }else{
                currentTask.done = true;
            }
        }
        sorrend += waitTimeToString();
        return sorrend.toString();
    }
    public int whereToAdd(int start){
        int i = 0;
        while (runningTaskok.size() > i && taskok.get(i).start <= start) {
            i++;
        }
        if (runningTaskok.size() <= start) {
            return i;
        }
        return i-1;
    }

    public static boolean allTasksDone(ArrayList<Task> tasks) {
        for (Task task : tasks) {
            if (!task.done) return false;
        }
        return true;
    }

    public static void setWaitTime(ArrayList<Task> tasks,Task currentTask) {
        for (Task task : tasks) {
            if (!task.equals(currentTask)) {
                task.waitTime += decideTime(currentTask);
            }
        }
    }

    public static int decideTime(Task currentTask){
        if (currentTask.length < timeSlice) {
            return currentTask.length;
        }else{
            return timeSlice;
        }
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : taskok) {
            task.waitTime -= task.start;
            sorrend_ido += task.name+": "+task.waitTime+" ";
        }
        return sorrend_ido;

    }

}
