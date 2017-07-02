package com.zzw.web.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.zzwtec.common.bean.ResultObject;



/**
 * 发送/获取 服务端数据(主要用于解决发送put,delete方法无返回值问题).
 * @author 草原狼
 *
 */
public class RestHelper {
	private RestTemplate restTemplate;
	
	public RestHelper(RestTemplate restTemplate){
		this.restTemplate = restTemplate;
	}	
	
	/**
	 * put 请求
	 * @param url
	 * @param request
	 * @param uriVariables
	 * @return
	 * @throws RestClientException
	 */
	public <T> ResultObject put(String url, T request, Object... uriVariables) throws RestClientException{		
		HttpEntity<T> requestEntity = new HttpEntity<T>(request);
		if(request == null){
			requestEntity = null;
		}
		ResponseEntity<ResultObject> result = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, ResultObject.class,uriVariables);
		return result.getBody();
	}
	
	/**
	 * put 请求
	 * @param url
	 * @param request
	 * @param uriVariables
	 * @return
	 * @throws RestClientException
	 */
	public <T> ResultObject delete(String url, T request, Object... uriVariables) throws RestClientException{		
		HttpEntity<T> requestEntity = new HttpEntity<T>(request);
		if(request == null){
			requestEntity = null;
		}
		ResponseEntity<ResultObject> result = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, ResultObject.class,uriVariables);
		return result.getBody();
	}
	
}
