package aestheticplanner;

public class ProductivityVisitor implements PlannerVisitor {
    private int totalTasks;
    private int completedTasks;
    private int totalHabitDays;
    private int totalHabitTargets;
    private int totalEvents;

    @Override
    public void visitTask(Task task) {
        totalTasks++;
        if (task.isCompleted()) {
            completedTasks++;
        }
    }

    @Override
    public void visitHabit(Habit habit) {
        totalHabitDays += habit.getCompletedDays();
        totalHabitTargets += habit.getTargetDaysPerWeek();
    }

    @Override
    public void visitEvent(Event event) {
        totalEvents++;
    }

    public String getReport() {
        double taskCompletion = totalTasks == 0
                ? 0.0 : (completedTasks * 100.0 / totalTasks);
        double habitConsistency = totalHabitTargets == 0
                ? 0.0 : (totalHabitDays * 100.0 / totalHabitTargets);

        return String.format(
                "PRODUCTIVITY OVERVIEW%n"
                + "Tasks completed: %d/%d (%.1f%%)%n"
                + "Habit progress: %d/%d days (%.1f%%)%n"
                + "Upcoming events in planner: %d%n",
                completedTasks, totalTasks, taskCompletion,
                totalHabitDays, totalHabitTargets, habitConsistency,
                totalEvents
        );
    }
}
