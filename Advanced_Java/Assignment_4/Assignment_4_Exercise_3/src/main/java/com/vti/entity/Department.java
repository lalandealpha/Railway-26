package com.vti.entity;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)
@DynamicInsert
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

//    DepartmentID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    DepartmentName 			NVARCHAR(30) NOT NULL UNIQUE KEY

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "DepartmentName", length = 100, nullable = false, unique = true)
    private String name;

    public Department() {
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

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
