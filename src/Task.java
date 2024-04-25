public class Task implements Cloneable {
    String name;
    int prio;
    int start;
    int length;
    int waitTime;
    boolean done = false;

    public Task(Task other) {
        this.name = other.name;
        this.start = other.start;
        this.length = other.length;
        this.waitTime = other.waitTime;
        this.prio = other.prio;
    }

    public Task(String name, int prio, int start, int length){
        this.name = name;
        this.prio = prio;
        this.start = start;
        this.length = length;
        this.waitTime = 0;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public int getPrio() {
        return prio;
    }

    public int getStart() {
        return start;
    }

    public int getWaitTime() {
        return waitTime;
    }

}
