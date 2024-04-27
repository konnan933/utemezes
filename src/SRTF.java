import java.util.ArrayList;

public class SRTF extends Utemezo {

    ArrayList<Task> runningTaskok = new ArrayList<>();
    ArrayList<Task> originalTasks = new ArrayList<>();

    public SRTF(ArrayList<Task> taskok) {
        super(taskok);
        deepCopieTasks(originalTasks);
    }

    @Override
    public String utemez() {
        String sorrend = "";
        int varHossz = 0;
        for (int i = 1; i <= getFullLength(taskok); i++) {
            Task shortest =  getShortest(taskok, varHossz);
            int shortestIndex = findIndexByName(taskok, shortest);

            
            taskok.get(shortestIndex).length--;
            
            if (sorrend.length() != 0 && Character.toString(sorrend.charAt(sorrend.length()-1)) != shortest.name) {
                sorrend += shortest.name;
            }else if (sorrend.length() == 0){
                sorrend += shortest.name;
            }
            addWaitTime(shortest);
            varHossz++;
            if (taskok.get(shortestIndex).length == 0) {
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
            if(task.name != shortest.name){
                task.waitTime++;
            }
        }
    }

    public int getFullLength(ArrayList<Task> taskok){
        int osszesen = 0;
        for (Task task : taskok) {
            osszesen += task.length;
        }
        
        return osszesen;
    }

    public int findIndexByName(ArrayList<Task> holKeres, Task keresendo){
        int i = 0;
        while (i < holKeres.size() && !(holKeres.get(i).name == keresendo.name)) {
            i++;
        }
        return i;
    }

    public void deepCopieTasks(ArrayList<Task> hova){
        for (Task task : taskok) {
            hova.add(new Task(task));
        }
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
