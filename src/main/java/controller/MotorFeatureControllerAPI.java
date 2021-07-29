package controller;

import model.MotorFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.motorfeature.IMotorFeatureService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MotorFeatureControllerAPI {
    @Autowired
    private IMotorFeatureService motorFeatureService;

    @GetMapping("/motor-features")
    public ResponseEntity<Iterable<MotorFeature>> findAll() {
        Iterable<MotorFeature> featureList = motorFeatureService.findAll();
        return new ResponseEntity<>(featureList, HttpStatus.OK);
    }

    @GetMapping("/motor-features/{id}")
    public ResponseEntity<Void> findOne(@PathVariable long id) {
        return new ResponseEntity(motorFeatureService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/motor-features")
    public ResponseEntity<Void> created(@RequestBody MotorFeature motorFeature) {
        motorFeatureService.save(motorFeature);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/motor-feature/{id}")
    public ResponseEntity<Void> edit(@PathVariable long id,@RequestBody MotorFeature motorFeature) {
        Optional<MotorFeature> selectedItem = motorFeatureService.findById(id);
        if(selectedItem.isPresent()) {
            motorFeature.setId(id);
            motorFeatureService.save(motorFeature);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/motor-feature/{id}")
    public ResponseEntity<MotorFeature> delete(@PathVariable long id) {
        Optional<MotorFeature> selectedItem = motorFeatureService.findById(id);
        if(selectedItem.isPresent()){
            motorFeatureService.delete(id);
            return new ResponseEntity<>(selectedItem.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
