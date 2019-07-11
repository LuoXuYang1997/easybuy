package com.scce.controller;

import com.scce.pojo.EasybuyUser;
import com.scce.service.EasybuyUserService;
import com.scce.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 20:01
 **/
@RestController
@RequestMapping("/EasybuyUser")

public class EasybuyUserController {
    @Autowired
    EasybuyUserService easybuyUserService;

    @RequestMapping("/SelId")
    public JsonResult SelId(int userId) {
        List<EasybuyUser> list = easybuyUserService.SelId(userId);
        System.out.println(list + "aaaaaaaaaaaaa");
        return new JsonResult(0, list);
    }

    @RequestMapping("/insUser")
    public void insUser(EasybuyUser easybuyUser) {
        System.out.println(easybuyUser);
        easybuyUserService.insUser(easybuyUser);
    }

    @RequestMapping("/login")
    public JsonResult login(EasybuyUser easybuyUser) {
        System.out.println(easybuyUser + "====");
        easybuyUser = easybuyUserService.getUser(easybuyUser);
        List<EasybuyUser> list=new ArrayList<EasybuyUser>();
        list.add(easybuyUser);
        if (easybuyUser == null) {
            return new JsonResult(1, "登陆失败");
        } else {
            return new JsonResult(0, list);
        }

    }
}
