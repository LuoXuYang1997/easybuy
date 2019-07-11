package com.scce.dao;

import com.scce.pojo.EasybuyEmployeeRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:45
 **/
@Mapper
public interface EasybuyEmployeeRoleDao {
    public List<EasybuyEmployeeRole> SelectEasybuyEmployeeRoleByemployeeid(Integer employeeid);
}
