package com.zzwtec.basedata.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zzwtec.common.bean.basedata.Community;
import com.zzwtec.basedata.dao.CommunityDao;
import com.zzwtec.common.bean.ResultObject;

@RestController
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Resource(name = "communityDao")
	private CommunityDao communityDao;

	@GetMapping("/{id}")
	public ResultObject findById(@PathVariable Serializable id) {
		ResultObject result = new ResultObject();
		Community bean = this.communityDao.selectOne(id);		
		result.setData(bean);
		return result;
	}

	@GetMapping("/list")
	public ResultObject listAll() {
		ResultObject result = new ResultObject();
		List<Community> list = this.communityDao.selectAll();
		result.setData(list);
		return result;
	}
	
	@PostMapping("/add")
	public ResultObject add(@RequestBody Community bean) {
		ResultObject result = new ResultObject();		
		String sql = "insert into community (address,deletec,latitude,longitude,name,remark) values (?,?,?,?,?,?)";
		Object[] params = new Object[]{bean.getAddress(),bean.getDeletec(),bean.getLatitude(),bean.getLongitude(),bean.getName(),bean.getRemark()};;
		int size = this.communityDao.insert(sql, params);
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
		String sql = "delete from community where id = ?";
		Object[] params = new Object[]{id};
		int size = this.communityDao.insert(sql, params);
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
	public ResultObject upd(@PathVariable Serializable id,Community bean) {
		ResultObject result = new ResultObject();		
		String sql = "update community set address= ?,deletec= ?,latitude= ?,longitude= ?,name= ?,remark= ? where id= ?"; 
		Object[] params = new Object[]{bean.getAddress(),bean.getDeletec(),bean.getLatitude(),bean.getLongitude(),bean.getName(),bean.getRemark(),bean.getId()};;
		int size = this.communityDao.insert(sql, params);
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
