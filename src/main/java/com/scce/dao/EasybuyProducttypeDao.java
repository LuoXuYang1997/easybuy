package com.scce.dao;

import com.scce.pojo.EasybuyProducttype;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:41
 **/
@Mapper
public interface EasybuyProducttypeDao {
    /*查询easybuy_producttype全部*/
    @Select("select *from easybuy_producttype")
    public List<EasybuyProducttype> SelAll();
}
