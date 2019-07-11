package com.scce.controller;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyProduct;
import com.scce.pojo.ProductChar;
import com.scce.service.EasybuyProductService;
import com.scce.utils.DateUtil;
import com.scce.utils.JsonResult;
import com.scce.utils.ProductExcelUtil;
import com.scce.utils.ResponseUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:59
 **/
@RestController
@RequestMapping("/EasybuyProduct")
public class EasybuyProductController {

    @Autowired
 private    EasybuyProductService easybuyProductService;

    @RequestMapping("/product")
    @ResponseBody
    /*查询统计表*/
    public List<ProductChar> product(){
        List<ProductChar> list=easybuyProductService.Product();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/Dayproduct")
    @ResponseBody
    /*查询统计表*/
    public List<ProductChar> Dayproduct(){
        List<ProductChar> list=easybuyProductService.DarProduct();
        System.out.println(list);
        return list;
    }

    @RequestMapping("/ProductSelAll")
    public JsonResult ProductSelAll(@RequestParam(name = "typeid") Integer typeid,
                                    @RequestParam(name = "productname") String productname,
                                    @RequestParam(name = "pageNum") Integer pageNum,
                                    @RequestParam(name = "pageSize") Integer pageSize,
                                    @RequestParam(name = "priceles") Integer priceles,
                                    @RequestParam(name = "pricemor") Integer pricemor
    )
    {
        System.out.println("进入ProductSelAll");
        PageInfo<EasybuyProduct> pageInfo = easybuyProductService.ProductSelAll(priceles, pricemor, typeid, productname, pageNum, pageSize);
        JsonResult  bean = new JsonResult(0, pageInfo.getList(),pageInfo.getTotal());
        return bean;
    }


    @RequestMapping("/SelNewProductid")
    public JsonResult SelNewProductid(){
        System.out.println("进入了SelNewProductid");
        int newproductid =  easybuyProductService.SelNewProductid();
        JsonResult bean = new JsonResult(newproductid+1);
        return  bean;
    }

    @RequestMapping("/AddProduct")
    public JsonResult AddProduct(Integer productId,Integer productTypeId,String productName, String price,Integer stockNumber,String WarehousingDate, String fileName,String  handlers,String productDetails) throws ParseException, ParseException {
        Date date= DateUtil.stringToDate(WarehousingDate,"yyyy-MM-dd HH:mm:ss");
        System.out.println("Date:"+date);
        EasybuyProduct product=new EasybuyProduct(null,productId,productTypeId,productName,productDetails,price,stockNumber,date,fileName,handlers);
        easybuyProductService.AddProduct (product);
        JsonResult bean = new JsonResult();
        return  bean;
    }

    @RequestMapping("/UpdateProduct")
    public void UpdateProduct(EasybuyProduct Product){

        System.out.println("进入UpdateProduct");
        System.out.println(Product);
        easybuyProductService.UpdateProduct(Product);

    }

    @RequestMapping("/DelProductbyid")
    public JsonResult DelProductbyid(Integer productid){


        easybuyProductService.DelProductbyid(productid);
        JsonResult bean = new JsonResult();
        return  bean;



    }

    @RequestMapping("/ProductExptab")
    public String ProductExptab(HttpServletResponse response){

        try {
            Workbook wb = new HSSFWorkbook();  //创建工作簿
            String[] headers = {"序号", "商品编号", "商品类别id", "商品名称",
                    "商品详情", "商品价格", "库存数量", "入库日期",
                    "文件名称(图片)","操作人姓名"};
            List<EasybuyProduct> list = easybuyProductService.SelAllPdservice();
            ProductExcelUtil.fillExcelData(list, wb, headers);
            ResponseUtil.export(response, wb, "导出excel.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }


    @RequestMapping("/ShowProduct")
    public JsonResult filename(String filename){


        System.out.println("filename:"+filename);

       EasybuyProduct easybuyProduct= easybuyProductService.ShowProduct(filename);
        System.out.println("easybuyProduct:"+easybuyProduct);
        JsonResult bean = new JsonResult();
        bean.setData(easybuyProduct);
        System.out.println(bean);

        return  bean;



    }





}
