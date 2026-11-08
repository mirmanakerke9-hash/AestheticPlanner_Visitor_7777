package aestheticplanner;

public interface PlannerItem {
    void accept(PlannerVisitor visitor);
}
