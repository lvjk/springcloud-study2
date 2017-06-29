package com.zzw.domain.basedata;

public class Community {
	
	private String id;
	private String address;
	private Boolean deletec;
	private Double latitude;
	private Double longitude;
	private String name;
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
	
	public void setLatitude(Double latitude){		 
		this.latitude = latitude;
	}
	
	public Double getLatitude(){
		return this.latitude;
	}
	
	public void setLongitude(Double longitude){		 
		this.longitude = longitude;
	}
	
	public Double getLongitude(){
		return this.longitude;
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
}
