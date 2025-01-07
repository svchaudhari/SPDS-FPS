package com.spds.fps.exception;

public class ResourceNotFoundException extends RuntimeException {
	/**
	 * Custom Exception Class.
	 * Created by Harsh Raj on 20-Dec-2024.
	 */
	private static final long serialVersionUID = 8507787087233008597L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
