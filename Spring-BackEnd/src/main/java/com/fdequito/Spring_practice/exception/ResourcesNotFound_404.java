package com.fdequito.Spring_practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFound_404 extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldname;
	private Object fieldValue;
	
	public ResourcesNotFound_404(String resourceName, String fieldname, Object fieldValue) {
		super(String.format("%s not found with %s: '%s'", resourceName, fieldname, fieldValue));
		this.resourceName = resourceName;
		this.fieldname = fieldname;
		this.fieldValue = fieldValue;
	}
	
	public String getResourceName() {
		return resourceName;
	}
	
	public String getFieldname() {
		return fieldname;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
}
