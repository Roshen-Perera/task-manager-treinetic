package lk.ijse.backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.backend.dao.TaskDAO;
import lk.ijse.backend.dto.TaskStatus;
import lk.ijse.backend.dto.impl.TaskDTO;
import lk.ijse.backend.service.TaskService;
import lk.ijse.backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDao;
    @Autowired
    private Mapping fieldMapping;
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
