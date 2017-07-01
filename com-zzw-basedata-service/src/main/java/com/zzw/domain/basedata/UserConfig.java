package com.zzw.domain.basedata;

public class UserConfig {
	
	private String id;
	private Boolean deletec;
	private Boolean opendoorunalert;
	private String remark;
	private String uncalltime;
	private String userId;
	private String wxset;
	
	
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
	
	public void setOpendoorunalert(Boolean opendoorunalert){		 
		this.opendoorunalert = opendoorunalert;
	}
	
	public Boolean getOpendoorunalert(){
		return this.opendoorunalert;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setUncalltime(String uncalltime){		 
		this.uncalltime = uncalltime;
	}
	
	public String getUncalltime(){
		return this.uncalltime;
	}
	
	public void setUserId(String userId){		 
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setWxset(String wxset){		 
		this.wxset = wxset;
	}
	
	public String getWxset(){
		return this.wxset;
	}
}
