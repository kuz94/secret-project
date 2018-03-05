package ru.kuzmin.secret.core.types;

import java.text.ParseException;

public class StringAttribute extends CommonAttribute<String> {

    StringAttribute(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    public String parse(String value) {
        return value;
    }
}
