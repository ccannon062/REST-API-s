package com.todoexample.todolist;

import java.util.List;

public interface TaskService {
    List<Task> getTasks();
    Task getTaskById(Long id);
    Task createTask(Task task);
    void deleteTask(Long id);
    Task updateTask(Long id, Task updatedTask);
}
