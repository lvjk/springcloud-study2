package com.zzw.domain.basedata;

public class UserCustomPermission {
	
	private String userId;
	private String customPermissionId;
	private String orgId;
	
	
	public void setUserId(String userId){		 
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setCustomPermissionId(String customPermissionId){		 
		this.customPermissionId = customPermissionId;
	}
	
	public String getCustomPermissionId(){
		return this.customPermissionId;
	}
	
	public void setOrgId(String orgId){		 
		this.orgId = orgId;
	}
	
	public String getOrgId(){
		return this.orgId;
	}
}
