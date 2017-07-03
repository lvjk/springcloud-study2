package com.zzwtec.common.bean.basedata;

public class SysUser {
	
	private String id;
	private String roleId;
	private Boolean deletec;
	private String name;
	private String psw;
	private String remark;
	
	
	public void setId(String id){		 
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setRoleId(String roleId){		 
		this.roleId = roleId;
	}
	
	public String getRoleId(){
		return this.roleId;
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
	
	public void setPsw(String psw){		 
		this.psw = psw;
	}
	
	public String getPsw(){
		return this.psw;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
}
