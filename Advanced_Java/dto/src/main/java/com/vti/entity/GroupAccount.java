package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GroupAccount", uniqueConstraints = @UniqueConstraint(columnNames = { "GroupID", "AccountID" }))
@IdClass(GroupAccount.GroupAccountPK.class)
public class GroupAccount implements Serializable {
    private static final long serialVersionUID = 1L;

//    GroupID					TINYINT UNSIGNED NOT NULL,
//    AccountID				TINYINT UNSIGNED NOT NULL,
//    JoinDate				DATETIME DEFAULT NOW(),
//    PRIMARY KEY (GroupID,AccountID),
//    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID),
//    FOREIGN KEY(GroupID) REFERENCES `Group` (GroupID)

    @Column(name = "GroupID")
    @Id
    private short groupId;

    @Column(name = "AccountID")
    @Id
    private short accountId;

    @ManyToOne
    @MapsId("GroupID")
    @JoinColumn(name = "GroupID")
    private Group group;

    @ManyToOne
    @MapsId("AccountID")
    @JoinColumn(name = "AccountID")
    private Account account;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    @Embeddable
    public static class GroupAccountPK implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "GroupID")
        private short groupId;

        @Column(name = "AccountID")
        private short accountId;

        public GroupAccountPK() {
        }

        public short getGroupId() {
            return groupId;
        }

        public void setGroupId(short groupId) {
            this.groupId = groupId;
        }

        public short getAccountId() {
            return accountId;
        }

        public void setAccountId(short accountId) {
            this.accountId = accountId;
        }
    }

    public GroupAccount() {
    }

    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
