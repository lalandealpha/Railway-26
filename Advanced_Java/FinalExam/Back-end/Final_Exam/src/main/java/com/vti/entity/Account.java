package com.vti.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "`Account`")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Username", length = 18, nullable = false, unique = true, updatable = false)
    @NonNull
    private String username;

    @Column(name = "`Password`", length = 12, nullable = false)
    @NonNull
    private String password;

    @Column(name = "FirstName", length = 50, nullable = false, updatable = false)
    @NonNull
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false, updatable = false)
    @NonNull
    private String lastName;

    @Formula("CONCAT(FirstName, ' ', LastName)")
    private String fullName;

    @Column(name = "`Role`", nullable = false)
    @Convert(converter = AccountRoleConverter.class)
    @NonNull
    private Role role;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    @NonNull
    private Department department;

    public enum Role {
        ADMIN("Admin"), EMPLOYEE("Employee"), MANAGER("Manager");

        private String roleSQL;

        private Role(String roleSQL) {
            this.roleSQL = roleSQL;
        }

        public String getRoleSQL() {
            return roleSQL;
        }

        public static Role toEnum(String roleSQL) {
            for (Account.Role role : Account.Role.values()) {
                if (role.getRoleSQL().equals(roleSQL)) {
                    return role;
                }
            }
            return null;
        }
    }

}
