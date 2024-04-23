import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RR extends Utemezo {

    static int timeSlice;
    private ArrayList<Task> runningTaskok;
    public RR(ArrayList<Task> taskok, int timeSlice) {
        super(taskok);
        this.runningTaskok =(ArrayList<Task>) taskok.clone();
        this.timeSlice = timeSlice;
    }

    @Override
    public String utemez() {
        String sorrend = "";
        while (!allTasksDone(runningTaskok)) {
            Task currentTask = runningTaskok.remove(0);
            sorrend += currentTask.name;
            setWaitTime(runningTaskok, currentTask);
            currentTask.length -= decideTime(currentTask);
            if (currentTask.length > 0) {
                runningTaskok.add(currentTask);
            }else{
                currentTask.done = true;
            }

            
        }
        sorrend += waitTimeToString();
        return sorrend.toString();
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
            sorrend_ido += " "+task.name+": "+task.waitTime;
        }
        return sorrend_ido;

    }

}
