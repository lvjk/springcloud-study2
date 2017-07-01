package com.zzw.domain.basedata;

public class Role {
	
	private String id;
	private Boolean deletec;
	private String name;
	private String remark;
	private String orgId;
	
	
	public void setId(String id){		 
		this.id = id;
	}
	
	public String getId(){
		return this.id;
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
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setOrgId(String orgId){		 
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return this.orgId;
	}
}
