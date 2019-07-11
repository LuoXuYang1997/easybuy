package com.scce.service.impl;

import com.scce.dao.EasybuyProductDao;
import com.scce.dao.EasybuycarDao;
import com.scce.pojo.EasybuyProduct;
import com.scce.pojo.Easybuycar;
import com.scce.service.EasybuycarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EasybuycarServiceImpl implements EasybuycarService {
    @Autowired
    EasybuycarDao easybuycarDao;
    @Autowired
    EasybuyProductDao easybuyProductDao;
    @Override
    public List<Easybuycar> SelAll(int userId) {
        List<Easybuycar> easybuycars=easybuycarDao.SelAll(userId);
        for(Easybuycar easybuycar:easybuycars){

            System.out.println(easybuycar.getProductNumber()+"aaaaaaaaaaaaaaaaaaaaa");
            System.out.println(easybuycar.getProductId()+"bbbbbbbbbbbbbbbb");
            List<EasybuyProduct> products=easybuyProductDao.AllproductId(easybuycar.getProductId());
            System.out.println(products+"ccccccccccccc");
            easybuycar.setEasybuyProduct(products.get(0));
            System.out.println(easybuycar);

        }
        return easybuycars;
    }

    @Override
    public void del(int id) {
        easybuycarDao.del(id);
    }

    @Override
    public void AddCart(Integer productid, Integer userid, Integer productNum) {
        easybuycarDao.addcart(productid,userid,productNum);
    }
}
