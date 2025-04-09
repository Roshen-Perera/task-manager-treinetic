package lk.ijse.backend.service;

import lk.ijse.backend.dto.TaskStatus;
import lk.ijse.backend.dto.impl.TaskDTO;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);
    List<TaskDTO> getAllTasks();
    TaskStatus getTask(String taskId);
    void deleteTask(String taskId);
    void updateTask(String taskId, TaskDTO taskDTO);
}
