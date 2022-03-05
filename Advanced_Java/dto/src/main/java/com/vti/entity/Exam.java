package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Exam")
@DynamicInsert
public class Exam implements Serializable {
    private static final long serialVersionUID = 1L;

//    ExamID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    `Code`					CHAR(10) NOT NULL,	-- L-1: if duration >= 180p, M-1: if duration >= 90p, S-1: otherwise -- Cannot update this field
//    Title					NVARCHAR(50) NOT NULL,
//    CategoryID				TINYINT UNSIGNED NOT NULL,
//    Duration				TINYINT UNSIGNED NOT NULL DEFAULT 45,
//    CreatorID				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
//    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
//    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
//    FOREIGN KEY(CreatorID) 	REFERENCES `Account`(AccountId)

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Code", length = 10, nullable = false, updatable = false)
    private String code;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @Column(name = "Duration", nullable = false)
    private Short duration;

    @PrePersist
    public void setDefaultValue() {
        if(this.duration == null) {
            duration = 45;
        }

        if (this.duration >= 180) {
            this.code = "L-1";
        } else if (this.duration < 180 && this.duration >= 90) {
            this.code = "M-1";
        } else {
            this.code = "S-1";
        }
    }


    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private CategoryQuestion categoryQuestion;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;

    @ManyToMany(mappedBy = "exams", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions;

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

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Short getDuration() {
        return duration;
    }

    public void setDuration(Short duration) {
        this.duration = duration;
    }
}
