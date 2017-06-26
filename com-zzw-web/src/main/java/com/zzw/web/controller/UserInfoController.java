package com.zzw.web.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.zzw.web.domain.User;


 
@Controller
@RequestMapping("/user")
public class UserInfoController {
	private Logger logger =  LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RestTemplate restTemplate;
	
    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/list")
    public String list(ModelMap model){
       logger.info("日志输出测试 Debug==>userList");
       List<User> list = (List<User>)restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/list",  List.class);
   	   System.out.println(list.size());
   	   model.put("list", list);
       return "userList";
    }
   
    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id") Long id,ModelMap model){
       logger.info("日志输出测试==>userInfo");
       User user = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/"+id, User.class);
   	   System.out.println(user.getUsername());
   	   model.remove("user");
   	   model.put("user", user);
       return "userInfo";
    }
    
    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/add")
    @RequiresPermissions("userinfo:add")//权限管理;
    public String userInfoAdd(){
    	//User list = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/list", User.class);
    	//System.out.println(list.getUsername());
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
