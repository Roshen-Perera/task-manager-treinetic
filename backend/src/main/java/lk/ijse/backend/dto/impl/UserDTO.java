package lk.ijse.backend.dto.impl;

import lk.ijse.backend.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements UserStatus {
    private Long id;
    private String username;
    private String password;
}
