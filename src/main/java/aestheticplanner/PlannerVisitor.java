package aestheticplanner;

public interface PlannerVisitor {
    void visitTask(Task task);
    void visitHabit(Habit habit);
    void visitEvent(Event event);
}
