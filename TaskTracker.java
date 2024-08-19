import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    private final Path FILE_PATH = Path.of("/Users/leloc/PROJECTS/task_tracker_cli/tasks.json");
    private List<Task> tasks;


    public TaskTracker(){
        this.tasks = loadTasks();
    }

    /* read tasks.json file */
    private List<Task> loadTasks(){
        List<Task> stored_tasks = new ArrayList<>();

        if (!Files.exists(FILE_PATH)){
            return new ArrayList<>();
        }

        try {
            String jsonContent = Files.readString(FILE_PATH);
            String[] taskList = jsonContent.replace("[", "")
                                            .replace("]", "")
                                            .split("},");
            for (String taskJson : taskList){
                if (!taskJson.endsWith("}")){
                    taskJson = taskJson + "}";
                    stored_tasks.add(Task.fromJson(taskJson));
                } else {
                    stored_tasks.add(Task.fromJson(taskJson));
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return stored_tasks;
    }

    private void saveTasks() throws IOException {
        if (!Files.exists(FILE_PATH)){
            Files.createFile(FILE_PATH);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < tasks.size(); i++){
            sb.append(tasks.get(i).toJson());
            if (i < tasks.size() - 1){
                sb.append(",\n");
            }
        }
        sb.append("\n]");

        String jsonContent = sb.toString();
        Files.writeString(FILE_PATH, jsonContent);
    }

    public void addTask(String description){
        Task new_task = new Task(description);
        tasks.add(new_task);
    }

    public void updateTask(String id, String new_description){
        Task task = findTask(id);
        task.updateDescription(new_description);
    }

    public void deleteTask(String id){
        Task task = findTask(id);
        tasks.remove(task);
    }

    public void markInProgress(String id){
        Task task = findTask(id);
        task.markInProgress();
    }

    public void markDone(String id){
        Task task = findTask(id);
        task.markDone();
    }

    public void listTasks(String type){
        for (Task task : tasks){
            String status = task.getStatus().toString().strip();
            if (type.equals("All") || status.equals(type)){
                System.out.println(task.toString());
            }
        }
    }

    public void quit(){
        try {
            saveTasks();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Task findTask(String id) throws IllegalArgumentException {
        for (Task task : tasks){
            if (task.getId().equals(id)){
                return task;
            }
        }
        throw new IllegalArgumentException("Task with ID " + id + " not found!");
    }


}
