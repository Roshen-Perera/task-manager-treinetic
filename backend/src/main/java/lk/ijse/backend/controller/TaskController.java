package lk.ijse.backend.controller;


import lk.ijse.backend.DataPersistException;
import lk.ijse.backend.dto.TaskStatus;
import lk.ijse.backend.dto.impl.TaskDTO;
import lk.ijse.backend.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    static Logger logger =  LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService taskService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveTask(@RequestBody TaskDTO taskDTO) {
        try {
            logger.info("Saving task");
            taskService.saveTask(taskDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAllTasks() {
        logger.info("Getting all tasks");
        return taskService.getAllTasks();
    }

    @GetMapping(value = "/{taskID}",produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskStatus getSelectedTask(@PathVariable ("taskID") String taskId){
        logger.info("Task fetched");
        return taskService.getTask(taskId);
    }
}
