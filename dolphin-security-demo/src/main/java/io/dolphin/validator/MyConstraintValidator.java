package io.dolphin.validator;

import io.dolphin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-10-4 20:12
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.greeting("tom");
        System.out.println(value);
        return false;
    }
}
