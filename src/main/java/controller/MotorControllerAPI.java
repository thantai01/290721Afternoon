package controller;

import model.Motor;
import model.MotorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.motor.IMotorService;
import service.motortype.IMotorTypeService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MotorControllerAPI {
    @Autowired
    private IMotorService motorService;
    @Autowired
    private IMotorTypeService motorTypeService;

    @GetMapping("/motors")
    public ResponseEntity<Iterable<Motor>> findAll(Pageable pageable) {
        Page<Motor> motorList = motorService.findAll(pageable);
        return new ResponseEntity<>(motorList, HttpStatus.OK);
    }
    @PostMapping("/motors")
    public ResponseEntity<Void> create(@RequestBody Motor motor) {
        motorService.save(motor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/motors/detail/{id}")
    public ResponseEntity<Void> findOne(@PathVariable long id) {
        Optional<Motor> selectedMotor = motorService.findById(id);
        if(!selectedMotor.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/motors/{id}")
    public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody Motor motor) {
        Optional<Motor> selectedMotor = motorService.findById(id);
        if(selectedMotor.isPresent()) {
            motor.setId(id);
            motorService.save(motor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/motors/{id}")
    public ResponseEntity<Motor> delete(@PathVariable long id) {
        Optional<Motor> selectedMotor = motorService.findById(id);
        if(selectedMotor.isPresent()) {
            motorService.delete(id);
            return new ResponseEntity<>(selectedMotor.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/motors/find/{name}")
    public ResponseEntity<Iterable<Motor>> findByName (@PathVariable String name) {
        Iterable<Motor> findList = motorService.findAllByName(name);
        return new ResponseEntity<>(findList,HttpStatus.OK);
    }
    @GetMapping("motors/findByType/{typeName}")
    public ResponseEntity<Iterable<Motor>> findByType(@PathVariable String typeName) {
        for (MotorType motorType : motorTypeService.findAll()) {
            if(motorType.getTypeName().equals(typeName)) {
                Iterable<Motor> findList = motorService.findAllByMotorType(motorType.getId());
                return new ResponseEntity<>(findList,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
