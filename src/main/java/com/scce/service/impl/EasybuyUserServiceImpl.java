package com.scce.service.impl;

import com.scce.dao.EasybuyUserDao;
import com.scce.pojo.EasybuyUser;
import com.scce.service.EasybuyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:57
 **/
@Service
public class EasybuyUserServiceImpl implements EasybuyUserService {
    @Autowired
    EasybuyUserDao easybuyUserDao;
    @Override
    public List<EasybuyUser> SelId(int userId) {
List<EasybuyUser> list=easybuyUserDao.SelId(userId);
        return list;
    }

    @Override
    public void insUser(EasybuyUser easybuyUser) {
        Integer userMaxId = easybuyUserDao.getUserMaxId();
        System.out.println(userMaxId);
        easybuyUser.setUserid(userMaxId+1);
        easybuyUserDao.addUser(easybuyUser);

    }

    @Override
    public EasybuyUser getUser(EasybuyUser easybuyUser) {
       easybuyUser=    easybuyUserDao.getUser(easybuyUser);
        return easybuyUser;
    }
}
