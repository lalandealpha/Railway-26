package com.vti.dto;

public class DepartmentDTO {
    private short id;
    private String name;
    private long accountAmount;

    public DepartmentDTO(short id, String name, long accountAmount) {
        this.id = id;
        this.name = name;
        this.accountAmount = accountAmount;
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



    public long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(int accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountAmount=" + accountAmount +
                '}';
    }
}
