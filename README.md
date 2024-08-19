# Task CLI Application

This is a simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks directly from the terminal.

## Features

- **Add a Task:** Add a new task with a description.
- **Update a Task:** Update the description of an existing task.
- **Delete a Task:** Remove a task by its ID.
- **Mark a Task:** Mark a task as "in progress" or "done."
- **List Tasks:** List all tasks or filter them by status (e.g., `todo`, `in progress`, `done`).

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/lephuocloc1729/task_tracker_cli
   cd task_tracker_cli

2. **Compile the source code:**
    ```bash
   javac TaskCLIApp.java Task.java TaskManager.java Status.java
3. **Run the application:**
    ```bash
   java TaskCLIApp <command> [arguments]
   ```
## Usage
```bash
# Adding a new task
java TaskCLIApp add "Buy groceries"
# Output: Task added successfully (ID: 1)

# Updating a task
java TaskCLIApp update 1 "Buy groceries and cook dinner"
# Output: Task updated successfully (ID: 1)

# Deleting a task
java TaskCLIApp delete 1
# Output: Task deleted successfully (ID: 1)

# Marking a task as in progress
java TaskCLIApp mark-in-progress 1
# Output: Task marked as in progress (ID: 1)

# Marking a task as done
java TaskCLIApp mark-done 1
# Output: Task marked as done (ID: 1)

# Listing all tasks
java TaskCLIApp list
# Output: List of all tasks

# Listing tasks by status
java TaskCLIApp list todo
java TaskCLIApp list in-progress
java TaskCLIApp list done

```