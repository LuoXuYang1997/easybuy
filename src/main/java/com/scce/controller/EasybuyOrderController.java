package com.scce.controller;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyOrder;
import com.scce.pojo.EasybuyProductdetails;
import com.scce.pojo.MonthOrderChar;
import com.scce.pojo.OrderChar;
import com.scce.service.EasybuyOrderService;
import com.scce.utils.JsonResult;
import com.scce.utils.OrderExcelUtil;
import com.scce.utils.ResponseUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:59
 **/
@RestController
@RequestMapping("/EasybuyOrder")
public class EasybuyOrderController {
    @Autowired
  private   EasybuyOrderService easybuyOrderService;


    @RequestMapping("/OrderChar")
    /*查询统计表*/
    public List<OrderChar> OrderChar(){
        System.out.println("进入OrderChar");
        List<OrderChar> list=easybuyOrderService.OrderChar();
        System.out.println(list+"1111111111111111111");
        return list;
    }
    @RequestMapping("/MonthOrderChar")
    /*查询统计表*/
    public List<MonthOrderChar> MonthOrderChar(){
        System.out.println("进入OrderChar");
        List<MonthOrderChar> list=easybuyOrderService.MonthOrderChar();
        System.out.println(list+"1111111111111111111");
        return list;
    }
    @RequestMapping("/OrderSelAll")
    //
    /*
    * @RequestParam(name = "pageSize") Integer pageSize,
                                    @RequestParam(name = "pageNum") Integer pageNum*/
    public JsonResult ProductSelAll(Integer pageNum, Integer pageSize)
    {

        System.out.println("进入OrderSelAll");

        System.out.println("pageNum:"+pageNum+"   pageSize:"+pageSize);

        PageInfo<EasybuyOrder> pageInfo = easybuyOrderService.OrderSelAll(pageNum,pageSize);
        JsonResult  bean = new JsonResult(0, pageInfo.getList(),pageInfo.getTotal());




        return bean;
    }

    @RequestMapping("/OrderExptab")
    public String OrderExptab(HttpServletResponse response) {
        System.out.println("进入TestExcel");

        try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String[] headers = {"序号", "订单编号", "下单时间", "商品详情", "商品价格", "商品数量", "总价格", "订单状态"};
            List<EasybuyOrder> list = easybuyOrderService.SelAllOrder();
            OrderExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @RequestMapping("/SelectOrderByUserName")
    public JsonResult SelectOrderByUserName(Integer pageNum, Integer pageSize,String  username,String orderId){
        System.out.println("进入SelectOrderByUserName");
        System.out.println("pageNum:"+pageNum+"pageSize:"+pageSize+"username"+username+"oederId"+orderId);
        PageInfo<EasybuyProductdetails> pageInfo = easybuyOrderService.SelectOrderByUserName(pageNum,pageSize,username,orderId);
        System.out.println(pageInfo);
        return new JsonResult(0,pageInfo.getList(),pageInfo.getTotal());
    }


    @RequestMapping("/UpdateOrder")
    public JsonResult UpdateOrder(String [] orderIds){
        System.out.println(orderIds[0]);
        easybuyOrderService.UpdateOrder(orderIds);
       return new JsonResult();
    }

}
