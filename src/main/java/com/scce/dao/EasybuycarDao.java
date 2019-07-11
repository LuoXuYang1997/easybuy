package com.scce.dao;

import com.scce.pojo.Easybuycar;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EasybuycarDao {
    public List<Easybuycar> SelAll(int userId);
    @Delete("delete from easybuy_buycar where id=#{id}")
    public void del(int id);

    @Insert("insert into easybuy_buycar values(null,#{userid},#{productid},#{productNum})")
    void addcart(@Param("productid") Integer productid , @Param("userid") Integer userid  ,@Param("productNum") Integer productNum );
}
