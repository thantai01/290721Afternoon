package controller;

import model.MotorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.motortype.IMotorTypeService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MotorTypeControllerAPI {
    @Autowired
    IMotorTypeService motorTypeService;

    @GetMapping("/motor-types")
    @ModelAttribute("motorType")
    public ResponseEntity<Iterable<MotorType>> findAll() {
        Iterable<MotorType> motorTypes = motorTypeService.findAll();
        return new ResponseEntity<>(motorTypes, HttpStatus.OK);
    }
    @PostMapping("/motor-types")
    public ResponseEntity<Void> create(@RequestBody MotorType motorType) {
        motorTypeService.save(motorType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/motor-types/{id}")
    public ResponseEntity<Void> edit(@PathVariable long id, @RequestBody MotorType motorType) {
        Optional<MotorType> selectedItem = motorTypeService.findById(id);
        if(selectedItem.isPresent()) {
            motorType.setId(id);
            motorTypeService.save(motorType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/motor-types/{id}")
    public ResponseEntity<MotorType> delete(@PathVariable long id) {
        Optional<MotorType> selectedItem = motorTypeService.findById(id);
        if(selectedItem.isPresent()) {
            motorTypeService.delete(id);
            return new ResponseEntity<>(selectedItem.get(),HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
