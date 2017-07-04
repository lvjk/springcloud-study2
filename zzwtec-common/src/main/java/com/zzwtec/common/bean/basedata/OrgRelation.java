package com.zzwtec.common.bean.basedata;

public class OrgRelation {
	
	private String orgId;
	private Integer orgLevel;
	private String parentId;
	
	
	public void setOrgId(String orgId){		 
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return this.orgId;
	}
	
	public void setOrgLevel(Integer orgLevel){		 
		this.orgLevel = orgLevel;
	}
	
	public Integer getOrgLevel(){
		return this.orgLevel;
	}
	
	public void setParentId(String parentId){		 
		this.parentId = parentId;
	}
	
	public String getParentId(){
		return this.parentId;
	}
}
