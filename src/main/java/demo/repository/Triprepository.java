package demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Travel;
public interface Triprepository extends JpaRepository<Travel, Integer>{
    
}
