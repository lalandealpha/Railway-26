package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Question`")
@DynamicInsert
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

//    QuestionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    Content					NVARCHAR(100) NOT NULL,
//    CategoryID				TINYINT UNSIGNED NOT NULL,
//    TypeID					TINYINT UNSIGNED NOT NULL,
//    CreatorID				TINYINT UNSIGNED NOT NULL UNIQUE KEY, -- Cannot update this field
//    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
//    FOREIGN KEY(CategoryID) 	REFERENCES CategoryQuestion(CategoryID),
//    FOREIGN KEY(TypeID) 		REFERENCES TypeQuestion(TypeID),
//    FOREIGN KEY(CreatorID) 		REFERENCES `Account`(AccountId)

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private CategoryQuestion categoryQuestion;

    @ManyToOne
    @JoinColumn(name = "TypeID", nullable = false)
    private TypeQuestion typeQuestion;

    @OneToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", nullable = false, unique = true, updatable = false)
    private Account creator;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "ExamQuestion",
            joinColumns = { @JoinColumn(name = "QuestionID") },
            inverseJoinColumns = { @JoinColumn(name = "ExamID") }
    )
    private List<Exam> exams;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Question() {
    }

    public Question(String content, Account creator) {
        this.content = content;
        this.creator = creator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public CategoryQuestion getCategoryQuestion() {
        return categoryQuestion;
    }

    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public TypeQuestion getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(TypeQuestion typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


}
