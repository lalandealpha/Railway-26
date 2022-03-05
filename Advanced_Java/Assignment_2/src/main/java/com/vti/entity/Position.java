package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position")
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "PositionId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "PositionName", length = 20, nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName name;


    public Position() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public enum PositionName {
        Dev, Test, ScrumMaster, PM;
    }
}
