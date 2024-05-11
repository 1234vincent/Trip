package demo.repository;

import demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Userrepository extends JpaRepository<User, Integer> {
    // 这里继承JpaRepository已经提供了包括findAll等在内的许多基本方法，无需额外定义
}
