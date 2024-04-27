import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String bemenet = "A,0,0,4;B,0,0,5;C,0,1,1;D,0,1,3;E,0,3,1";
        Scanner scr = new Scanner(System.in);
        System.out.println("Kérem adja meg melyik ütemezőt akarja használni?");
        System.out.println("1-est adja ha FCFS\n2-est adja ha RR\n3-ast adja ha SJF\n4-est adja ha SRTF\n0-ast adja ha kilép." );
        String valasz = scr.nextLine();

        FCFS fcfs = new FCFS(stringToTasks(bemenet));
        SJF sjf = new SJF(stringToTasks(bemenet));
        RR rr = new RR(stringToTasks(bemenet), 2);
        SRTF srtf = new SRTF(stringToTasks(bemenet), stringToTasks(bemenet));

        ArrayList<Task> arrBemenet = stringToTasks(bemenet);
        while (!valasz.equals("0")) {
            inputTasksToString(arrBemenet);
            if (valasz.equals("1")) {
                System.out.println(fcfs.utemez()+"\n");
            }else if (valasz.equals("2")) {
                System.out.println(rr.utemez()+"\n");
            }else if (valasz.equals("3")) {
                System.out.println(sjf.utemez()+"\n");
            }else if (valasz.equals("4")) {
                System.out.println(srtf.utemez()+"\n");
            }else{
                System.out.println("Rossz bemenet");    
            }
            System.out.println("Kérem adja meg melyik ütemezőt akarja használni?");
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

    public static ArrayList<Task> stringToTasks(String stringTasks){
        ArrayList<Task> taskok = new ArrayList<>();
        String[] taskSorok  = stringTasks.split(";");

        for (String sor : taskSorok) {
            String[] task = sor.split(",");
            taskok.add(new Task(task[0], Integer.parseInt(task[1]), Integer.parseInt(task[2]), Integer.parseInt(task[3])));
        }
        
        
        
        return taskok;
        
    }
}
