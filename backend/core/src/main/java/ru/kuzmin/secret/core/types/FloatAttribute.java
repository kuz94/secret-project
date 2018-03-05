package ru.kuzmin.secret.core.types;

import java.text.ParseException;

public class FloatAttribute extends CommonAttribute<Float> {

    public FloatAttribute(String value, Boolean nullable) throws ParseException {
        super(value, nullable);
    }

    @Override
    protected Float parse(String value) throws ParseException {
        return Float.valueOf(value);
    }
}
