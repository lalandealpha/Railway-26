package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String> {

    @Override
    public String convertToDatabaseColumn(Salary.SalaryName name) {
        if (name == null) {
            return null;
        }
        return name.getSalaryAmount();
    }

    @Override
    public Salary.SalaryName convertToEntityAttribute(String salaryAmount) {
        if (salaryAmount == null) {
            return null;
        }

        return Salary.SalaryName.toEnum(salaryAmount);
    }
}
