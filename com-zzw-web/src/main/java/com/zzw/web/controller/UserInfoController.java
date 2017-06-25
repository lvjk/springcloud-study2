package com.zzw.web.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    public String userInfo(){
       logger.info("日志输出测试 Debug==>userInfo");
       return "userInfo";
    }
   
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userinfo:add")//权限管理;
    public String userInfoAdd(){
    	System.out.println("userInfoAdd=>>$$$");
       return "userInfoAdd";
    }
    
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
       return "userInfoDel";
    }
   
}
