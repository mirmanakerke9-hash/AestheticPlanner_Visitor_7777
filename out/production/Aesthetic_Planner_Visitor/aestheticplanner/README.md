# Aesthetic Planner – Visitor Pattern 

## Project idea
Aesthetic Planner is a small productivity organizer. It stores three kinds of planner
items: tasks, habits, and events. The Visitor pattern adds operations to these items
without putting those operations into the element classes.

## Structure
- `PlannerItem` – Element interface with `accept(PlannerVisitor visitor)`.
- `Task`, `Habit`, `Event` – Concrete Elements.
- `PlannerVisitor` – Visitor interface with one method for each element type.
- `ProductivityVisitor` – Concrete Visitor that calculates a productivity overview.
- `MarkdownExportVisitor` – Concrete Visitor that exports planner items as Markdown.
- `Main` – creates the object structure and traverses it with both visitors.



## Where double dispatch happens
The client calls `item.accept(visitor)`. At runtime, the concrete element's
`accept` method is selected. For example, `Task.accept` calls
`visitor.visitTask(this)`. The visitor then executes the method matching the
concrete element type. This is double dispatch: the operation depends on both
the concrete element and the concrete visitor.

There are no `instanceof` checks or type-checking chains.

## Clean Code principles used
1. **Meaningful names:** `Task`, `Habit`, and `Event` describe elements; names ending
   in `Visitor` describe operations.
2. **Single Responsibility Principle:** each visitor performs one operation:
   productivity analysis or Markdown export.
3. **Open/Closed Principle:** new operations can be added as new visitors without
   editing the existing element classes.
4. **Polymorphism instead of type checks:** `accept` and `visitX` provide double
   dispatch; no `instanceof` chain is needed.
5. **Encapsulation:** element fields are private and final. Visitors use public
   getters rather than directly changing internal state.
6. **Input validation:** constructors reject invalid priorities and habit targets,
   keeping objects in a valid state.

## Encapsulation trade-off
A Visitor needs access to the data required for its operation. This implementation
uses read-only getters. It exposes only the values needed by the visitors and does
not allow them to modify element state.

## Extensibility demonstration
A third operation, such as `WeeklyScheduleVisitor`, can be added by implementing
`PlannerVisitor`. The `Task`, `Habit`, and `Event` classes do not need to change.
The new visitor must implement all three `visitX` methods.

The trade-off of the classic Visitor pattern is that adding a new element type
requires updating the visitor interface and every concrete visitor.
