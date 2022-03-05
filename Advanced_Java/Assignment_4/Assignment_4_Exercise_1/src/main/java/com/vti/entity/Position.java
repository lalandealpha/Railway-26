package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Position")
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

//    PositionID				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    PositionName			ENUM('Dev','Test','ScrumMaster','PM') NOT NULL UNIQUE KEY

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "PositionName", length = 20, nullable = false, unique = true)
    @Convert(converter = PositionNameConverter.class)
    private PositionName name;

    @OneToMany(mappedBy = "position")
    private List<Account> accounts;

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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }


    public enum PositionName {
        DEV("Dev"), TEST("Test"), SCRUM_MASTER("ScrumMaster"), PM("PM");

        private String sqlPositionName;

        private PositionName(String sqlPositionName) {
            this.sqlPositionName = sqlPositionName;
        }

        public String getSqlPositionName() {
            return sqlPositionName;
        }

        public static PositionName toEnum(String sqlPositionName) {
            for (PositionName positionName : PositionName.values()) {
                if (positionName.getSqlPositionName().equals(sqlPositionName)) {
                    return positionName;
                }
            }
            return null;
        }
    }
}