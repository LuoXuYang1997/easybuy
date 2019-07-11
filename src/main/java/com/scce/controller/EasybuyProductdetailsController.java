package com.scce.controller;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyProductdetails;
import com.scce.service.EasybuyProductdetailsService;
import com.scce.utils.JsonResult;
import com.scce.utils.ProductdetailsExcelUtil;
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
 * @create: 2019-07-04 20:00
 **/
@RestController
@RequestMapping("/EasybuyProductdetails")
public class EasybuyProductdetailsController {

    @Autowired
private     EasybuyProductdetailsService Pddservice;
    @RequestMapping("/ProductdetailsSelAll")
    public JsonResult ProductdetailsSelAll(Integer pageNum, Integer pageSize)
    {
        System.out.println("进入订单详情表");
        PageInfo<EasybuyProductdetails> pageInfo = Pddservice.ProductdetailsSelAll(pageNum,pageSize);
        JsonResult bean = new JsonResult(0, pageInfo.getList(),pageInfo.getTotal());


        return bean;
    }



    @RequestMapping("/ProductdetailsExptab")
    public String ProductdetailsExptab(HttpServletResponse response) {
        System.out.println("进入TestExcel");

        try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String[] headers = {"序号", "真实姓名", "电话号码", "地址", "订单编号", "下单时间", "商品详情", "商品价格", "商品数量", "运费", "总价格", "订单状态"};
            List<EasybuyProductdetails> list = Pddservice.SelAllProductdetails();
            ProductdetailsExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/addProductdetails")
    public JsonResult addProductdetails(EasybuyProductdetails easybuyProductdetails){
        Pddservice.addProductdetails(easybuyProductdetails);

        return new JsonResult(0,"添加成功");
    }


}
