package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

//    TypeID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
//    TypeName 		ENUM('0','1') NOT NULL UNIQUE KEY -- 0:  Esay, 1: Multiple-Choice

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "TypeName", nullable = false, unique = true)
    @Convert(converter = TypeNameConverter.class)
    private TypeName name;

    @OneToMany(mappedBy = "typeQuestion")
    List<Question> questions;

    public TypeQuestion() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public TypeName getName() {
        return name;
    }

    public void setName(TypeName name) {
        this.name = name;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public enum TypeName {
        ESSAY("0"), MULTIPLE_CHOICE("1");

        private String typeNameSQL;

        private TypeName(String typeNameSQL) {
            this.typeNameSQL = typeNameSQL;
        }

        public String getTypeNameSQL() {
            return typeNameSQL;
        }

        public static TypeQuestion.TypeName toEnum(String typeNameSQL) {
            for (TypeQuestion.TypeName typeName : TypeQuestion.TypeName.values()) {
                if (typeName.getTypeNameSQL().equals(typeNameSQL)) {
                    return typeName;
                }
            }
            return null;
        }
    }
}
