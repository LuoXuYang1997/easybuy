package com.scce.service.impl;

import com.scce.dao.EasybuyRoleDao;
import com.scce.pojo.EasybuyRole;
import com.scce.service.EasybuyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:56
 **/
@Service
public class EasybuyRoleServiceImpl implements EasybuyRoleService {

    @Autowired
    private EasybuyRoleDao easybuyRoleDao;

    @Override
    public EasybuyRole SelectRoleById(Integer id) {
        return easybuyRoleDao.SelectRoleById(id);
    }
}
