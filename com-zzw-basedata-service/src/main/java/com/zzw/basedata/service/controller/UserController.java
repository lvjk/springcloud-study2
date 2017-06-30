package com.zzw.basedata.service.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzw.basedata.service.dao.UserRepository;
import com.zzw.basedata.service.domain.User;
import com.zzw.bean.ResultObject;

/**
 * 作用：
 * ① 测试服务实例的相关内容
 * ② 为后来的服务做提供
 * @author 草原狼
 */
@RestController
public class UserController {
  
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
  public User findById(@PathVariable Long id) {
    User findOne = this.userRepository.findUserById(id);
    return findOne;
  }
  @GetMapping("/list")
  public List<User> list() {
	  List<User> list = this.userRepository.findAll();
    return list;
  }
  
  
  @RequestMapping(name="add", method=RequestMethod.POST)
  public ResultObject add(User user){
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
  
 
  @RequestMapping(name="update",method=RequestMethod.PUT)
  public ResultObject update(User user){
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
  
  @RequestMapping(method=RequestMethod.DELETE,value="{id}")
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
