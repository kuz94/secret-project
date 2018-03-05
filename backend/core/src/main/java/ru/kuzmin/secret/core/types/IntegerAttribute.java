package ru.kuzmin.secret.core.types;

import java.text.ParseException;

public class IntegerAttribute extends CommonAttribute<Integer> {

    public IntegerAttribute(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Integer parse(String value) {
        return Integer.valueOf(value);
    }
}
