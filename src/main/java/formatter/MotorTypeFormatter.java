package formatter;

import model.MotorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.motortype.IMotorTypeService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class MotorTypeFormatter implements Formatter<MotorType> {
    IMotorTypeService motorTypeService;

    @Autowired
    public MotorTypeFormatter (IMotorTypeService motorTypeService) {
        this.motorTypeService = motorTypeService;
    }

    @Override
    public MotorType parse(String text, Locale locale) throws ParseException {
        return this.motorTypeService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(MotorType object, Locale locale) {
        return null;
    }
}
