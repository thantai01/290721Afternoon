package repository;

import model.MotorType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorTypeRepository extends PagingAndSortingRepository<MotorType, Long> {
}
