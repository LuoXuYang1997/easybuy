package com.scce.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scce.pojo.EasybuyEmployee;
import com.scce.service.EasybuyEmployeeService;
import com.scce.utils.EmployeeExcelUtil;
import com.scce.utils.JsonResult;
import com.scce.utils.ResponseUtil;
import com.scce.utils.VaptchaMessage;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-07-04 19:38
 **/
@RestController
@RequestMapping("/EasybuyEmployee")
public class EasybuyEmployeeController {
    //private Logger logger = LoggerFactory.getLogger(EasybuyEmployeeController.class);

    @Autowired
    private EasybuyEmployeeService easybuyEmployeeService;


    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 登陆
     * @Date 18:06 2019/7/7
     * @Param [easybuyEmployee, token, request]
     **/
    @RequestMapping("/login")
    public JsonResult login(EasybuyEmployee easybuyEmployee, String token, HttpServletRequest request) throws Exception {
        System.out.println("进入login");
        System.out.println(easybuyEmployee + "===" + token);
        //const token = getRequest('token');
        easybuyEmployee = easybuyEmployeeService.login(easybuyEmployee);
        System.out.println(easybuyEmployee);
        if (easybuyEmployee == null) {
            return new JsonResult(1, "账号密码错误");
        } else if (!vaptchaCheck(token, request.getRemoteHost())) {
            return new JsonResult(1, "人机校验失败");
        } else {
            return new JsonResult(0, "登陆成功");
        }

    }

    /**
     * @return boolean
     * @Author Lxy
     * @Description 判断人机验证
     * @Date 15:40 2019/7/5
     * @Param [token, ip]
     **/
    private boolean vaptchaCheck(String token, String ip) throws Exception {
        HttpSession session = null;
        System.out.println("进入vaptchaCheck方法");
        String body = "";
        //创建CloseableHttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //httpPost其实在服务端模拟浏览器向其它接口发送服务的，一般情况下和httpclient，或者jsonp联合使用，可以把它理解为浏览器就行了，
        HttpPost httpPost = new HttpPost("http://api.vaptcha.com/v2/validate");
        //NameValuePair是简单名称值对节点类型。多用于Java像url发送Post请求。在发送post请求时用该list来存放参数。
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        //BasicNameValuePair通常是用来封装post请求中的参数名称和值；
        //封装vaptcha的VID
        nvps.add(new BasicNameValuePair("id", "5d1c4ed9fc650e99b8e3cb33"));
        //封装vaptcha的Key
        nvps.add(new BasicNameValuePair("secretkey", "005b188e895f4cd3ad33cd8ca169f551"));
        nvps.add(new BasicNameValuePair("scene", ""));
        nvps.add(new BasicNameValuePair("token", token));
        nvps.add(new BasicNameValuePair("ip", ip));
        //设置请求体
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse r = httpClient.execute(httpPost);
        HttpEntity entity = r.getEntity();

        //System.out.println(session.getAttribute("token"));
        if (entity != null) {
            body = EntityUtils.toString(entity, "utf-8");
            System.out.println(body);
        }
        r.close();
        httpClient.close();
        //GSON是Google提供的用来在Java对象和JSON数据之间进行映射的Java类库。可以将一个Json字符转成一个Java对象，或者将一个Java转化为Json字符串。
        Gson gson = new Gson();
        VaptchaMessage message = gson.fromJson(body, VaptchaMessage.class);
        System.out.println(message);
        if (message.getSuccess() == 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 查询员工信息并分页
     * @Date 16:10 2019/7/6
     * @Param [pageNum, pageSize]
     **/
    @RequestMapping("/SelectEmployee")
    public JsonResult SelectEmployee(Integer pageNum, Integer pageSize, EasybuyEmployee easybuyEmployee) {
        System.out.println("进入SelectEmployee方法");
        System.out.println(pageNum + "===" + pageSize + "=======" + easybuyEmployee);
        PageHelper.startPage(pageNum, pageSize);
        List<EasybuyEmployee> list = easybuyEmployeeService.SelectEmployee(easybuyEmployee);
        PageInfo<EasybuyEmployee> pageInfo = new PageInfo<EasybuyEmployee>(list);
        System.out.println(pageInfo);
        return new JsonResult(0, pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 修改员工信息
     * @Date 16:11 2019/7/6
     * @Param [easybuyEmployee]
     **/
    @RequestMapping("/updateEmployee")
    public JsonResult updateEmployee(EasybuyEmployee easybuyEmployee) {
        System.out.println("进入updateEmployee方法");
        System.out.println(easybuyEmployee);
        easybuyEmployeeService.updateEmployee(easybuyEmployee);
        return new JsonResult(0, "修改成功");
    }

    @RequestMapping("/delEmployee")
    public JsonResult delEmployee(Integer[] ids) {
        for (Integer id : ids) {
            System.out.println(id + "||||||||||||||");
        }
        easybuyEmployeeService.delEmployee(ids);
        return new JsonResult(0, "删除成功");
    }


    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 根据地址实现模糊查询，实现输入框联想功能
     * @Date 14:23 2019/7/7
     * @Param [address]
     **/
    @RequestMapping("/SelectEmployeeLikeAddress")
    public JsonResult SelectEmployeeLikeAddress(String address) {
        List<String> list = easybuyEmployeeService.SelectEmployeeLikeAddress(address);
        System.out.println(list);
        return new JsonResult(0, list);
    }

    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 根据员工编号查询 员工
     * @Date 18:41 2019/7/7
     * @Param [employeeid]
     **/
    @RequestMapping("/SelectEmployeeByEmployeeid")
    public JsonResult SelectEmployeeByEmployeeid(String employeeid) {
        EasybuyEmployee easybuyEmployee = easybuyEmployeeService.SelectEmployeeByEmployeeid(employeeid);
        System.out.println(easybuyEmployee);
        if (easybuyEmployee == null) {
            return new JsonResult(0, "该编号已存在");
        } else {
            return new JsonResult(1, "该编号不存在");
        }

    }


    /**
     * @return com.scce.utils.JsonResult
     * @Author Lxy
     * @Description 添加员工
     * @Date 18:43 2019/7/7
     * @Param []
     **/
    @RequestMapping("/AddEmployee")
    public JsonResult AddEmployee(EasybuyEmployee easybuyEmployee) {
        System.out.println(easybuyEmployee);
        easybuyEmployeeService.AddEmployee(easybuyEmployee);
        return new JsonResult(0, "添加成功");
    }


    @RequestMapping("/ExportEmployeeExcel")
    public JsonResult ExportEmployeeExcel(HttpServletResponse response) throws Exception {
        System.out.println("进入ExportEmployeeExcel");
        List<EasybuyEmployee> list = easybuyEmployeeService.SelectEmployee(null);
        System.out.println(list);
        Workbook wb = new HSSFWorkbook();  //创建工作簿
        String headers[] = {"员工编号", "员工名", "密码", "真实姓名", "性别", "生日时间", "身份证号", "电话号码", "地址"};
        EmployeeExcelUtil.fillExcelData(list, wb, headers);
        ResponseUtil.export(response, wb, "员工表excel.xls");
        return null;
    }

}