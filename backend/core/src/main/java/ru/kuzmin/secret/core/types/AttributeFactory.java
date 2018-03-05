package ru.kuzmin.secret.core.types;

import ru.kuzmin.secret.core.entity.DataType;

import java.text.ParseException;

public class AttributeFactory {

    public static CommonAttribute createAttribute(DataType type, String value, Boolean nullable) throws ParseException {
        switch (type) {
            case STRING:
                return new StringAttribute(value, nullable);
            case INTEGER:
                return new IntegerAttribute(value, nullable);
            case FLOAT:
                return new FloatAttribute(value, nullable);
            case DATE:
                return new DateAttribute(value, nullable);
            case BOOLEAN:
                return new BooleanAttribute(value, nullable);
            default:
                throw new IllegalArgumentException("Attribute type is unknown");
        }
    }
}
