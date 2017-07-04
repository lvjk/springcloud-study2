package com.zzwtec.common.bean.basedata;

public class Property {
	
	private String id;
	private String address;
	private Boolean deletec;
	private String name;
	private String phone;
	private String remark;
	
	
	public void setId(String id){		 
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setAddress(String address){		 
		this.address = address;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setDeletec(Boolean deletec){		 
		this.deletec = deletec;
	}
	
	public Boolean getDeletec(){
		return this.deletec;
	}
	
	public void setName(String name){		 
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setPhone(String phone){		 
		this.phone = phone;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
}
