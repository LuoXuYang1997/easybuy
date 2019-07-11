package com.scce.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.dao.EasybuyOrderDao;
import com.scce.dao.EasybuyProductDao;
import com.scce.dao.EasybuyProductdetailsDao;
import com.scce.dao.EasybuyProducttypeDao;
import com.scce.pojo.*;
import com.scce.service.EasybuyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:50
 **/
@Service
public class EasybuyOrderServiceImpl implements   EasybuyOrderService {
    @Autowired
    EasybuyProducttypeDao easybuyProducttypeDao;
    @Autowired
    EasybuyProductDao easybuyProductDao;
    @Autowired
    EasybuyOrderDao easybuyOrderDao;

    @Autowired
    EasybuyProductdetailsDao easybuyProductdetailsDao;
    @Override
    public List<OrderChar> OrderChar() {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM%");
        String date1=format.format(date);
        List<OrderChar> list=new ArrayList<OrderChar>();
        List<EasybuyProducttype> producttype=easybuyProducttypeDao.SelAll();

        for(EasybuyProducttype producttype1:producttype){
            System.out.println(producttype1.getProducttypeid());
            int productTypeId=producttype1.getProducttypeid();

            List<EasybuyProduct>  easybuyProduct=easybuyProductDao.ProductName(productTypeId);

            System.out.println(easybuyProduct+"aaaaaaaaaaaaaaaaaaaaaaa");
            for (EasybuyProduct easybuyProduct1:easybuyProduct){
                /* System.out.println(easybuyProduct1.getProductdetails());*/
                String productDetails=easybuyProduct1.getProductdetails();
                Map map=new HashMap();
                map.put("productDetails",productDetails);
                map.put("date",date1);
              /* System.out.println(map.get("productDetails")+"333333333333333");
               System.out.println(map.get("date")+"2222222222222222");*/
                Integer num=easybuyOrderDao.EasybuyOrder(map);
                OrderChar orderChar=new OrderChar();
                if(num==null){
                    orderChar.setSum(0);
                    orderChar.setProductType(productDetails);
                    list.add(orderChar);
                }else {
                    orderChar.setSum(num);
                    orderChar.setProductType(productDetails);
                    list.add(orderChar);
                }
            }
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<MonthOrderChar> MonthOrderChar() {
        List<MonthOrderChar> list=new ArrayList<MonthOrderChar>();
        List<EasybuyOrder> easybuyOrders=easybuyOrderDao.SelAll();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
        String month=null;
        for(EasybuyOrder easybuyOrder:easybuyOrders){
            Date date=easybuyOrder.getCreationdate();
            String date1=format.format(date)+"%";
            int Sum=easybuyOrderDao.MonthAll(date1);
            System.out.println(month);
            MonthOrderChar monthOrderChar=new MonthOrderChar();
            monthOrderChar.setMonth(format.format(date));
            monthOrderChar.setSum(Sum);
            month=format.format(date);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getMonth().equals(month)){
                    list.remove(i);
                }
            }
            list.add(monthOrderChar);
        }
        System.out.println(list);
        return list;
    }



    @Override
    public PageInfo<EasybuyProductdetails> SelectOrderByUserName(Integer pageNum, Integer pageSize,  String  username,String oederId) {
        System.out.println(username);
        System.out.println(pageNum+"=="+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        Map<String,String> map=new HashMap<String, String>();
        map.put("username",username);
        map.put("oederId",oederId);
        List<EasybuyProductdetails> list =easybuyProductdetailsDao.SelectOrderByUserName(map);
        System.out.println("List:"+list);
        PageInfo<EasybuyProductdetails> pageInfo = new PageInfo<EasybuyProductdetails>(list);
        return pageInfo;
    }

    @Override
    public void UpdateOrder(String[] orderIds) {

        for (int i = 0; i <orderIds.length ; i++) {
            easybuyOrderDao.up(orderIds[i]);
            easybuyProductdetailsDao.up(orderIds[i]);
        }

    }


    @Override
    public PageInfo<EasybuyOrder> OrderSelAll(Integer pageNum, Integer pageSize) {


        System.out.println("进入OrderSelAll");
        PageHelper.startPage(pageNum, pageSize);
        List list =easybuyOrderDao.orderselall();
        System.out.println("List:"+list);
        PageInfo<EasybuyOrder> pageInfo = new PageInfo<EasybuyOrder>(list);

        return pageInfo;
    }

    @Override
    public  List<EasybuyOrder> SelAllOrder() {

        List<EasybuyOrder> order=  easybuyOrderDao.selallorder();
        return order;
    }

}
