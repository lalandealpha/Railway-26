package com.vti.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name ="ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "`Code1`",length = 10, nullable = false, updatable = false)
    private String code1;

    @Column(name = "`Code2`",length = 10, nullable = false, updatable = false)
    private String code2;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @Column(name = "Duration", nullable = false)
    @ColumnDefault("45")
    private short duration;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Exam() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", code1='" + code1 + '\'' +
                ", code2='" + code2 + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", createDate=" + createDate +
                '}';
    }

    @PrePersist
    private void setCode() {
        if (this.duration >= 180) {
            this.setCode1("L-1");
            this.setCode2("L-1");
        } else if (this.duration >= 90 && duration < 180) {
            this.setCode1("M-1");
            this.setCode2("M-1");
        } else {
            this.setCode1("S-1");
            this.setCode2("S-1");
        }
    }
}
