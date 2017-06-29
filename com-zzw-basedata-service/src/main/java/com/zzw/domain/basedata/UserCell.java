package com.zzw.domain.basedata;

public class UserCell {
	
	private String userId;
	private String cellId;
	private Integer type;
	private Boolean deletec;
	private String remark;
	
	
	public void setUserId(String userId){		 
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setCellId(String cellId){		 
		this.cellId = cellId;
	}
	
	public String getCellId(){
		return this.cellId;
	}
	
	public void setType(Integer type){		 
		this.type = type;
	}
	
	public Integer getType(){
		return this.type;
	}
	
	public void setDeletec(Boolean deletec){		 
		this.deletec = deletec;
	}
	
	public Boolean getDeletec(){
		return this.deletec;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
}
