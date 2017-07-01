package com.zzw.domain.basedata;

public class RolePermission {
	
	private String roleId;
	private String permissionId;
	
	
	public void setRoleId(String roleId){		 
		this.roleId = roleId;
	}
	
	public String getRoleId(){
		return this.roleId;
	}
	
	public void setPermissionId(String permissionId){		 
		this.permissionId = permissionId;
	}
	
	public String getPermissionId(){
		return this.permissionId;
	}
}
