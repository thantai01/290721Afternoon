package service.motortype;

import model.MotorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MotorTypeRepository;

import java.util.Optional;
@Service
public class MotorTypeServiceImpl implements IMotorTypeService{
    @Autowired
    private MotorTypeRepository motorTypeRepository;
    @Override
    public Iterable<MotorType> findAll() {
        return motorTypeRepository.findAll();
    }

    @Override
    public Optional<MotorType> findById(Long id) {
        return motorTypeRepository.findById(id);
    }

    @Override
    public void save(MotorType motorType) {
        motorTypeRepository.save(motorType);
    }

    @Override
    public void delete(Long id) {
        motorTypeRepository.deleteById(id);
    }
}
