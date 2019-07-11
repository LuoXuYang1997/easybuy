package com.scce.service.impl;

import com.scce.dao.EasybuyEmployeeDao;
import com.scce.dao.EasybuyEmployeeRoleDao;
import com.scce.dao.EasybuyRoleDao;
import com.scce.pojo.EasybuyEmployee;
import com.scce.service.EasybuyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:38
 **/
@Service("easybuyEmployeeService")
public class EasybuyEmployeeServiceImpl implements EasybuyEmployeeService {

   @Autowired
   private EasybuyEmployeeDao easybuyEmployeeDao;

   @Autowired
   private EasybuyRoleDao easybuyRoleDao;

   @Autowired
   private EasybuyEmployeeRoleDao easybuyEmployeeRoleDao;

    @Override
    public EasybuyEmployee SelectEmployeeById(int id) {
        return easybuyEmployeeDao.SelectEmployeeById(id);
    }

    @Override
    public EasybuyEmployee SelectEmployeeByEmployeeName(String employeeName) {
        return easybuyEmployeeDao.SelectEmployeeByEmployeeName(employeeName);
    }

    //登陆
    @Override
    public EasybuyEmployee login(EasybuyEmployee easybuyEmployee) {
         easybuyEmployee= easybuyEmployeeDao.login(easybuyEmployee);
        return easybuyEmployee;
    }

    @Override
    public List<EasybuyEmployee> SelectEmployee(EasybuyEmployee easybuyEmployee) {
        List<EasybuyEmployee> list=    easybuyEmployeeDao.SelectEmployee(easybuyEmployee);
        return list;
    }

    @Override
    public void updateEmployee(EasybuyEmployee easybuyEmployee) {
        easybuyEmployeeDao.updateEmployee(easybuyEmployee);
    }

    @Override
    public void delEmployee(Integer[] ids) {
        easybuyEmployeeDao.delEmployee(ids);
    }

    @Override
    public List<String> SelectEmployeeLikeAddress(String address) {
       address="%"+address+"%";
        List<String> list=  easybuyEmployeeDao.SelectEmployeeLikeAddress(address);
        return list;
    }

    @Override
    public EasybuyEmployee SelectEmployeeByEmployeeid(String employeeid) {
        EasybuyEmployee easybuyEmployee=     easybuyEmployeeDao.SelectEmployeeByEmployeeid(employeeid);

        return easybuyEmployee;
    }

    @Override
    public void AddEmployee(EasybuyEmployee easybuyEmployee) {

        easybuyEmployeeDao.AddEmployee(easybuyEmployee);
    }

   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("进入loadUserByUsername");

        Collection<GrantedAuthority> authorities=new ArrayList<>();

        //从数据库中取出员工信息
        EasybuyEmployee easybuyEmployee=easybuyEmployeeDao.SelectEmployeeByEmployeeName(username);

        //判断用户是否存在
        if (easybuyEmployee==null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //添加权限
        List<EasybuyEmployeeRole> easybuyEmployeeRoles=easybuyEmployeeRoleDao.SelectEasybuyEmployeeRoleByemployeeid(easybuyEmployee.getEmployeeid());

        for (EasybuyEmployeeRole easybuyEmployeeRole : easybuyEmployeeRoles) {
            EasybuyRole easybuyRole=easybuyRoleDao.SelectRoleById(easybuyEmployeeRole.getRoleid());
            ((ArrayList<GrantedAuthority>) authorities).add(new SimpleGrantedAuthority(easybuyRole.getName()));
        }

        // 返回UserDetails实现类
        return new User(easybuyEmployee.getEmployeename(),easybuyEmployee.getPassword(),authorities);
    }*/



}
