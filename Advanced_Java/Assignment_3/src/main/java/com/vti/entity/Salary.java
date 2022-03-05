package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

//    SalaryID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    SalaryName			ENUM('600','700','1500','2000') NOT NULL UNIQUE KEY -- 600: Dev, Test: 700, Scrum Master: 1500, PM: 2000

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "SalaryName")
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName name;

    @OneToMany(mappedBy = "salary")
    private List<Account> accounts;

    public Salary() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public SalaryName getName() {
        return name;
    }

    public void setName(SalaryName name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
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
