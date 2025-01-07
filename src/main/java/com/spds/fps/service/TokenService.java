package com.spds.fps.service;

import org.springframework.security.core.Authentication;

/***
 * 
 *@author abinjola
 *This class was creaded on 02-Dec-2024.
 */
public interface TokenService {


	public Authentication getAuthentication(String token) throws Exception;

}
