import java.util.ArrayList;


public class SJF extends Utemezo {

    ArrayList<Task> runningTaskok = new ArrayList<>();

    public SJF(ArrayList<Task> taskok) {
        super(taskok);
    }

    @Override
    public String utemez() {

        String sorrend = "SJF:\n";
        int varHossz = 0;
        for (int i = 1; i <= taskok.size(); i++) {
            Task shortest =  getShortest(taskok, varHossz);
            sorrend += shortest.name;
            shortest.waitTime += varHossz;
            varHossz += shortest.length;
        }
        sorrend += waitTimeToString();
        return sorrend;
    }

    public Task getShortest(ArrayList<Task> taskok, int start){
        runningTaskok.clear();
        for (Task task : taskok) {
            if (task.start <= start && !task.done) {
                runningTaskok.add(task);
            }
        }
        runningTaskok.sort(new TaskByLengthStart());
        runningTaskok.get(0).done = true;
        return runningTaskok.get(0) ;
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : taskok) {
            task.waitTime -= task.start;
            sorrend_ido += task.name+":"+task.waitTime+" ";
        }

        return sorrend_ido;
    }
    

}
