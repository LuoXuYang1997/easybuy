package com.scce.dao;

import com.scce.pojo.EasybuyProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:40
 **/
@Mapper
public interface EasybuyProductDao {
    /*根据商品类型查商品总数*/
    @Select("select SUM(stockNumber) from easybuy_product where productTypeId=#{productTypeId}")
    public Integer SelAll(int productTypeId);
    @Select("select SUM(stockNumber) from easybuy_product where productTypeId=#{productTypeId} and WarehousingDate like #{date}")
    public Integer DaySerAll (int productTypeId, String date);
    public List<EasybuyProduct> ProductName(int productTypeId);

    List<EasybuyProduct> productselall(Map<String, Object> map);

    @Select("select  max(productId)   from  easybuy_product ")
    int selnewproductid();

    @Insert("INSERT INTO `easybuy_product` VALUES (null, #{productid}, #{producttypeid}, #{productname}, #{productdetails}," +
            "#{price}, #{stocknumber}, #{warehousingdate}, #{filename}, #{handlers} );")
    void addproduct(EasybuyProduct product);



    void updateproduct(EasybuyProduct product);

    @Delete("delete from easybuy_product where productId=#{productid}")
    void  delproductbyid(Integer productid);




    @Select(" select * from easybuy_product")
    List<EasybuyProduct> selallpdservice();


    @Select("select * from easybuy_product where fileName=#{filename}")
    EasybuyProduct showproduct(String filename);



    @Select(" select * from easybuy_product where productId=#{productId}")
    List<EasybuyProduct> AllproductId(int productId);
}
