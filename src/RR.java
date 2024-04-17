import java.util.ArrayList;

public class RR extends Utemezo {

    int timeSlice;
    ArrayList<Task> varakozoTaskok = new ArrayList<>();
    ArrayList<Task> futottTaskok = new ArrayList<>();

    public RR(ArrayList<Task> taskok, int timeSlice) {
        super(taskok);
        this.timeSlice = timeSlice;
    }

    @Override
    public String utemez() {
        int i = 0;
        int j = 0;
        String sorrend = "";
        while (i < getFullLenght()) {
            for (int k = 0; k < timeSlice; k++) {
                if(j == taskok.size()){
                    j = 0;
                }
                if(varakozoTaskok.size() == 0){

                }
                i++;
            }
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

    private int getFullLenght(){
        int ossz = 0;
        for (Task task : taskok) {
            ossz  += task.length;
        }
        return ossz;
    }
}
