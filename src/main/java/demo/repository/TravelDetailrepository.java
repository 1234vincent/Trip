package demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.model.TravelDetail;

public interface TravelDetailrepository extends JpaRepository<TravelDetail, Integer> {
    Optional<TravelDetail> findById(Long id);
}
