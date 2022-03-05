package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

//    GroupID					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    GroupName				NVARCHAR(50) NOT NULL UNIQUE KEY,
//    CreatorID				TINYINT UNSIGNED NOT NULL, -- Cannot update this field
//    CreateDate				DATETIME DEFAULT NOW(), -- Cannot update this field
//    FOREIGN KEY(CreatorID) REFERENCES `Account` (AccountID)

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;

    @OneToMany(mappedBy = "group")
    List<GroupAccount> groupAccounts;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Group() {
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

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account account) {
        this.creator = account;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<GroupAccount> getGroupAccounts() {
        return groupAccounts;
    }

    public void setGroupAccounts(List<GroupAccount> groupAccounts) {
        this.groupAccounts = groupAccounts;
    }

}
