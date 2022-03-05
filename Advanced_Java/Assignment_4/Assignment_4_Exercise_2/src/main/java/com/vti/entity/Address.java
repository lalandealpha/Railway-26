package com.vti.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

//    AddressID 				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    AddressName 			NVARCHAR(100) NOT NULL UNIQUE KEY

    @Column(name = "AddressID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "AddressName", length = 100, nullable = false, unique = true)
    private String name;

    @OneToOne(mappedBy = "address")
    private DetailDepartment detailDepartment;

    public Address() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DetailDepartment getDetailDepartment() {
        return detailDepartment;
    }

    public void setDetailDepartment(DetailDepartment detailDepartment) {
        this.detailDepartment = detailDepartment;
    }

}
