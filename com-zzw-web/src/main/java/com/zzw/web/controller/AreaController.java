package com.zzw.web.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.zzwtec.common.bean.basedata.Area;
import com.zzwtec.common.util.RestHelper;

@Controller
@RequestMapping("/area")
public class AreaController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RestTemplate restTemplate;

	
    /**
     * 小区详情
     * @param id
     * @param model
     * @return
     */
	@GetMapping("/{id}")
	public String findById(@PathVariable Serializable id,ModelMap model) {		
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/area/" + id, ResultObject.class);			
		model.put("area", result.getData());
		return "area";
	}

	/**
	 * 小区类别
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String listAll(ModelMap model) {		
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/area/list", ResultObject.class);
		model.put("list", result.getData());
		return "area_list";
	}
	
	/**
	 * 添加小区界面
	 * @return
	 */
	@GetMapping("/add")
	//@RequiresPermissions("area:add") // 权限管理;
	public String addUserUI() {		
		return "area_add";
	}
	
	/**
	 * 添加小区
	 * @param bean
	 * @return
	 */
	@PostMapping("/add")
	public String add(Area bean) {			
		ResultObject result = restTemplate.postForObject("http://COM-ZZW-BASEDATA-SERVICE/area/add",bean, ResultObject.class);
		if(result.getCode() == 0){
			System.out.println("添加区域成");
		}
		return "redirect:/area/list";
	}
	
	/**
	 * 删除小区
	 * @param id
	 * @return
	 */
	@PostMapping("/{id}")
	public String del(@PathVariable Serializable id) {
		ResponseEntity<ResultObject> result = restTemplate.exchange("http://COM-ZZW-BASEDATA-SERVICE/area/"+id, HttpMethod.DELETE, null, ResultObject.class);				
		logger.info("code:"+result.getStatusCodeValue());
		return "redirect:/area/list";
	}
	
	/**
	 * 编辑小区 
	 * @return
	 */
	@GetMapping("/edit/{id}")	
	public String editUI(@PathVariable("id") Long id,ModelMap model) {		
		ResultObject result = restTemplate.getForObject("http://COM-ZZW-BASEDATA-SERVICE/area/" + id, ResultObject.class);	
		model.put("area", result.getData());
		return "area_edit";
	}
	
	/**
	 * 提交编辑小区
	 * @param id
	 * @param bean
	 * @return
	 */
	@PostMapping("/upd/{id}")
	public String upd(@PathVariable Serializable id,Area bean) {
		RestHelper rest = new RestHelper(restTemplate);		
		ResultObject result = rest.put("http://COM-ZZW-BASEDATA-SERVICE/area", bean);
		logger.info("code:"+result.getCode());
		return "redirect:/area/list";
	}
	
}
