package lk.ijse.backend.entity.impl;

import jakarta.persistence.*;
import lk.ijse.backend.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User implements SuperEntity, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String username;
    private String password;
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // or Collections.emptyList()
    }

}
