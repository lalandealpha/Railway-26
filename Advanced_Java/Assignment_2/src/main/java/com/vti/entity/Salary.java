package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "SalaryName", length = 10, nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName name;

    public Salary() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public SalaryName getSalaryName() {
        return name;
    }

    public void setSalaryName(SalaryName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public enum SalaryName {
        DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");

        private String salaryAmount;

        private SalaryName(String salaryAmount) {
            this.salaryAmount = salaryAmount;
        }

        public String getSalaryAmount () {
            return salaryAmount;
        }

        public static SalaryName toEnum(String salaryAmount) {
            for (SalaryName name : SalaryName.values()) {
                if (name.getSalaryAmount().equals(salaryAmount)) {
                    return name;
                }
            }
            return null;
        }
    }
}
