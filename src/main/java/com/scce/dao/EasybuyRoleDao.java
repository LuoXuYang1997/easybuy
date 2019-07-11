package com.scce.dao;

import com.scce.pojo.EasybuyRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:41
 **/
@Mapper
public interface EasybuyRoleDao {
    //根据id查询权限
    public EasybuyRole SelectRoleById(Integer id);
}
