package service.motor;

import model.Motor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repository.MotorRepository;

import java.util.Optional;

public class MotorServiceImpl implements IMotorService{
    @Autowired
    private MotorRepository motorRepository;

    @Override
    public Iterable<Motor> findAll() {
        return motorRepository.findAll();
    }

    @Override
    public Optional<Motor> findById(Long id) {
        return motorRepository.findById(id);
    }

    @Override
    public void save(Motor motor) {
        motorRepository.save(motor);
    }

    @Override
    public void delete(Long id) {
        motorRepository.deleteById(id);
    }

    public Page<Motor> findAll(Pageable pageable) {
        return motorRepository.findAll(pageable);
    }

    public Iterable<Motor> findAllByName(String name) {
        return motorRepository.findAllByName(name);
    }
    public Iterable<Motor> findAllByMotorType(long id) {
        return motorRepository.findAllByMotorTypeId(id);
    }

}
