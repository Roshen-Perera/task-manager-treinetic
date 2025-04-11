package lk.ijse.backend.dto.impl;

import lk.ijse.backend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO implements TaskStatus {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String createdAt;
}
