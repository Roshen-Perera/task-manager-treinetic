package lk.ijse.backend.util;
import lk.ijse.backend.dto.impl.TaskDTO;
import lk.ijse.backend.dto.impl.UserDTO;
import lk.ijse.backend.entity.impl.Task;
import lk.ijse.backend.entity.impl.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public Task toTaskEntity(TaskDTO userDTO) {
        return modelMapper.map(userDTO, Task.class);
    }
    public TaskDTO toTaskDTO(Task userEntity) {
        return modelMapper.map(userEntity, TaskDTO.class);
    }
    public List<TaskDTO> asTaskDTOList(List<Task> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<TaskDTO>>() {}.getType());
    }

    public User toUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
    public UserDTO toUserDTO(User userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }
    public List<UserDTO> asUserDTOList(List<User> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDTO>>() {}.getType());
    }
}
