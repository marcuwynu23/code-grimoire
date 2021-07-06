package com.github.peculiar.codeGrimoire.model; 



public class ContentData implements java.io.Serializable{
	private String content;

	public ContentData(String content){
		this.content = content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent(){
		return content;
	}
}