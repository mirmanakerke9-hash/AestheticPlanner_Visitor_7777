package aestheticplanner;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PlannerItem> plannerItems = List.of(
                new Task("Finish Java assignment", 5, true),
                new Task("Read 20 pages", 3, false),
                new Habit("Morning reading", 4, 5),
                new Habit("Daily planning", 6, 7),
                new Event("Robotics meeting", LocalDateTime.of(2026, 11, 10, 16, 30),
                        "School robotics lab")
        );

        ProductivityVisitor productivityVisitor = new ProductivityVisitor();
        MarkdownExportVisitor exportVisitor = new MarkdownExportVisitor();

        for (PlannerItem item : plannerItems) {
            item.accept(productivityVisitor);
        }

        for (PlannerItem item : plannerItems) {
            item.accept(exportVisitor);
        }

        System.out.println(productivityVisitor.getReport());
        System.out.println("MARKDOWN EXPORT");
        System.out.println(exportVisitor.getMarkdown());
    }
}
