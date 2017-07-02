package com.zzw.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.zzwtec.common.bean.ResultObject;
import com.zzwtec.common.bean.basedata.User;

@Controller
@RequestMapping("/user")
public class UserInfoController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 用户查询.
	 * 
	 * @return
	 */
	@GetMapping("list")
	public String userList(ModelMap model) {
		logger.info("日志输出测试 ==>list");		
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/list", ResultObject.class);
		logger.info("data:" + result.getData());
		model.put("list", result.getData());
		return "userList";
	}

	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") Long id, ModelMap model) {
		logger.info("日志输出测试 ==>info");
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/" + id, ResultObject.class);
		logger.info("data:" + result.getData());
		model.put("user", result.getData());
		return "userInfo";
	}

	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@GetMapping("/add")
	//@RequiresPermissions("userinfo:add") // 权限管理;
	public String addUserUI() {
		logger.info("日志输出测试 ==>addUserUI");
		return "userInfoAdd";
	}
	
	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@GetMapping("/edit/{id}")
	//@RequiresPermissions("userinfo:add") // 权限管理;
	public String editUserUI(@PathVariable("id") Long id,ModelMap model) {
		logger.info("日志输出测试 ==>editUserUI");
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/" + id, ResultObject.class);
		logger.info("data:" + result.getData());
		model.put("user", result.getData());
		return "userInfoEdit";
	}

	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@PostMapping("/add")
	//@RequiresPermissions("userinfo:add") // 权限管理;
	public String addUser(User user, ModelMap model) {
		logger.info("日志输出测试 ==>addUser");
		ResultObject result = restTemplate.postForObject("http://COM-ZZW-BASEDATA-SERVICE/add",user, ResultObject.class);
		logger.info("code:" + result.getCode());
		logger.info("data:" + result.getData());
		if (result.code == 0) {
			model.put("msg", "添加数据成功");
			return "redirect:/user/list";
		} else {
			model.put("msg", "添加数据失败");
			return "userInfoAdd";
		}

	}
	
	/**
	 * 用户添加;
	 * 
	 * @return
	 */
	@PostMapping("/edit")
	//@RequiresPermissions("userinfo:add") // 权限管理;
	public String editUser(User user, ModelMap model) {
		logger.info("日志输出测试 ==>editUser");
		//ResultObject result = restTemplate.postForObject("http://COM-ZZW-BASEDATA-SERVICE/add",user, ResultObject.class);
		restTemplate.put("http://COM-ZZW-BASEDATA-SERVICE/user", user);	
		//HttpEntity<User> requestEntity = new HttpEntity<User>(user);
		//ResponseEntity<ResultObject> result = restTemplate.exchange("http://COM-ZZW-BASEDATA-SERVICE/user", HttpMethod.PUT, requestEntity, ResultObject.class);
		RestHelper rest = new RestHelper(restTemplate);
		ResultObject result = rest.put("http://COM-ZZW-BASEDATA-SERVICE/user", user);		
		logger.info("editUser ==>result"+result.getCode());		
		return "redirect:/user/list";

	}

	/**
	 * 用户删除;
	 * 
	 * @return
	 */
	@GetMapping("/delete/{id}")
	//@RequiresPermissions("userInfo:del") // 权限管理;
	public String delteUser(@PathVariable("id") Long id) {
		logger.info("日志输出测试 ==>delteUser");		
		//restTemplate.delete("http://COM-ZZW-BASEDATA-SERVICE/{id}",id);		
		ResponseEntity<ResultObject> result = restTemplate.exchange("http://COM-ZZW-BASEDATA-SERVICE/"+id, HttpMethod.DELETE, null, ResultObject.class);
		logger.info("delteUser ==>状态码"+result.getStatusCodeValue());
		logger.info("delteUser ==>result"+result.getBody().getCode());		
		return "redirect:/user/list";
	}
	
}
