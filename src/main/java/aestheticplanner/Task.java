package aestheticplanner;

import java.util.Objects;

public class Task implements PlannerItem {
    private final String title;
    private final int priority;
    private final boolean completed;

    public Task(String title, int priority, boolean completed) {
        this.title = Objects.requireNonNull(title, "title");
        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1 and 5.");
        }
        this.priority = priority;
        this.completed = completed;
    }

    public String getTitle() { return title; }
    public int getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    @Override
    public void accept(PlannerVisitor visitor) {
        visitor.visitTask(this);
    }
}
