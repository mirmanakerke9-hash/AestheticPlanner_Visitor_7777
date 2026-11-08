package aestheticplanner;

import java.util.Objects;

public class Habit implements PlannerItem {
    private final String name;
    private final int completedDays;
    private final int targetDaysPerWeek;

    public Habit(String name, int completedDays, int targetDaysPerWeek) {
        this.name = Objects.requireNonNull(name, "name");
        if (completedDays < 0 || targetDaysPerWeek < 1 || targetDaysPerWeek > 7) {
            throw new IllegalArgumentException("Invalid habit progress or weekly target.");
        }
        this.completedDays = completedDays;
        this.targetDaysPerWeek = targetDaysPerWeek;
    }

    public String getName() { return name; }
    public int getCompletedDays() { return completedDays; }
    public int getTargetDaysPerWeek() { return targetDaysPerWeek; }

    @Override
    public void accept(PlannerVisitor visitor) {
        visitor.visitHabit(this);
    }
}
