package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Employee")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

//    AccountID					TINYINT UNSIGNED PRIMARY KEY,
//    WorkingNumberOfYear 		TINYINT UNSIGNED NOT NULL,
//    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID)

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    public Employee() {
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short managementNumberOfYear) {
        this.workingNumberOfYear = managementNumberOfYear;
    }
}
