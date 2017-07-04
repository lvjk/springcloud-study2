package com.zzwtec.common.bean;

/**
 * rest接口响应结果
 * @author 草原狼
 * @date 2017-6-29
 */
public class ResultObject {
	
	public int code = 0;
	private String msg = "返回结果";
	private Object data;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
