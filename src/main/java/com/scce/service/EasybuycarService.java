package com.scce.service;

import com.scce.pojo.Easybuycar;

import java.util.List;

public interface EasybuycarService {
    public List<Easybuycar> SelAll(int userId);
    public void del(int id);

    void  AddCart(Integer productid ,Integer userid  ,Integer productNum );
}
