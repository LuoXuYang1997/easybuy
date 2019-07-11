package com.scce.dao;

import com.scce.pojo.EasybuyProductdetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:40
 **/
@Mapper
public interface EasybuyProductdetailsDao {


    List<EasybuyProductdetails> productdetailsselall();


    @Select(" select * from easybuy_orderdetails")
    List<EasybuyProductdetails> selallproductdetails();


    public  List<EasybuyProductdetails> SelectOrderByUserName(Map<String,String> map);


    void addProductdetails(EasybuyProductdetails easybuyProductdetails);

    @Update("update easybuy_orderdetails set status=0 where orderId=#{orderId}")
    void up(String orderId);
}
