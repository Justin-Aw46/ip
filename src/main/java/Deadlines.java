public class Deadlines extends Task {
    private String time;

    public Deadlines(String description, String time) {
        super(description);
        this.time = time;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.time + ")";
    }
    
}
