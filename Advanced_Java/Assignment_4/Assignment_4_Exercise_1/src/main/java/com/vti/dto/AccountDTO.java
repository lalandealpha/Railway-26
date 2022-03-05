package com.vti.dto;

public class AccountDTO {
    private long employeeAmount, managerAmount;

    public AccountDTO(long employeeAmount, long managerAmount) {
        this.employeeAmount = employeeAmount;
        this.managerAmount = managerAmount;
    }

    public long getEmployeeAmount() {
        return employeeAmount;
    }

    public void setEmployeeAmount(long employeeAmount) {
        this.employeeAmount = employeeAmount;
    }

    public long getManagerAmount() {
        return managerAmount;
    }

    public void setManagerAmount(long managerAmount) {
        this.managerAmount = managerAmount;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "employeeAmount=" + employeeAmount +
                ", managerAmount=" + managerAmount +
                '}';
    }
}
