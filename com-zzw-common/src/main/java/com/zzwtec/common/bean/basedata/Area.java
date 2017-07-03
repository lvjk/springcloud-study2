package com.zzwtec.common.bean.basedata;

public class Area {
	
	private String id;
	private String area;
	private Boolean deletec;
	private Boolean isuse;
	private String name;
	private String remark;
	
	
	public void setId(String id){		 
		this.id = id;
	}
	
	public String getId(){
		return this.id;
	}
	
	public void setArea(String area){		 
		this.area = area;
	}
	
	public String getArea(){
		return this.area;
	}
	
	public void setDeletec(Boolean deletec){		 
		this.deletec = deletec;
	}
	
	public Boolean getDeletec(){
		return this.deletec;
	}
	
	public void setIsuse(Boolean isuse){		 
		this.isuse = isuse;
	}
	
	public Boolean getIsuse(){
		return this.isuse;
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
