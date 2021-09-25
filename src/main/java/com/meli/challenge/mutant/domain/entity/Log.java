package com.meli.challenge.mutant.domain.entity;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class Log  extends TableServiceEntity  {
	

    /**
	 * @return the content
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	private String content;
    private String type;
    
    public Log(String messageId, String clientId){
    	this.partitionKey=messageId;
    	this.rowKey=clientId;
    }
    
	
	    
			
}
