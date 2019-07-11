package com.scce.service;

import com.scce.pojo.EasybuyEmployeeRole;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:58
 **/
public interface EasybuyEmployeeRoleService {
    public List<EasybuyEmployeeRole> SelectEasybuyEmployeeRoleByemployeeid(Integer employeeid);

}
