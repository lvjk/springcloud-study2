package com.zzw.domain.basedata;

public class Cell {
	
	private String id;
	private String address;
	private String callphone;
	private Boolean cancall;
	private Boolean deletec;
	private String name;
	private String num;
	private String remark;
	private String userId;
	
	
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
	
	public void setCallphone(String callphone){		 
		this.callphone = callphone;
	}
	
	public String getCallphone(){
		return this.callphone;
	}
	
	public void setCancall(Boolean cancall){		 
		this.cancall = cancall;
	}
	
	public Boolean getCancall(){
		return this.cancall;
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
	
	public void setNum(String num){		 
		this.num = num;
	}
	
	public String getNum(){
		return this.num;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setUserId(String userId){		 
		this.userId = userId;
	}
	
	public String getUserId(){
		return this.userId;
	}
}
