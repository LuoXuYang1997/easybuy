package com.scce.pojo;

public class EasybuyEmployeeRole {

    private Integer employeeid;
    private Integer roleid;

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "EasybuyEmployeeRole{" +
                "employeeid=" + employeeid +
                ", roleid=" + roleid +
                '}';
    }
}
