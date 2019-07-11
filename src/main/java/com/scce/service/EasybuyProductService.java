package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyProduct;
import com.scce.pojo.ProductChar;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:51
 **/
public interface EasybuyProductService {
    /*查询统计表*/
    public List<ProductChar> Product();
    public List<ProductChar> DarProduct();

    PageInfo<EasybuyProduct> ProductSelAll(Integer priceles, Integer pricemor, Integer typeid, String productname, Integer pageNum, Integer pageSize);
    int SelNewProductid();
    void AddProduct(EasybuyProduct product);
    void UpdateProduct(EasybuyProduct product);
    void DelProductbyid(Integer productid);
    List<EasybuyProduct> SelAllPdservice();//用于导出表格

    EasybuyProduct ShowProduct(String filename);
}
