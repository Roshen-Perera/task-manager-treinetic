package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserDAO extends JpaRepository<User,String> {
    Optional<User> findByEmail(String username);
}
