public class Task {
    String name;
    int prio;
    int start;
    int length;
    int waitTime;
    boolean done = false;

    public Task(String name, int prio, int start, int length){
        this.name = name;
        this.prio = prio;
        this.start = start;
        this.length = length;
        this.waitTime = 0;
    }

}
