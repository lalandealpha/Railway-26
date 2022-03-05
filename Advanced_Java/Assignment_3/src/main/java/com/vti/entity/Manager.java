package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Manager")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account implements Serializable {
    private static final long serialVersionUID = 1L;

//    AccountID					TINYINT UNSIGNED PRIMARY KEY,
//    ManagementNumberOfYear 		TINYINT UNSIGNED NOT NULL,
//    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID)

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        this.managementNumberOfYear = managementNumberOfYear;
    }
}
