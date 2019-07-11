package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyOrder;
import com.scce.pojo.EasybuyProductdetails;
import com.scce.pojo.MonthOrderChar;
import com.scce.pojo.OrderChar;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:49
 **/
public interface EasybuyOrderService {
    PageInfo<EasybuyOrder> OrderSelAll(Integer pageNum, Integer pageSize);
    List<EasybuyOrder>  SelAllOrder();//用于导出表格
    public List<OrderChar> OrderChar();
    public List<MonthOrderChar> MonthOrderChar();

 public    PageInfo<EasybuyProductdetails> SelectOrderByUserName(Integer pageNum, Integer pageSize, String  username,String oederId);


    void UpdateOrder(String[] orderIds);
}
