import java.util.ArrayList;
import java.util.Collections;

public class FCFS extends Utemezo {

    public FCFS(ArrayList<Task> taskok) {
        super(taskok);
    }

    @Override
    public String utemez() {    
        
        String sorrend = "FCFS:\n";
        
        for (int i = 0; i < taskok.size(); i++) {
            wait : for (int j = 0; j < taskok.size(); j++) {
                    if(taskok.get(j) == taskok.get(i)){
                        break wait;
                    }else{
                        taskok.get(i).waitTime += taskok.get(j).length;
                    }
                    
            }
            taskok.get(i).waitTime -= taskok.get(i).start;
            sorrend += taskok.get(i).name;
        }
        sorrend += waitTimeToString();
        return sorrend; 

        
        
    }

    @Override
    public String waitTimeToString() {
        String sorrend_ido = "\n";
        for (Task task : taskok) {
            sorrend_ido += task.name+":"+task.waitTime+" ";
        }
        
        return sorrend_ido;

    }

}
