import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String bemenet = "A,0,0,4;B,0,0,5;C,0,1,1;D,0,1,3;E,0,3,1";
    }

    public static ArrayList<Task> stringToTasks(String stringTasks){
        ArrayList<Task> taskok = new ArrayList<>();
        String[] taskSorok  = stringTasks.split(";");

        for (String sor : taskSorok) {
            String[] task = sor.split(",");
            taskok.add(new Task(task[0], Integer.parseInt(task[1]), Integer.parseInt(task[2]), Integer.parseInt(task[3])));
        }
        
        
        
        return null;
        
    }
}
