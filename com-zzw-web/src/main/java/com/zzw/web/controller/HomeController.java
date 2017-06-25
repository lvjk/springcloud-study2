package com.zzw.web.controller;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


 
@Controller
public class HomeController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
    @RequestMapping({"/","/index"})
    public String index(ModelMap mode){
       mode.put("k", "日志输出测试 Debug");
       logger.debug("日志输出测试 Debug");
       return "index";
    }
   
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login(){    	
       logger.info("login==============>");
       return "login";
    }
    
 // 登录提交地址和applicationontext-shiro.xml配置的loginurl一致。 (配置文件方式的说法)
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
       System.out.println("HomeController.login()");
       // 登录失败从request中获取shiro处理的异常信息。
       // shiroLoginFailure:就是shiro异常类的全类名.
       String exception = (String) request.getAttribute("shiroLoginFailure");
 
       System.out.println("exception=" + exception);
       String msg = "";
       if (exception != null) {
           if (UnknownAccountException.class.getName().equals(exception)) {
              System.out.println("UnknownAccountException -- > 账号不存在：");
              msg = "UnknownAccountException -- > 账号不存在：";
           } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
              System.out.println("IncorrectCredentialsException -- > 密码不正确：");
              msg = "IncorrectCredentialsException -- > 密码不正确：";
           } else if ("kaptchaValidateFailed".equals(exception)) {
              System.out.println("kaptchaValidateFailed -- > 验证码错误");
              msg = "kaptchaValidateFailed -- > 验证码错误";
           } else {
              msg = "else >> "+exception;
              System.out.println("else -- >" + exception);
           }
       }
       map.put("msg", msg);
       // 此方法不处理登录成功,由shiro进行处理.
       return "/login";
    }
   
}