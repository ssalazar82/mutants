/**
 * CorsFilter.java
 *
 * @description: Intercepta las respuestas de las apis a los cliente e inyecta la información relacionada con CORS.
 * @author SERGIO SALAZAR.
 * @version 1.0
 * @date 16-09-2021.
 **/

package com.meli.challenge.mutant.application;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {


	/**
	 * Inyecta las cabeceras http realacioandas con CORS.
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, content-type, Authorization, authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig filterConfig) {
		// No action
	}

	@Override
	public void destroy() {
		// No action
	}
}
