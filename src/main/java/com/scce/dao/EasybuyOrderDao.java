package com.scce.dao;

import com.scce.pojo.EasybuyOrder;
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
 * @create: 2019-07-04 19:39
 **/
@Mapper
public interface EasybuyOrderDao {
    /*根据商品名称和时间查询商品的数量*/
    public Integer EasybuyOrder(Map map);

    /*查询所有*/
    public List<EasybuyOrder> SelAll();

    /*根据月份查询订单总数*/
    public Integer MonthAll(String date1);

    List<EasybuyOrder> orderselall();

    @Select(" select * from easybuy_order")
    List<EasybuyOrder> selallorder();

    @Update("update easybuy_order set status=0 where orderId=#{orderId}")
    void up(String orderId);

    void addProductdetails(EasybuyProductdetails easybuyProductdetails);
}
