package com.vti.entity;

import com.vti.repository.DepartmentRepository;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Account`")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Department

//    AccountID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    Email					VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
//    Username				VARCHAR(50) NOT NULL UNIQUE KEY, -- Cannot update this field
//    FirstName				NVARCHAR(50) NOT NULL,
//    LastName				NVARCHAR(50) NOT NULL,	-- create field fullName in POJO
//    DepartmentID 			TINYINT UNSIGNED NOT NULL,	-- Set default waiting
//    PositionID				TINYINT UNSIGNED NOT NULL,	-- Set default Dev
//    SalaryID				TINYINT UNSIGNED NOT NULL, -- Set default 600
//    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
//    FOREIGN KEY(DepartmentID) REFERENCES Department(DepartmentID),
//    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID),
//    FOREIGN KEY(SalaryID) REFERENCES `Salary`(SalaryID)

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;

    @Formula("CONCAT(FirstName, ' ', LastName)")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    @ColumnDefault("11")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    @ColumnDefault("1")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "SalaryID", nullable = false)
    @ColumnDefault("1")
    private Salary salary;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToOne(mappedBy = "creator")
    private Question question;

    @OneToMany(mappedBy = "creator")
    private List<Group> createdGroups;

    @OneToMany(mappedBy = "creator")
    private List<Exam> exams;

    @OneToMany(mappedBy = "account")
    List<GroupAccount> groupAccounts;

    public Account() {
        departmentRepository = new DepartmentRepository();
    }

    public Account(String email) {
        this.email = email;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Group> getCreatedGroups() {
        return createdGroups;
    }

    public void setCreatedGroups(List<Group> createdGroups) {
        this.createdGroups = createdGroups;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<GroupAccount> getGroupAccounts() {
        return groupAccounts;
    }

    public void setGroupAccounts(List<GroupAccount> groupAccounts) {
        this.groupAccounts = groupAccounts;
    }

    @PrePersist
    public void setDefaultValues() {
        if (this.department == null) {
            this.department = new Department();
            this.department.setId((short) 11);
        }

        if (this.position == null) {
            this.position = new Position();
            this.position.setId((short) 1);
        }

        if (this.salary == null) {
            this.salary = new Salary();
            this.salary.setId((short) 1);
        }
    }

}
