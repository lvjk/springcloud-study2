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

import com.zzwtec.common.bean.basedata.DoorCard;
import com.zzwtec.basedata.dao.DoorCardDao;
import com.zzwtec.common.bean.ResultObject;

@RestController
@RequestMapping("/doorCard")
public class DoorCardController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@Resource(name = "doorCardDao")
	private DoorCardDao doorCardDao;

	@GetMapping("/{id}")
	public ResultObject findById(@PathVariable Serializable id) {
		ResultObject result = new ResultObject();
		DoorCard bean = this.doorCardDao.selectOne(id);		
		result.setData(bean);
		return result;
	}

	@GetMapping("/list")
	public ResultObject listAll() {
		ResultObject result = new ResultObject();
		List<DoorCard> list = this.doorCardDao.selectAll();
		result.setData(list);
		return result;
	}
	
	@PostMapping("/add")
	public ResultObject add(@RequestBody DoorCard bean) {
		ResultObject result = new ResultObject();		
		String sql = "insert into door_card (available_time,build_id,card_num,cell_id,chip_id,community_id,deletec,loss,owner_mobile,property_id,remark,start_date,time_stamp,type,owner_name,owner_type,owner_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{bean.getAvailableTime(),bean.getBuildId(),bean.getCardNum(),bean.getCellId(),bean.getChipId(),bean.getCommunityId(),bean.getDeletec(),bean.getLoss(),bean.getOwnerMobile(),bean.getPropertyId(),bean.getRemark(),bean.getStartDate(),bean.getTimeStamp(),bean.getType(),bean.getOwnerName(),bean.getOwnerType(),bean.getOwnerId()};;
		int size = this.doorCardDao.insert(sql, params);
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
		String sql = "delete from door_card where id = ?";
		Object[] params = new Object[]{id};
		int size = this.doorCardDao.insert(sql, params);
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
	public ResultObject upd(@PathVariable Serializable id,DoorCard bean) {
		ResultObject result = new ResultObject();		
		String sql = "update door_card set available_time= ?,build_id= ?,card_num= ?,cell_id= ?,chip_id= ?,community_id= ?,deletec= ?,loss= ?,owner_mobile= ?,property_id= ?,remark= ?,start_date= ?,time_stamp= ?,type= ?,owner_name= ?,owner_type= ?,owner_id= ? where id= ?"; 
		Object[] params = new Object[]{bean.getAvailableTime(),bean.getBuildId(),bean.getCardNum(),bean.getCellId(),bean.getChipId(),bean.getCommunityId(),bean.getDeletec(),bean.getLoss(),bean.getOwnerMobile(),bean.getPropertyId(),bean.getRemark(),bean.getStartDate(),bean.getTimeStamp(),bean.getType(),bean.getOwnerName(),bean.getOwnerType(),bean.getOwnerId(),bean.getId()};;
		int size = this.doorCardDao.insert(sql, params);
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
