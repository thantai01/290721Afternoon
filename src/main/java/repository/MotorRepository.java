package repository;

import model.Motor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends PagingAndSortingRepository<Motor,Long> {

    @Query("select motor from Motor motor where motor.pName = ?1")
    Iterable<Motor> findAllByName(String name);

    Iterable<Motor> findAllByMotorTypeId(long id);
}
