package com.scce.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scce.pojo.Easybuycar;
import com.scce.service.EasybuycarService;
import com.scce.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Easybuycar")
public class EasybuycarController {
    @Autowired
    EasybuycarService easybuycarService;

    @RequestMapping("/EasybuycarSelAll")
    public JsonResult ProductSelAll(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Easybuycar> easybuycar = easybuycarService.SelAll(userId);
        PageInfo<Easybuycar> pageInfo = new PageInfo<Easybuycar>(easybuycar);
        System.out.println(easybuycar);
        return new JsonResult(0, pageInfo.getList(), pageInfo.getTotal());
    }

    @RequestMapping("/EasybuycarDel")
    public void EasybuycarDel(int id) {
        easybuycarService.del(id);

    }


    @RequestMapping("/AddCart")
    public JsonResult EasybuycarDel(Integer productid, Integer userid, Integer productNum) {
        System.out.println("productid:" + productid + "userid:" + "productNum" + productNum);
        easybuycarService.AddCart(productid, userid, productNum);
        return new JsonResult(0, "添加成功");
    }


}
