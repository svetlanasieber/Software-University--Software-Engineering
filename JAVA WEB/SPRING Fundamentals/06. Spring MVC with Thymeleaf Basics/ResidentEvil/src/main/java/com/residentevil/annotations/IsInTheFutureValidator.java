package com.residentevil.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class IsInTheFutureValidator implements ConstraintValidator<IsInTheFuture, Date> {

    public void initialize(IsInTheFuture constraint) { }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
        if(date == null){
            return false;
        }

        Date currentDate = new Date();
        return date.after(currentDate);
    }
}