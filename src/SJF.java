import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SJF extends Utemezo {

    ArrayList<Task> runningTaskok = new ArrayList<>();

    public SJF(ArrayList<Task> taskok) {
        super(taskok);
    }

    @Override
    public String utemez() {

        String sorrend = "";
        taskok.sort(new TaskByLengthStart());
        int varHossz = 0;
        for (int i = 1; i <= taskok.size(); i++) {
            sorrend += taskok.get(i-1).name;
            taskok.get(i-1).waitTime = varHossz;
            varHossz += taskok.get(i-1).length;
            
            
        }
        sorrend += waitTimeToString();
        return sorrend;
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : taskok) {
            sorrend_ido += " " + task.name + ": " + task.waitTime;
        }

        return sorrend_ido;
    }
    

}
