package com.meli.challenge.mutant.application.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {

	private String tokenUrl;
	private String client;
	private String secret;

	/**
	 * @return the tokenUrl
	 */
	public String getTokenUrl() {
		return tokenUrl;
	}

	/**
	 * @param tokenUrl the tokenUrl to set
	 */
	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	public String getClient() {
		return client;
	}

	public String getSecret() {
		return secret;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}



}
