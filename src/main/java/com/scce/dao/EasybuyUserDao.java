package com.scce.dao;

import com.scce.pojo.EasybuyUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:44
 **/
@Mapper
public interface EasybuyUserDao {
    @Select("select *from easybuy_user where userId=#{userId}")
    public List<EasybuyUser> SelId(int userId);

    @Insert(" INSERT INTO `easybuy`.`easybuy_user`( `userId`, `userName`, `password`, `realName`, `sex`, `birthday`, `idCard`, `phone`, `address`)\n" +
            "  VALUES (#{userid},#{username} , #{password},#{realname},#{sex}, #{birthday}, #{idcard}, #{phone},#{address})")
    public void addUser(EasybuyUser easybuyUser);

    @Select("SELECT MAX(userid)  FROM easybuy_user")
    public Integer getUserMaxId();


    @Select("select * from `easybuy_user` where userName=#{username} and password=#{password}")
    EasybuyUser getUser(EasybuyUser easybuyUser);
}
