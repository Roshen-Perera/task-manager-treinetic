package lk.ijse.backend.service.impl;

import lk.ijse.backend.dto.TaskStatus;
import lk.ijse.backend.dto.impl.TaskDTO;
import lk.ijse.backend.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public void saveTask(TaskDTO noteDTO) {

    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return List.of();
    }

    @Override
    public TaskStatus getTask(String noteId) {
        return null;
    }

    @Override
    public void deleteTask(String noteId) {

    }

    @Override
    public void updateTask(String noteId, TaskDTO noteDTO) {

    }
}
