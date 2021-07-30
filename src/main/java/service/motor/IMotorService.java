package service.motor;

import model.Motor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IGeneralService;

public interface IMotorService extends IGeneralService<Motor> {
    Page<Motor> findAll(Pageable pageable);
    Iterable<Motor> findAllByName(String name);
    Iterable<Motor> findAllByMotorType(long id);
}
