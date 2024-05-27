package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.google.protobuf.Option;

import java.util.Optional;
import demo.model.Travel;
public interface Triprepository extends JpaRepository<Travel, Integer>{
    Optional<Travel> findById(Long id);
}
