package ru.kuzmin.secret.core.types;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValue extends CommonValue<Date> {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("");

    public DateValue(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Date parse(String value) throws ParseException {
        return dateFormat.parse(value);
    }


}
