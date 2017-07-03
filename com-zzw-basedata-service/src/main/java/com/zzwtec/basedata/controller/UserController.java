package com.zzwtec.basedata.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zzwtec.basedata.dao.UserRepository;
import com.zzwtec.common.bean.ResultObject;
import com.zzwtec.common.bean.basedata.User;


/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author 草原狼
 */
@RestController
public class UserController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private DiscoveryClient discoveryClient;
  
  @Resource(name="useDao")
  private UserRepository userRepository;

  /**
   * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
   * @RequestMapping(value = "/id", method = RequestMethod.GET)
   * 类似的注解还有@PostMapping等等
   * @param id
   * @return user信息
   */
  @GetMapping("/{id}")
  public ResultObject findById(@PathVariable Long id) {
    User findOne = this.userRepository.findUserById(id);
    ResultObject result = new ResultObject();
    result.setData(findOne);
    return result;
  }
  @GetMapping("/list")
  public ResultObject list() {
	  List<User> list = this.userRepository.findAll();
	  ResultObject result = new ResultObject();
	  result.setData(list);
    return result;
  }
  
  
  @PostMapping("/add")
  public ResultObject add(@RequestBody User user){
	  logger.info("日志输出测试 ==>add:"+user);
	  logger.info("日志输出测试 ==>add.id:"+user.getId());
	  logger.info("日志输出测试 ==>add.username:"+user.getUsername());
	  logger.info("日志输出测试 ==>add.age:"+user.getAge());
	  ResultObject result = new ResultObject(); 
	  try{
		  userRepository.create(user);
		  result.setMsg("添加用户成功");
	  }catch(Exception e){
		  result.setCode(-1);
		  result.setMsg("添加用户失败");
		  result.setData(e.getMessage());
	  }			  
	  return result;
  }
  
 
  @PutMapping("/user")  
  public ResultObject update(@RequestBody User user){
	  ResultObject result = new ResultObject(); 
	  try{
		  userRepository.update(user);
		  result.setMsg("添加用户成功");
	  }catch(Exception e){
		  result.setCode(-1);
		  result.setMsg("添加用户失败");
		  result.setData(e.getMessage());
	  }			  
	  return result;
  }
  
  /**
   * 删除用户
   * @param id
   */
  
  @DeleteMapping("{id}")
  public ResultObject deleteUser(@PathVariable("id") long id){
	  ResultObject result = new ResultObject(); 
	  try{
		  userRepository.delete(id);
		  result.setMsg("删除用户成功");
	  }catch(Exception e){
		  result.setCode(-1);
		  result.setMsg("删除用户失败");
		  result.setData(e.getMessage());
	  }			  
	  return result;
  }

  /**
   * 本地服务实例的信息
   * @return
   */
  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }
  
  
}
