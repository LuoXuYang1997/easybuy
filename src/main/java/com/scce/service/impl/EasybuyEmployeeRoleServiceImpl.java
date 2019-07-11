package com.scce.service.impl;

import com.scce.dao.EasybuyEmployeeRoleDao;
import com.scce.pojo.EasybuyEmployeeRole;
import com.scce.service.EasybuyEmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:58
 **/
@Service
public class EasybuyEmployeeRoleServiceImpl implements EasybuyEmployeeRoleService {

    @Autowired
    private EasybuyEmployeeRoleDao easybuyEmployeeRoleDao;

    @Override
    public List<EasybuyEmployeeRole> SelectEasybuyEmployeeRoleByemployeeid(Integer employeeid) {
        return easybuyEmployeeRoleDao.SelectEasybuyEmployeeRoleByemployeeid(employeeid);
    }
}
