package com.vti.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "DepartmentID")
@DynamicInsert
public class DetailDepartment extends Department implements Serializable {
    private static final long serialVersionUID = 1L;

//    DepartmentID 			TINYINT UNSIGNED PRIMARY KEY,
//    AddressID 				TINYINT UNSIGNED, -- UNIQUE KEY,  -- NOT NULL ,
//    EmulationPoint 			TINYINT UNSIGNED,
//    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
//    FOREIGN KEY(AddressID) REFERENCES Address(AddressID)

    @Column(name = "EmulationPoint")
    private short emulationPoint;

    @OneToOne
    @JoinColumn(name = "AddressID", referencedColumnName = "AddressID")
    private Address address;

    public DetailDepartment() {
    }

    public short getEmulationPoint() {
        return emulationPoint;
    }

    public void setEmulationPoint(short emulationPoint) {
        this.emulationPoint = emulationPoint;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
