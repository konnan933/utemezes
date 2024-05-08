import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scr = new Scanner(System.in);
        System.out.println("Kérem adja meg melyik ütemezőt akarja használni!");
        System.out.println("1-est adja ha FCFS\n2-est adja ha RR\n3-ast adja ha SJF\n4-est adja ha SRTF\n0-ast adja ha kilép." );
        String valasz = scr.nextLine();

        
        while (!valasz.equals("0")) {
            if (valasz.equals("1")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                FCFS fcfs = new FCFS(taskok);
                System.out.println(fcfs.utemez()+"\n");
            }else if (valasz.equals("2")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                RR rr = new RR(taskok, 2);
                System.out.println(rr.utemez()+"\n");
            }else if (valasz.equals("3")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                SJF sjf = new SJF(taskok);
                System.out.println(sjf.utemez()+"\n");
            }else if (valasz.equals("4")) {
                ArrayList<Task> taskok = stdin();
                inputTasksToString(taskok);
                SRTF srtf = new SRTF(taskok, taskok);
                System.out.println(srtf.utemez()+"\n");
            }else{
                System.out.println("Rossz bemenet");    
            }
            System.out.println("Kérem adja meg melyik ütemezőt akarja használni!");
            System.out.println("1-est adja ha FCFS\n2-est adja ha RR\n3-ast adja ha SJF\n4-est adja ha SRTF\n0-ast adja ha kilép." );
            valasz = scr.nextLine();
        }

        System.out.println("Ön kilépett!");

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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Task> tasks = new ArrayList<Task>();
        String s;
        while ((s = in.readLine()) != null && s.length() != 0) {
            tasks.add(stringToTasks(s));      
        }
        return tasks; 
    }
}
