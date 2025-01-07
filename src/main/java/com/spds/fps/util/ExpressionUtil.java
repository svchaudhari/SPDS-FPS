package com.spds.fps.util;

import org.mvel2.MVEL;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abinjola This class was creaded on 19-Dec-2024.
 */
@Slf4j
public class ExpressionUtil {

	private ExpressionUtil() {
		throw new IllegalStateException("ExpressionUtil class");
	}

	/**
	 * Method to validated Object against expression condition
	 * 
	 * @param expression
	 * @param data
	 * @return
	 */

	public static Boolean validateExpression(String expression, Object data) {
		Boolean output = false;
		try {

			output = MVEL.eval(expression, data, Boolean.class);
		} catch (Exception e) {
			log.error("Exception was encountered while executing MVEL: {}", expression);
		}
		log.info("Expression:{},data:{},output:{}", expression, data, output);
		return output;
	}
}
