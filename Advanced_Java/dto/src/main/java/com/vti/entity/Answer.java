package com.vti.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

//    AnswerID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    Content					NVARCHAR(100) NOT NULL,
//    QuestionID				TINYINT UNSIGNED NOT NULL,
//    isCorrect				BIT DEFAULT 1,
//    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)

    @Column(name = "AnswerID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    @Column(name = "isCorrect")
    @ColumnDefault("1")
    private boolean isCorrect;

    public Answer() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

}
