package com.scce.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.dao.EasybuyProductDao;
import com.scce.dao.EasybuyProducttypeDao;
import com.scce.pojo.EasybuyProduct;
import com.scce.pojo.EasybuyProducttype;
import com.scce.pojo.ProductChar;
import com.scce.service.EasybuyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:52
 **/
@Service
public class EasybuyProductServiceImpl implements EasybuyProductService {
    @Autowired
    EasybuyProducttypeDao easybuyProducttypeDao;
    @Autowired
    EasybuyProductDao easybuyProductDao;


    @Override
    /*查询统计表*/
    public List<ProductChar> Product() {
       List<EasybuyProducttype> producttype=easybuyProducttypeDao.SelAll();
        List<ProductChar> list=new ArrayList<ProductChar>();
        for(EasybuyProducttype producttype1:producttype){
            Integer num=easybuyProductDao.SelAll(producttype1.getProducttypeid());
            /*System.out.println(num);*/
            ProductChar productChar=new ProductChar();
            if(num==null){
                productChar.setSum(0);
                productChar.setProductType(producttype1.getProducttype());
                list.add(productChar);
            }else {
                productChar.setSum(num);
                productChar.setProductType(producttype1.getProducttype());
                list.add(productChar);
            }

        }
        System.out.println(list);
        return list;



    }

    @Override
    public List<ProductChar> DarProduct() {
        Date date=new Date();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd%");
        System.out.println(format.format(date)+"111111111111111");
        List<EasybuyProducttype> producttype=easybuyProducttypeDao.SelAll();
        List<ProductChar> list=new ArrayList<ProductChar>();
        for(EasybuyProducttype producttype1:producttype){
            int productTypeId=producttype1.getProducttypeid();
            Integer num=easybuyProductDao.DaySerAll(productTypeId,format.format(date));
            System.out.println(num+producttype1.getProducttype());
            ProductChar productChar=new ProductChar();
            if(num==null){
                productChar.setSum(0);
                productChar.setProductType(producttype1.getProducttype());
                list.add(productChar);
            }else {
                productChar.setSum(num);
                productChar.setProductType(producttype1.getProducttype());
                list.add(productChar);
            }
        }
        System.out.println(list);
        return list;
    }

    @Override
    public PageInfo<EasybuyProduct> ProductSelAll(Integer priceles, Integer pricemor, Integer typeid, String productname, Integer pageNum, Integer pageSize) {
        System.out.println("111111");
        Map map=new HashMap<String,Object>();
        map.put("priceles",priceles);
        map.put("pricemor",pricemor);
        map.put("typeid",typeid);
        map.put("productname",productname);
        PageHelper.startPage(pageNum, pageSize);
        List list =easybuyProductDao.productselall(map);
        PageInfo<EasybuyProduct> pageInfo = new PageInfo<EasybuyProduct>(list);
        return pageInfo;
    }

    @Override
    public int SelNewProductid() {
        int  newproductid =easybuyProductDao.selnewproductid();
        System.out.println("serviceimpl:newproductid:" + newproductid);
        return newproductid;
    }


    @Override
    public void AddProduct( EasybuyProduct product){
        easybuyProductDao.addproduct(product);

    }

    @Override
    public void UpdateProduct(EasybuyProduct product) {

        System.out.println("进入UpdateProductServiceImpl");
        easybuyProductDao.updateproduct(product);
    }
    public void DelProductbyid(Integer productid)
    {
        easybuyProductDao.delproductbyid(productid);

    }

    @Override
    public List<EasybuyProduct> SelAllPdservice() {

        List<EasybuyProduct> order=  easybuyProductDao.selallpdservice();
        return order;

    }

    @Override
    public EasybuyProduct ShowProduct(String filename) {
        System.out.println("service:filename:"+filename);
        return easybuyProductDao.showproduct(filename);
    }
}
