package com.scce.service;

import com.github.pagehelper.PageInfo;
import com.scce.pojo.EasybuyProductdetails;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:53
 **/
public interface EasybuyProductdetailsService {
    PageInfo<EasybuyProductdetails> ProductdetailsSelAll(Integer pageNum, Integer pageSize);
    List<EasybuyProductdetails> SelAllProductdetails();//用于导出表格

    void addProductdetails(EasybuyProductdetails easybuyProductdetails);
}
