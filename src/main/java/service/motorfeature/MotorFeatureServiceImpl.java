package service.motorfeature;

import model.MotorFeature;
import org.springframework.beans.factory.annotation.Autowired;
import repository.MotorFeatureRepository;

import java.util.Optional;

public class MotorFeatureServiceImpl implements IMotorFeatureService{
    @Autowired
    private MotorFeatureRepository motorFeatureRepository;

    @Override
    public Iterable<MotorFeature> findAll() {
        return motorFeatureRepository.findAll();
    }

    @Override
    public Optional<MotorFeature> findById(Long id) {
        return motorFeatureRepository.findById(id);
    }

    @Override
    public void save(MotorFeature motorFeature) {
        motorFeatureRepository.save(motorFeature);
    }

    @Override
    public void delete(Long id) {
        motorFeatureRepository.deleteById(id);
    }
}
