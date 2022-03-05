package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeNameConverter implements AttributeConverter<TypeQuestion.TypeName, String> {

    @Override
    public String convertToDatabaseColumn(TypeQuestion.TypeName salaryName) {
        if (salaryName == null) {
            return null;
        }
        return salaryName.getTypeNameSQL();
    }

    @Override
    public TypeQuestion.TypeName convertToEntityAttribute(String typeNameSQL) {
        if (typeNameSQL == null) {
            return null;
        }

        return TypeQuestion.TypeName.toEnum(typeNameSQL);
    }
}
