package com.scce.service;

import com.scce.pojo.EasybuyUser;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:57
 **/
public interface EasybuyUserService {
    public List<EasybuyUser> SelId(int userId);
    public void insUser(EasybuyUser easybuyUser);

    EasybuyUser getUser(EasybuyUser easybuyUser);
}
