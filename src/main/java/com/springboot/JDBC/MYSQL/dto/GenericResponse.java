package com.springboot.JDBC.MYSQL.dto;

import java.util.List;

public class GenericResponse<T> {
	private String status;
	
	private String message;
	
	private List<T> dataList;
	
	private T data;
	
	public GenericResponse() {
		
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public GenericResponse(String status, String message, List<T> dataList, T data) {
		super();
		this.status = status;
		this.message = message;
		this.dataList = dataList;
		this.data = data;
	}
	
	

}
