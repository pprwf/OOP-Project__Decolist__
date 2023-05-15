

public class Main {
    public static void main(String[] args) {
        TaskListModel model = new TaskListModel();
        AddTaskView addTaskView = new AddTaskView(model);
        TaskTableView taskTableView = new TaskTableView(model);
    }
}
