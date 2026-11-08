package aestheticplanner;

import java.time.format.DateTimeFormatter;

public class MarkdownExportVisitor implements PlannerVisitor {
    private final StringBuilder markdown = new StringBuilder(" My Aesthetic Planner\n");
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm");

    @Override
    public void visitTask(Task task) {
        String status = task.isCompleted() ? "Done" : "To do";
        markdown.append("- [").append(task.isCompleted() ? "x" : " ")
                .append("] ").append(task.getTitle()).append(" ")
                .append(" – Priority: ").append(task.getPriority())
                .append("/5 | ").append(status).append("\n");
    }

    @Override
    public void visitHabit(Habit habit) {
        markdown.append("- Habit: ").append(habit.getName())
                .append(" – ").append(habit.getCompletedDays())
                .append("/").append(habit.getTargetDaysPerWeek())
                .append(" days this week\n");
    }

    @Override
    public void visitEvent(Event event) {
        markdown.append("- Event: ").append(event.getTitle())
                .append(" – ").append(event.getStart().format(DATE_FORMAT))
                .append(" | Location: ").append(event.getLocation()).append("\n");
    }

    public String getMarkdown() {
        return markdown.toString();
    }
}
