package lk.ijse.backend.dao;

import lk.ijse.backend.entity.impl.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDAO extends JpaRepository<Task, String> {

}
