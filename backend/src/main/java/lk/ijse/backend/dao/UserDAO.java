package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDAO extends JpaRepository<User, String> {
}
