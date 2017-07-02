package com.zzw.basedata.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzw.basedata.dao.RoleDao;
import com.zzw.domain.basedata.Role;
import com.zzwtec.common.bean.ResultObject;

@RestController
public class RoleController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Resource(name = "roleDao")
	private RoleDao roleDao;

	@GetMapping("/{id}")
	public ResultObject findById(@PathVariable Serializable id) {
		ResultObject result = new ResultObject();
		Role bean = this.roleDao.selectOne(id);		
		result.setData(bean);
		return result;
	}

	@GetMapping("/list")
	public ResultObject listAll() {
		ResultObject result = new ResultObject();
		List<Role> list = this.roleDao.selectAll();
		result.setData(list);
		return result;
	}
	
	@PostMapping("/add")
	public ResultObject add(Role bean) {
		ResultObject result = new ResultObject();
		/*
		String sql = "insert into role(id,name)values(?,?)";
		Object[] params = new Object[]{bean.getId(),bean.getName()};
		*/
		String sql = null;
		Object[] params = null;
		int size = this.roleDao.insert(sql, params);
		if(size > 0){
			result.setMsg("添加数据成功");
			result.setData(true);
		}else{
			result.setMsg("添加数据失败");
			result.setData(false);
		}		
		return result;
	}
	
	@PostMapping("/del/{id}")
	public ResultObject del(@PathVariable Serializable id) {
		ResultObject result = new ResultObject();
		String sql = "delete from role where id = ?";
		Object[] params = new Object[]{id};
		int size = this.roleDao.insert(sql, params);
		if(size > -1){
			result.setMsg("删除数据成功");
			result.setData(true);
		}else{
			result.setMsg("删除数据失败");
			result.setData(false);
		}		
		return result;
	}
	
	@PostMapping("/upd/{id}")
	public ResultObject upd(@PathVariable Serializable id,Role bean) {
		ResultObject result = new ResultObject();
		/*
		String sql = "update role set name = ? area = ? where id = ?";
		Object[] params = new Object[]{id};
		*/
		String sql = null; 
		Object[] params = null;
		int size = this.roleDao.insert(sql, params);
		if(size > -1){
			result.setMsg("更新数据成功");
			result.setData(true);
		}else{
			result.setMsg("更新数据失败");
			result.setData(false);
		}		
		return result;
	}

	/**
	 * 本地服务实例的信息
	 * 
	 * @return
	 */
	@GetMapping("/instance-info")
	public ServiceInstance showInfo() {		
		ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
		return localServiceInstance;
	}
}
