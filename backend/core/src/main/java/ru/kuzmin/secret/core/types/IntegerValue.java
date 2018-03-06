package ru.kuzmin.secret.core.types;

import java.text.ParseException;

public class IntegerValue extends CommonValue<Integer> {

    public IntegerValue(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Integer parse(String value) {
        return Integer.valueOf(value);
    }
}
