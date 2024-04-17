import java.util.ArrayList;

public class SJF extends Utemezo {

    ArrayList<Task> runningTaskok;

    public SJF(ArrayList<Task> taskok) {
        super(taskok);
        this.runningTaskok = taskok;
    }

    @Override
    public String utemez() {
        
        String sorrend = "";
         
        for (int i = 0; i < taskok.size(); i++) {
            wait : for (int j = 0; j < taskok.size(); j++) {
                    if(taskok.get(j) == taskok.get(i)){
                        break wait;
                    }else{
                        taskok.get(i).waitTime += taskok.get(j).length;
                    }
                    
            }
            sorrend += taskok.get(i).name;
        }
        sorrend += waitTimeToString();
        return sorrend;
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : taskok) {
            sorrend_ido += " "+task.name+": "+task.waitTime;
        }
        
        return sorrend_ido;
    }

    private void checkLengths(int eddig){
        int i = 0;
        while (i < taskok.size() && taskok.get(i).start <= eddig) {
            if (!taskok.get(i).done) {
                runningTaskok.add(taskok.get(i));
                taskok.get(i).done = true;
            }
        }
        runningTaskok.sort(new TaskByLength());
    }

}
