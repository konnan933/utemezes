import java.util.ArrayList;

public abstract class Utemezo {
    ArrayList<Task> taskok = new ArrayList<>();

    public Utemezo (ArrayList<Task> taskok){
        this.taskok = taskok;
    }

    public abstract String utemez();

    public abstract String waitTimeToString();
}
