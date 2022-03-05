package com.vti.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion {
    private static final long serialVersionUID = 1L;

//    CategoryID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    CategoryName			NVARCHAR(50) NOT NULL UNIQUE KEY

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "categoryQuestion")
    private List<Exam> exams;

    @OneToMany(mappedBy = "categoryQuestion")
    private List<Question> questions;

    public CategoryQuestion() {
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

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


}
