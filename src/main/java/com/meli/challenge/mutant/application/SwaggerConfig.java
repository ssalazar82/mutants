/**
 * SwaggerConfig.java
 *
 * @description: Genera documentación de las apis utilizando el framework Swagger.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;
import com.meli.challenge.mutant.application.property.SwaggerProperties;

import springfox.documentation.service.Contact;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.ClientCredentialsGrant;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private SwaggerProperties swaggerProperties;
	private static final String SECURITY_DEFINITION ="Mutant-Oauth";
	private static final String CLIENT_ID="meli-mutant";
	private static final String CLIENT_SECRET="3568f96e-bff0-4033-b918-5fbdb40fe637";
	
	

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(Predicates.or(
						PathSelectors.regex("/mutant.*"),
						PathSelectors.regex("/stats.*")
						))
				.build()
				.apiInfo(apiInfo())
				.securitySchemes(Arrays.asList(securityScheme()))
				.securityContexts(Arrays.asList(securityContext()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Adn Mutant Test API",
				"Servicio Rest con las siguientes capacidades:" +
						"<br />1. Evaluar un humano para indicar si es mutante a través de ADN." +
						"<br />2. Estadisticas de análisis.",
						null,
						null,
						new Contact(
								"Sergio Salazar", null, null
								),
						null,
						null,
						Collections.emptyList()
				);
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder()
				.clientId(this.swaggerProperties.getClient())
				.clientSecret(this.swaggerProperties.getSecret())
				.build();
	}

	private SecurityScheme securityScheme() {
		GrantType grantType = new ClientCredentialsGrant(this.swaggerProperties.getTokenUrl());

		return new OAuthBuilder().name(SECURITY_DEFINITION)
				.grantTypes(Arrays.asList(grantType))
				.build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(
						Arrays.asList(new SecurityReference(SECURITY_DEFINITION, new AuthorizationScope[] {})))
				.forPaths(Predicates.or(
						PathSelectors.regex("/mutant.*"),
						PathSelectors.regex("/stats.*")
						))
				.build();
	}
}
