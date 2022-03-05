package com.vti.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "`Group`")
public class Group {
    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private int id;

    @Column(name = "`name`", length = 50, nullable = false, unique = true)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "createDate", length = 10, nullable = false)
    private Date createDate;

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
