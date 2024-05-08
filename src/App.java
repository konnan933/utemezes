import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        if (args.length > 0) {
            if (args[0].equals("fcfs") ) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                FCFS fcfs = new FCFS(taskok);
                System.out.println(fcfs.utemez()+"\n");
            }else if (args[0].equals("rr")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                RR rr = new RR(taskok, Integer.parseInt(args[1]));
                System.out.println(rr.utemez()+"\n");
            }else if (args[0].equals("sjf")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                SJF sjf = new SJF(taskok);
                System.out.println(sjf.utemez()+"\n");
            }else if (args[0].equals("srtf")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                SRTF srtf = new SRTF(taskok, taskok);
                System.out.println(srtf.utemez()+"\n");
            }else{
                System.out.println("Rossz argumentum");    
            }
        }
    }

    public static void inputTasksToString(ArrayList<Task> tasks){
        System.out.println("Taskok: ");
        for (Task task : tasks) {
            System.out.println(task.name+": "+task.prio+","+task.start+","+task.length+";");
        }
        System.out.println("");
    }

    public static Task stringToTasks(String stringTasks){
        String[] task = stringTasks.split(",");
        return new Task(task[0], Integer.parseInt(task[1]), Integer.parseInt(task[2]), Integer.parseInt(task[3]));
    }

    public static ArrayList<Task> stdin() throws IOException{
        System.out.println("Írja a feladatokat pl: A,0,0,2 formátum fontos!");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Task> tasks = new ArrayList<Task>();
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            tasks.add(stringToTasks(s));      
        }
        return tasks; 
    }
}
