package aestheticplanner;

import java.time.LocalDateTime;
import java.util.Objects;

public class Event implements PlannerItem {
    private final String title;
    private final LocalDateTime start;
    private final String location;

    public Event(String title, LocalDateTime start, String location) {
        this.title = Objects.requireNonNull(title, "title");
        this.start = Objects.requireNonNull(start, "start");
        this.location = Objects.requireNonNull(location, "location");
    }

    public String getTitle() { return title; }
    public LocalDateTime getStart() { return start; }
    public String getLocation() { return location; }

    @Override
    public void accept(PlannerVisitor visitor) {
        visitor.visitEvent(this);
    }
}
