package lk.ijse.backend.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DataPersistException;
import lk.ijse.backend.controller.TaskController;
import lk.ijse.backend.dao.TaskDAO;
import lk.ijse.backend.dto.TaskStatus;
import lk.ijse.backend.dto.impl.TaskDTO;
import lk.ijse.backend.entity.impl.Task;
import lk.ijse.backend.service.TaskService;
import lk.ijse.backend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    static Logger logger =  LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskDAO taskDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task savedTask = taskDao.save(mapping.toTaskEntity(taskDTO));
        if(savedTask == null){
            throw new DataPersistException("Failed to save task");
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return mapping.asTaskDTOList(taskDao.findAll());
    }

    @Override
    public TaskStatus getTask(String taskId) {
        if(taskDao.existsById(taskId)){
            var task = taskDao.getReferenceById(taskId);
            return mapping.toTaskDTO(task);
        } else {
            logger.info("Task not found");
            return null;
        }
    }

    @Override
    public void deleteTask(String taskId) {

    }

    @Override
    public void updateTask(String taskId, TaskDTO taskDTO) {

    }
}
