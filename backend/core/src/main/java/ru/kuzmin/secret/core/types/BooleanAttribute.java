package ru.kuzmin.secret.core.types;

import java.text.ParseException;

public class BooleanAttribute extends CommonAttribute<Boolean> {

    public BooleanAttribute(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Boolean parse(String value) {
        return Boolean.valueOf(value);
    }
}
