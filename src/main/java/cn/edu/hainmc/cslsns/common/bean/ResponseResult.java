package cn.edu.hainmc.cslsns.common.bean;

import com.fasterxml.jackson.annotation.JsonInclude;

import cn.edu.hainmc.cslsns.common.enums.ResponseErrorEnum;

/**
 * ResponseResult Restful接口返回统一数据格式
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {
	/*
	 * 属性
	 */
	// 业务自定义的状态码
	// 不提供直接设置Code的接口，只能通过setCodeInfo方法设置错误信息
	private Integer code;
	// 返回消息
	private String message;
	// 返回数据实体
	private T data;

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	// 方法
	private ResponseResult() {
	}

	public static <T> ResponseResult<T> newInstance() {
		return new ResponseResult<>();
	}

	// 设置code信息
	public void setCodeInfo(ResponseErrorEnum responseErrorEnum) {
		this.code = responseErrorEnum.getCode();
		this.message = responseErrorEnum.getMessage();
	}
}