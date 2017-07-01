package com.zzw.domain.basedata;

public class CommunityConfig {
	
	private String id;
	private String machineType;
	private String services;
	private String devicePicture;
	private String doorbellConfigure;
	private String enclosureConfigure;
	private String pushConfigure;
	private String telephone;
	
	
	public void setId(String id){		 
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setMachineType(String machineType){		 
		this.machineType = machineType;
	}
	
	public String getMachineType(){
		return this.machineType;
	}
	
	public void setServices(String services){		 
		this.services = services;
	}
	
	public String getServices(){
		return this.services;
	}
	
	public void setDevicePicture(String devicePicture){		 
		this.devicePicture = devicePicture;
	}
	
	public String getDevicePicture(){
		return this.devicePicture;
	}
	
	public void setDoorbellConfigure(String doorbellConfigure){		 
		this.doorbellConfigure = doorbellConfigure;
	}
	
	public String getDoorbellConfigure(){
		return this.doorbellConfigure;
	}
	
	public void setEnclosureConfigure(String enclosureConfigure){		 
		this.enclosureConfigure = enclosureConfigure;
	}
	
	public String getEnclosureConfigure(){
		return this.enclosureConfigure;
	}
	
	public void setPushConfigure(String pushConfigure){		 
		this.pushConfigure = pushConfigure;
	}
	
	public String getPushConfigure(){
		return this.pushConfigure;
	}
	
	public void setTelephone(String telephone){		 
		this.telephone = telephone;
	}
	
	public String getTelephone(){
		return this.telephone;
	}
}
