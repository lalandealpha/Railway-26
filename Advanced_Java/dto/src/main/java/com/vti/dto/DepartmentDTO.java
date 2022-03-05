package com.vti.dto;

public class DepartmentDTO {
    private short id;
    private String name, address;
    private int accountAmount;

    public DepartmentDTO(short id, String name, String address, int accountAmount) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAccountAmount() {
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
                ", address='" + address + '\'' +
                ", accountAmount=" + accountAmount +
                '}';
    }
}
