package repository;

import model.MotorFeature;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorFeatureRepository extends PagingAndSortingRepository<MotorFeature, Long> {
}
