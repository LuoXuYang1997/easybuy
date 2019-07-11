package com.scce.service;

import com.scce.pojo.EasybuyRole;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:56
 **/
public interface EasybuyRoleService {
    //根据id查询权限
    public EasybuyRole SelectRoleById(Integer id);
}
