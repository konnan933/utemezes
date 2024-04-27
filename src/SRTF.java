import java.util.ArrayList;

public class SRTF extends Utemezo {

    ArrayList<Task> runningTaskok = new ArrayList<>();
    ArrayList<Task> originalTasks = new ArrayList<>();

    public SRTF(ArrayList<Task> taskok, ArrayList<Task> helpTaskok) {
        super(taskok);
        this.originalTasks = helpTaskok;
    }

    @Override
    public String utemez() {
        String sorrend = "";
        int varHossz = 0;
        while (!allTasksDone(originalTasks)) {
            Task shortest =  getShortest(taskok, varHossz);
            int shortestIndex = findIndexByName(taskok, shortest);
                
            taskok.get(shortestIndex).length--;
            
            if (sorrend.length() != 0 && !Character.toString(sorrend.charAt(sorrend.length()-1)).equals(shortest.name)) {
                //System.out.println(Character.toString(sorrend.charAt(sorrend.length()-1)));
                sorrend += shortest.name;
            }else if (sorrend.length() == 0){
                sorrend += shortest.name;
            }
            addWaitTime(shortest);
            varHossz++;
            if (taskok.get(shortestIndex).length <= 0) {
                originalTasks.get(shortestIndex).done = true;
            }
        }
        sorrend += waitTimeToString();
        return sorrend;
    }

    public Task getShortest(ArrayList<Task> taskok, int start){
        runningTaskok.clear();
        for (Task task : originalTasks) {
            if (task.start <= start && !task.done) {
                runningTaskok.add(task);
            }
        }
        runningTaskok.sort(new TaskByLengthStart());
        return runningTaskok.get(0);
    }

    public void addWaitTime(Task shortest){
        for (Task task : originalTasks) {
            if(task.name != shortest.name && !task.done){
                task.waitTime++;
            }
        }
    }

     boolean allTasksDone(ArrayList<Task> tasks) {
        for (Task task : originalTasks) {
            if (!task.done) return false;
        }
        return true;
    }

    public int findIndexByName(ArrayList<Task> holKeres, Task keresendo){
        int i = 0;
        while (i < holKeres.size()-1 && !(holKeres.get(i).name.equals(keresendo.name))) {
            i++;
        }
        return i;
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : originalTasks) {
            task.waitTime -= task.start;
            sorrend_ido += " "+task.name+": "+task.waitTime;
        }
        return sorrend_ido;
    }

}
