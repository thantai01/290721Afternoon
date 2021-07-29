package formatter;

import model.MotorFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import service.motorfeature.IMotorFeatureService;

import java.text.ParseException;
import java.util.Locale;

public class MotorFeatureFormatter implements Formatter<MotorFeature> {
    IMotorFeatureService motorFeatureService;
    @Autowired
    public MotorFeatureFormatter(IMotorFeatureService motorFeatureService) {
        this.motorFeatureService = motorFeatureService;
    }
    @Override
    public MotorFeature parse(String text, Locale locale) throws ParseException {
        return this.motorFeatureService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(MotorFeature object, Locale locale) {
        return null;
    }
}
