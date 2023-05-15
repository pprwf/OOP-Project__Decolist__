

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskListModel {

    private List<Task> tasks;
    private List<TaskListener> listeners;

    public TaskListModel() {
        tasks = new ArrayList<>();
        listeners = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyListeners(task);
    }

    private void notifyListeners(Task task) {
        for (TaskListener listener : listeners) {
            listener.taskAdded(task);
        }
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public void addListener(TaskListener listener) {
        listeners.add(listener);
    }

    public void removeListener(TaskListener listener) {
        listeners.remove(listener);
    }
}
