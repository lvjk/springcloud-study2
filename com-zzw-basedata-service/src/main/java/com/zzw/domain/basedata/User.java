package com.zzw.domain.basedata;

public class User {
	
	private String id;
	private Boolean deletec;
	private String loginphone;
	private Boolean msgcheck;
	private String name;
	private String openpsw;
	private String psw;
	private String remark;
	private String faceToken;
	private Boolean wechatBing;
	private String wechatOpenid;
	
	
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
	
	public void setLoginphone(String loginphone){		 
		this.loginphone = loginphone;
	}
	
	public String getLoginphone(){
		return this.loginphone;
	}
	
	public void setMsgcheck(Boolean msgcheck){		 
		this.msgcheck = msgcheck;
	}
	
	public Boolean getMsgcheck(){
		return this.msgcheck;
	}
	
	public void setName(String name){		 
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setOpenpsw(String openpsw){		 
		this.openpsw = openpsw;
	}
	
	public String getOpenpsw(){
		return this.openpsw;
	}
	
	public void setPsw(String psw){		 
		this.psw = psw;
	}
	
	public String getPsw(){
		return this.psw;
	}
	
	public void setRemark(String remark){		 
		this.remark = remark;
	}
	
	public String getRemark(){
		return this.remark;
	}
	
	public void setFaceToken(String faceToken){		 
		this.faceToken = faceToken;
	}
	
	public String getFaceToken(){
		return this.faceToken;
	}
	
	public void setWechatBing(Boolean wechatBing){		 
		this.wechatBing = wechatBing;
	}
	
	public Boolean getWechatBing(){
		return this.wechatBing;
	}
	
	public void setWechatOpenid(String wechatOpenid){		 
		this.wechatOpenid = wechatOpenid;
	}
	
	public String getWechatOpenid(){
		return this.wechatOpenid;
	}
}
