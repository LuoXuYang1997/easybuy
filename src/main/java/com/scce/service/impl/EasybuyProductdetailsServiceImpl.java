package com.scce.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.dao.EasybuyOrderDao;
import com.scce.dao.EasybuyProductdetailsDao;
import com.scce.pojo.EasybuyProductdetails;
import com.scce.service.EasybuyProductdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:54
 **/
@Service
public class EasybuyProductdetailsServiceImpl  implements EasybuyProductdetailsService {
    @Autowired
    EasybuyProductdetailsDao mapper;

    @Autowired
    EasybuyOrderDao orderDao;


    @Override
    public PageInfo<EasybuyProductdetails> ProductdetailsSelAll(Integer pageNum, Integer pageSize) {



        PageHelper.startPage(pageNum, pageSize);
        List list =mapper.productdetailsselall();
        PageInfo<EasybuyProductdetails> pageInfo = new PageInfo<EasybuyProductdetails>(list);

        return pageInfo;
    }

    @Override
    public List<EasybuyProductdetails> SelAllProductdetails() {


        List<EasybuyProductdetails> productdetails=  mapper.selallproductdetails();
        return productdetails;

    }

    @Override
    public void addProductdetails(EasybuyProductdetails easybuyProductdetails) {

        mapper.addProductdetails(easybuyProductdetails);
        orderDao.addProductdetails(easybuyProductdetails);;
    }

}
