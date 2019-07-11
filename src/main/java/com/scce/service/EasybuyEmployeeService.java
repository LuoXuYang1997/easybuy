package com.scce.service;

import com.scce.pojo.EasybuyEmployee;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:38
 **/
public interface EasybuyEmployeeService  /*extends UserDetailsService */{

    //根据id查询员工
    public EasybuyEmployee SelectEmployeeById(int id);

    //根据账号查询员工
    public EasybuyEmployee SelectEmployeeByEmployeeName(String employeeName);

//根据用户名和密码查询员工
 public    EasybuyEmployee login(EasybuyEmployee easybuyEmployee);

 //查询员工信息
   public List<EasybuyEmployee> SelectEmployee(EasybuyEmployee easybuyEmployee);

  public   void updateEmployee(EasybuyEmployee easybuyEmployee);

   public void delEmployee(Integer[] ids);

  public   List<String> SelectEmployeeLikeAddress(String address);

  public   EasybuyEmployee SelectEmployeeByEmployeeid(String employeeid);

  public   void AddEmployee(EasybuyEmployee easybuyEmployee);
}
